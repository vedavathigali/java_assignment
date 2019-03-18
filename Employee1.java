package com.examples.java.assignment;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Employee1 extends EmployeeService {
	public static void main(String args[])  {
		EmployeeService e1=new EmployeeService();
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
System.out.println("8.export data");
System.out.println("enter your choice");
	n=sc.nextInt();
switch(n) {
case 1:e1.addEmployee();
break;
case 2:System.out.println("enter which element u want to view");
int n1=sc.nextInt();
	e1.viewEmployeeById(n1);
break;
case 3:e1.viewEmployee();
break;
case 4:System.out.println("enter which element u want to delete");
       int n2=sc.nextInt();
	   e1.deleteEmployee(n2);
break;
case 5:System.out.println("enter which element u want to update");
int n3=sc.nextInt();
e1.updateEmployee(n3);
break;
case 6:e1.statistics();
break;
case 7:
	Callable<Boolean> importsThreads=new Callable<Boolean>() {
		public Boolean call() throws Exception{
			System.out.println(Thread.currentThread()+"waiting for 5s");
			Thread.sleep(5000);
			e1.importdata();
			return null;
		}
	};
	ExecutorService executors=Executors.newFixedThreadPool(3);
	//@suppressWarnings("unused")
	Future<Boolean> importfutures=executors.submit(importsThreads);
	System.out.println(Thread.currentThread().getName()+"export thread triggered");
	break;
case 8:Callable<Boolean> importsThreads1=new Callable<Boolean>() {
	public Boolean call() throws Exception{
		System.out.println(Thread.currentThread()+"waiting for 5s");
		Thread.sleep(5000);
		e1.export();
		return null;
	}
	};
	ExecutorService executors1=Executors.newFixedThreadPool(3);
	//@suppressWarnings("unused")
	Future<Boolean> importfutures1=executors1.submit(importsThreads1);
	System.out.println(Thread.currentThread().getName()+"export thread triggered");
	break;
	default:System.out.println("Wrong Choice");
}
System.out.println("do u want to continue(y/n)");

choice=sc.next().charAt(0);
}while(choice=='Y'||choice=='y');
	
	
	}}