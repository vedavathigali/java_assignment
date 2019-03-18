package com.examples.javaassignment;

public class EmployeeData {
	public int emp_Id;
    public String name;
    public int age;
    Double  salary;
    public String department;
    
    public EmployeeData(int id,String name,int age,Double salary,String department) {
    	super();
    	this.emp_Id=id;
    	this.name=name;
    	this.age=age;
    	this.salary=salary;
    	this.department=department;}
    
public int getEmp_Id() {
		return emp_Id;
	}

	public void setEmp_Id(int emp_Id) {
		this.emp_Id = emp_Id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}



}
