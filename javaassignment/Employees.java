package com.examples.javaassignment;

public class Employees implements Comparable{
    private String empName;
    private int empId;
    private int age;
    private String designation;
    private String department;
    private double salary;

    //parameterised constructor
    public Employees(String empName, int empId,  int age,String designation, String department, double salary) {
        super();
        this.empName = empName;
        this.empId = empId;
        this.age=age;
        this.designation = designation;
        this.department = department;
        this.salary = salary;
    }



    //getters and setters
    public String getEmpName() {
        return empName;
    }
    public void setEmpName(String empName) {
        this.empName = empName;
    }
    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employees [empName=" + empName + ", empId=" + empId +",age="+age + ", designation=" + designation + ", department="
                + department + ", salary=" + salary + "]";
    }
    public int compareTo(Object o) {
        // TODO Auto-generated method stub
        if(o instanceof Employees)
        {
            return this.getEmpName().compareTo(((Employees) o).getEmpName());
        }
        return 0;

    }


}
