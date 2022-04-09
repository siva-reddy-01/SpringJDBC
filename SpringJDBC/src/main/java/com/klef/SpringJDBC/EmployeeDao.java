package com.klef.SpringJDBC;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Scanner;

public class EmployeeDao {
	
	private JdbcTemplate JdbcTemplate;
	Scanner sc=new Scanner(System.in);

	public void setJdbcTemplate(JdbcTemplate JdbcTemplate) {
		this.JdbcTemplate = JdbcTemplate;
	}
	
	public int saveEmployee(Employee e)
	{
		System.out.println("Emter emp id");
		int id=sc.nextInt();
		System.out.println("Enter emp name");
		String name=sc.next();
		System.out.println("Enter emp dept");
		String dept=sc.next();
		
		e.setId(id);
		e.setName(name);
		e.setDept(dept);
		
		String qry="insert into emp values(?,?,?)";
		int result=JdbcTemplate.update(qry,e.getId(),e.getName(),e.getDept());
		
		return result;
	}
	
	public int updateEmployee(Employee e)
	{
		System.out.println("Enter emp Id to Update");
		int id=sc.nextInt();
		System.out.println("Enter emp Name");
		String name=sc.next();
		System.out.println("Enter emp dept");
		String dept=sc.next();
		
		e.setId(id);
		e.setName(name);
		e.setDept(dept);
		
		String qry="update emp set name=?,dept=? where id=?";
		int result=JdbcTemplate.update(qry,e.getName(),e.getDept(),e.getId());
		return result;
	}
	
	public int deleteEmployee(Employee e) 
	{
		System.out.println("Enter emp id to delete");
		int id=sc.nextInt();
		
	     e.setId(id);
	     
		String qry="Delete from emp where id=?";
		int result=JdbcTemplate.update(qry,e.getId());
		return result;
	}
}
