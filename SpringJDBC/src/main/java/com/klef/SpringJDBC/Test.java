package com.klef.SpringJDBC;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SuppressWarnings({"resource"})
public class Test {
	
	public static void main(String args[]) {
		
		ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
		EmployeeDao dao=(EmployeeDao) context.getBean("employeeDao");
		Employee emp=new Employee();
		
		int result=dao.saveEmployee(emp);
		System.out.println("Number of records Inserted: "+result);
	}
}
