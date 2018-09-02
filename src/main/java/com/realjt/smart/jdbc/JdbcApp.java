/**
 * JdbcApp.java
 */
package com.realjt.smart.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.realjt.smart.jdbc.SqliteActuator.Converter;
import com.realjt.smart.jdbc.SqliteActuator.ParameterFeeder;

/**
 * 
 * @author RealJt
 * @date 2018年7月7日
 */
public class JdbcApp
{
	public static void main(String[] args) throws SQLException
	{
		SqliteActuator sqliteActuator = SqliteActuator.getInstance();

		String sql = "select * from employee where salary > ?";
		List<Employee> employees = sqliteActuator.query(sql, new ParameterFeeder()
		{
			@Override
			public void setParameter(PreparedStatement preparedStatement) throws SQLException
			{
				preparedStatement.setDouble(1, 8000);
			}

		}, new Converter<Employee>()
		{
			@Override
			public Employee convert(ResultSet resultSet) throws SQLException
			{
				Employee employee = new Employee();

				employee.setId(resultSet.getInt("id"));
				employee.setName(resultSet.getString("name"));
				employee.setAge(resultSet.getInt("age"));
				employee.setPhone(resultSet.getString("phone"));
				employee.setSalary(resultSet.getDouble("salary"));
				employee.setDepartment(resultSet.getInt("department"));
				employee.setAddress(resultSet.getString("address"));

				return employee;
			}
		});

		System.out.println(employees);
		System.out.println(employees.size());

		Employee employee = sqliteActuator.queryObject("select * from employee where id = ?", new ParameterFeeder()
		{
			@Override
			public void setParameter(PreparedStatement preparedStatement) throws SQLException
			{
				preparedStatement.setDouble(1, 1);
			}

		}, new Converter<Employee>()
		{
			@Override
			public Employee convert(ResultSet resultSet) throws SQLException
			{
				Employee employee = new Employee();

				employee.setId(resultSet.getInt("id"));
				employee.setName(resultSet.getString("name"));
				employee.setAge(resultSet.getInt("age"));
				employee.setPhone(resultSet.getString("phone"));
				employee.setSalary(resultSet.getDouble("salary"));
				employee.setDepartment(resultSet.getInt("department"));
				employee.setAddress(resultSet.getString("address"));

				return employee;
			}
		});

		System.out.println(employee);
	}

}
