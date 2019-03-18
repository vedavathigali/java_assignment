package com.examples.javaassignment;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;

public class Employee2 extends Employeeservice1 {
	public static void main(String args[]) {
		Employeeservice1 e1=new Employeeservice1();
		Scanner sc=new Scanner(System.in);
int n;	
	char choice;
	
	do {
System.out.println("1.Add employee");
System.out.println("2.view employee by id");
System.out.println("3.View all employee");
System.out.println("4.Delete employee");
System.out.println("5. update employee");
System.out.println("6.statistics employee");
System.out.println("7.import");
System.out.println("8.export");
System.out.println("enter your choice");
	n=sc.nextInt();
switch(n) {
case 1:e1.addEmployee();
break;
case 2:System.out.println("enter which element u want to view");
int n1=sc.nextInt();
	e1.viewEmployeeById(n1);
break;
case 3:e1.viewEmployees();
break;
case 4:System.out.println("enter which element u want to delete");
       int n2=sc.nextInt();
	   e1.deleteEmployee(n2);
break;
case 5:System.out.println("enter which element u want to update");
int n3=sc.nextInt();
e1.updateEmployee();
break;
case 6:e1.statistics();
break;
case 7:try {
		e1.Import();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
break;
case 8:try {
		e1.Export();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
break;

default:System.out.println("please enter a valid choice");
}
System.out.println("do u want to continue(y/n)");
	
	 choice=sc.next().charAt(0);
	}while(choice=='Y'||choice=='y');
	
	
	}}


