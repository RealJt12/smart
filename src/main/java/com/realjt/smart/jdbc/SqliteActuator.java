package com.realjt.smart.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 * @author RealJt
 * @date 2018年7月7日
 */
public class SqliteActuator
{
	private static volatile SqliteActuator sqliteActuator;

	private Connection connection;

	public interface ParameterFeeder
	{
		/**
		 * 为sql语句形参赋值
		 * 
		 * @param preparedStatement
		 * @throws SQLException
		 */
		void setParameter(PreparedStatement preparedStatement) throws SQLException;
	}

	public static interface Converter<T>
	{
		/**
		 * sql查询结果转换成java对象
		 * 
		 * @param resultSet
		 * @return
		 * @throws SQLException
		 */
		T convert(ResultSet resultSet) throws SQLException;
	}

	private static final String JDBC_URL = "jdbc:mysql://192.168.0.107:3306/service";

	private static final String USERNAME = "realjt";

	private static final String PASSWORD = "realjt";

	private SqliteActuator()
	{
	}

	public static synchronized SqliteActuator getInstance()
	{
		if (null == sqliteActuator)
		{
			sqliteActuator = new SqliteActuator();

			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				sqliteActuator.connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
			}
			catch (ClassNotFoundException e)
			{
				e.printStackTrace();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}

		return sqliteActuator;
	}

	public void insert(String sql, ParameterFeeder parameterFeeder) throws SQLException
	{
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		if (null != parameterFeeder)
		{
			parameterFeeder.setParameter(preparedStatement);
		}

		preparedStatement.executeBatch();

		preparedStatement.close();
	}

	public void delete(String sql, ParameterFeeder parameterFeeder) throws SQLException
	{
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		if (null != parameterFeeder)
		{
			parameterFeeder.setParameter(preparedStatement);
		}

		preparedStatement.executeBatch();

		preparedStatement.close();
	}

	public void update(String sql, ParameterFeeder parameterFeeder) throws SQLException
	{
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		if (null != parameterFeeder)
		{
			parameterFeeder.setParameter(preparedStatement);
		}

		preparedStatement.executeBatch();

		preparedStatement.close();
	}

	public <R> List<R> query(String sql, ParameterFeeder parameterFeeder, Converter<R> converter) throws SQLException
	{
		List<R> results = new ArrayList<>();

		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		if (null != parameterFeeder)
		{
			parameterFeeder.setParameter(preparedStatement);
		}

		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next())
		{
			R r = converter.convert(resultSet);

			results.add(r);
		}

		resultSet.close();
		preparedStatement.close();

		return results;
	}

	public <R> R queryObject(String sql, ParameterFeeder parameterFeeder, Converter<R> converter) throws SQLException
	{
		List<R> results = new ArrayList<>();

		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		if (null != parameterFeeder)
		{
			parameterFeeder.setParameter(preparedStatement);
		}

		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next())
		{
			R r = converter.convert(resultSet);

			results.add(r);
		}

		resultSet.close();
		preparedStatement.close();

		if (results.size() >= 1)
		{
			return results.get(0);
		}

		return null;
	}

}
