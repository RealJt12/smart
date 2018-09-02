/**
 * Employee.java
 */
package com.realjt.smart.jdbc;

/**
 * 
 * @author RealJt
 * @date 2018年7月7日
 */
public class Employee
{
	private int id;

	private String name;

	private int age;

	private String phone;

	private double salary;

	private int department;

	private String address;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public double getSalary()
	{
		return salary;
	}

	public void setSalary(double salary)
	{
		this.salary = salary;
	}

	public int getDepartment()
	{
		return department;
	}

	public void setDepartment(int department)
	{
		this.department = department;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	@Override
	public String toString()
	{
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", phone=" + phone + ", salary=" + salary
				+ ", department=" + department + ", address=" + address + "]";
	}

}
