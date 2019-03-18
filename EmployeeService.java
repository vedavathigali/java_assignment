package com.examples.java.assignment;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

//has the operations like add,delete,update,view,viewall
public class EmployeeService {
	@SuppressWarnings({"rawtypes","unchecked"})
	TreeMap<Integer,Employees> employeeList = new TreeMap();
    Scanner sc=new Scanner(System.in);
   
//adding employee
	public void addEmployee() {
		boolean flag=false;
	boolean isNumber=false;
	int id=0;
System.out.println("enter your id");
do {
if(sc.hasNextInt()) {
	  id=sc.nextInt();
	 isNumber=true;
	 }
else{
	System.out.println("please enter a number");
	sc.next();
	}}while(!(isNumber));

 /*do {try {
		String id1=sc.next();
	int x=(Integer.parseInt(id1));
		
		break;
	}
	catch(Exception e) {
		flag=false;
		System.out.println("enter number not a string");
	}
	}while(flag==false);*/
	
	System.out.println("enter your name");
         String name=sc.next();
         String nametype="[a-zA-z]+";
         while(!flag) {
        	 if((name.matches(nametype))) {
        		 flag=true;
        	 }
        	 else {
        		 System.out.println("enter only alphabets");
        		 name=sc.next();
        		 
        	 }
         }
         
	  System.out.println("enter your age");
	  boolean isAge=false;
	  int age=0;
	 do {
		 if(sc.hasNextInt()) {
		 	  age=sc.nextInt();
		 	 isAge=true;
		 	 }
		 else{
		 	System.out.println("please enter a valid age");
		 	sc.next();
		 	}}while(!(isAge));

	 
	System.out.println("enter your salary");
double salary=sc.nextDouble();
	
	System.out.println("enter your department");
	String dept=sc.next();
	boolean isDept=false;
	String depttype1="[a-zA-z]+";
    while(!isDept) {
    	
   	 if((dept.matches(depttype1))) {
   		 isDept=true;
   	 }
   	 else {
   		 System.out.println("enter only alphabets");
   		 dept=sc.next();
   		 }
    } 
   	 
	
	Employees e =new Employees(id, name, age, salary, dept);
	
	employeeList.put(e.getEmp_Id(),e);
}
    
	public  void viewEmployee() {
		System.out.println("****************************Employee Details****************************************");
        System.out.println("------------------------------------------------------------------------------------");
    for( Object emp:employeeList.keySet())
        {
            System.out.println("employee name"+" :"+employeeList.get(emp).getName());
            System.out.println("employee age"+" :"+employeeList.get(emp).getAge());
            System.out.println("employee Emp_id"+" :"+employeeList.get(emp).getEmp_Id());
            System.out.println("employee salary"+" :"+employeeList.get(emp).getSalary());
            System.out.println("employee Department"+" :"+employeeList.get(emp).getDepartment());
        }

}
	public void viewEmployeeById(int id) {
		employeeList.get(id);
		System.out.println("------------------------------------------------------------------------------------");
    for( Object emp:employeeList.keySet())
        {
            System.out.println("employee name"+" :"+employeeList.get(emp).getName());
            System.out.println("employee age"+" :"+employeeList.get(emp).getAge());
            System.out.println("employee Emp_id"+" :"+employeeList.get(emp).getEmp_Id());
            System.out.println("employee salary"+" :"+employeeList.get(emp).getSalary());
            System.out.println("employee Department"+" :"+employeeList.get(emp).getDepartment());
        }
		
	}
	public  void deleteEmployee(int id) {
		
		System.out.println("deleted employee"+id);
		employeeList.remove(id);
		System.out.println("****************************Employee Details****************************************");
        System.out.println("------------------------------------------------------------------------------------");
    for( Object emp:employeeList.keySet())
        {
if(employeeList.get(emp).getEmp_Id()==0){
	System.out.println("employee doesnot exists");
			
		}
else{System.out.println("employee name"+" :"+employeeList.get(emp).getName());
            System.out.println("employee age"+" :"+employeeList.get(emp).getAge());
            System.out.println("employee Emp_id"+" :"+employeeList.get(emp).getEmp_Id());
            System.out.println("employee salary"+" :"+employeeList.get(emp).getSalary());
            System.out.println("employee Department"+" :"+employeeList.get(emp).getDepartment());
        }
        }

	
		}
	public void updateEmployee(int id1) {
		Scanner sc1=new Scanner(System.in);
		System.out.println("enter your name");
	         String name=sc1.next();
	        System.out.println("enter your age");
		 int age=sc1.nextInt();
		 Employees e =new Employees(employeeList.get(id1).getEmp_Id(),name,age,employeeList.get(id1).getSalary(),employeeList.get(id1).getDepartment());
		employeeList.replace(id1, e);
		
	
	}
		public void statistics() {
			int c=0;
		
			System.out.println("enter dept name");
			String dept=sc.next();
			for(Object o:employeeList.keySet()) {
				if(employeeList.get(o).getDepartment().equals(dept))
				{
				c++;
				
			}}
				System.out.println("no of employees in "+dept+"department is:"+c);
			
			
			int s=0;
			for(Object o:employeeList.keySet()) {
				if(employeeList.get(o).getSalary()>50000)
				{
				s++;
				
			}}
				System.out.println("no of employees whose salary is greater than 50000 is:"+s);
				System.out.println("--------------------statistics--------------");
				TreeMap<String,Integer> duplicates=new TreeMap<String,Integer>();
				for(Object o :employeeList.keySet()) {
					String dept1=employeeList.get(o).getDepartment();
					if(duplicates.containsKey(dept1)) {
						duplicates.put(dept1, duplicates.get(dept1)+1);
					}
					else {
						duplicates.put(dept1, 1);
					}
					
				}
				System.out.println("department \t Noof employees");
				
				for(Entry<String,Integer> entry : duplicates.entrySet()) {
				
				
			System.out.format("%s \t  %d \n",entry.getKey(),entry.getValue() );
			System.out.println("-------Highest salary---------");
			TreeSet <Double> salary=new TreeSet<Double> ();
			for(Object o:employeeList.keySet()) {
				double sal=employeeList.get(o).getSalary();
				salary.add(sal);
			}
			System.out.println("Highest salary:"+salary.last());
			System.out.println("-------lowest salary-------");
			System.out.println("lowest salary:"+salary.first());
			//System.out.println("employees whose salary is greater than 40000 using streams");
//employees having salary greater than 40000			
			long count = employeeList.values()
					.stream()
					.filter(e-> e.getSalary()> 40000)
					.count();
		System.out.println("salary greater than 40000 " + count);
//count of employees have age greater than 30
		long count1=employeeList.values().stream().filter(e->e.getAge()>30).count();
		System.out.println("no of employees having age greater than 30 yrs is" + count1);
//employee ids having  AGE greater than 30	
		List<Integer> x1=employeeList.values()
				.stream()
				.filter(e->e.getAge()>30)
				.map(a->a.emp_Id)
				.collect(Collectors.toList());
		System.out.println("employees having age greater than 30 yrs is" +x1);
		/*Map<Integer> c1=EmployeeList.values()
				.stream()
				.map(employee1::getDepartment)
				.collect()*/
//sum of salaries of all the employees
		
		double sum=employeeList.values()
				.stream()
				.map(Employees::getSalary)//method reference
				.reduce(0.0,(a,b)->a.doubleValue()+b.doubleValue()).doubleValue();
		System.out.println("sum of salaries of all the employees" +sum);
		
//no of employees in particular department
		
		Map<String, Long> groupByDept = 
				employeeList.values()
					.stream()
					.collect(Collectors.groupingBy(Employees::getDepartment, Collectors.counting()));
		System.out.println("no of employees in particular department"+groupByDept);
		
//average of all employee salaries	
		
		double avgSalary = employeeList.values()
				.stream()
				.collect(Collectors.averagingDouble(Employees::getSalary)).doubleValue();		
					// Supplier	=> Factory method to create new instance of container object
					// Accumulator => Accumulates partial output with current value
					// Combiner	=> Combines output of similar container into this container
		System.out.println("average salary of employees "+avgSalary);
		
//average of employee age department wise
		
		Map<String,Double> avgAge = employeeList.values()
				.stream()
.collect(Collectors.groupingBy(Employees::getDepartment,Collectors.averagingDouble(Employees::getAge)));	
					// Supplier	=> Factory method to create new instance of container object
					// Accumulator => Accumulates partial output with current value
					// Combiner	=> Combines output of similar container into this container
		System.out.println("average age of employees in particular department"+avgAge);
		
//count of employees in each department in sorted order	
		
		Map map=new TreeMap();
		map=employeeList
				.values()
				.stream()
	            .sorted(Comparator.comparing(Employees::getDepartment))
	            .collect(Collectors.groupingBy(Employees::getDepartment,TreeMap::new,Collectors.counting()));
		System.out.println("count according to the dept is "+map);
		
//department which has more than 3 employees
		List<Object> groupByDept1 = 
				employeeList.values()
					.stream()
					.collect(Collectors.groupingBy(Employees::getDepartment, Collectors.counting()))
					.entrySet()
					.stream()
					.filter(w->w.getValue()>3)
					.map(Map.Entry::getKey)
					.collect(Collectors.toList());
		System.out.println("departments having more than 3 employees"+groupByDept1);
//employee whose name start with s
				List<String> x2=
		
                     employeeList
                    		 .values()
                    		 .stream()
                    		 .filter(a->a.getName().charAt(0)=='s')
                    		 .map(a->a.getName())
                              .collect(Collectors.toList());
					System.out.println("employees whose name start with s"+x2);
//calculating age from date of birth	
					
					LocalDate today1= LocalDate.now();                          //Today's date
					LocalDate birthday = LocalDate.of(1997, Month.FEBRUARY, 28);  //Birth date
					 
					Period p = Period.between(birthday, today1);
					System.out.println("age of employee is"+p.getYears());
//calculating age from date of birth by taking input from user
					System.out.println("enter your dob");
					String date=sc.next();
					LocalDate today2= LocalDate.now();                          //Today's date
					LocalDate bday = LocalDate.parse(date);  //Birth date
					 
					Period p1 = Period.between(bday, today2);
					System.out.println("age of employee is"+p1.getYears());

	}
				
				
	}
		
	public synchronized void importdata() {
		//String file="D:\\files\\empdata.txt";
		try {
			Employees  emp=new Employees();
			BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("D:\\files\\edata.txt")));
			String line;
			while((line=br.readLine())!=null)
			{
				String[] array=line.split(",");
				//int id=Integer.parseInt(array[0]);
				String name=array[1];
				int age=Integer.parseInt(array[2]);
				Double salary=Double.parseDouble(array[3]);
				String department=array[4];
				emp=new  Employees(emp.getEmp_Id(),name,age,salary,department);
				employeeList.put(emp.getEmp_Id(),emp);
				
				}
			System.out.println("imported succesfully");
			br.close();
		}catch(IOException e) {
			System.out.println("unable to read file");
			e.printStackTrace();
		}
		
		
	}
	public synchronized void export() throws IOException{
		BufferedWriter bw=null;
		String str="";
		try {
			File file=new File("D:\\files\\edata.txt");
			if(!file.exists()) {
				file.createNewFile();
				
			}
			FileWriter fw=new FileWriter(file);
			bw=new BufferedWriter(fw);
			for(Map.Entry<Integer, Employees> entry:employeeList.entrySet()) {
				str="key:"+entry.getKey()+"value:"+entry.getValue();
				bw.write(str);
				bw.newLine();
				bw.flush();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("file written succesfully");
		
	}

	@Override
	public String toString() {
		return "EmployeeService [employeeList=" + employeeList + "]";
	}
	

		}
