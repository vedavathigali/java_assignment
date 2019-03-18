package com.examples.javaassignment;
import java.util.*;

import java.util.Map.Entry;
import java.util.stream.Collectors;

import java.sql.Statement;
import java.sql.Connection;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;


public class Employeeservice1 {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/jdbcassignment";//jdbc i drivername
	//mysql is database and jdbc is schema name

	// Database credentials
	static final String USER = "root";
	static final String PASS = "pass@word1";
	Connection conn=null;
	Statement stmt =null;
	
	public Employeeservice1() {
		try {

			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("connection established");
		}
		catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} 
		
		
	}
	Scanner sc=new Scanner(System.in);
	//adding employee
	public void addEmployee() {
		System.out.println("add method called");
		System.out.println("enter name");
		String ename=sc.next();
		System.out.println("enter id");
		int eid=sc.nextInt();
		System.out.println("enter age");
		int eage=sc.nextInt();
		System.out.println("enter designation");
		String edes=sc.next();
		System.out.println("enter department");
		String edept=sc.next();
		System.out.println("enter salary");
		Double esalary=sc.nextDouble();
		String insertQuery="INSERT INTO employeeManagement values(?,?,?,?,?,?)";
		try {
		PreparedStatement pst=conn.prepareStatement(insertQuery);
		
		pst.setString(1,ename);
		pst.setInt(2,eid);
		pst.setInt(3, eage);
		pst.setString(4, edes);
		pst.setString(5, edept);
		pst.setDouble(6,esalary );
	     pst.execute();
		}catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} 
		
		}
	public void updateEmployee() {
		System.out.println("1.update employee name");
		System.out.println("2.update employee id");
		System.out.println("3.update employee age");
		System.out.println("4.update employee designation");
		System.out.println("5.update employee department");
		System.out.println("6.update employee salary");
		System.out.println("7.update all details");
		System.out.println("enter your choice");
		int c=sc.nextInt();
		switch(c) {
		case 1:
			String updatename="update employeeManagement set ename=? where eid=?";
			try {
				PreparedStatement pst=conn.prepareStatement(updatename);
				System.out.println("enter id to update");
				pst.setInt(2, sc.nextInt());
				System.out.println("enter the employee name");
				pst.setString(1,sc.next());
				pst.execute();
				}catch (SQLException se) {
					// Handle errors for JDBC
					se.printStackTrace();
				} catch (Exception e) {
					// Handle errors for Class.forName
					e.printStackTrace();
				}
			break;
		case 2:
			String updateid="update employeeManagement set eid=? where eid=?";
			try {
				PreparedStatement pst=conn.prepareStatement(updateid);
				System.out.println("enter id where to update");
				pst.setInt(2, sc.nextInt());
				System.out.println("enter the id");
				pst.setInt(1,sc.nextInt());
				pst.execute();
				}catch (SQLException se) {
					// Handle errors for JDBC
					se.printStackTrace();
				} catch (Exception e) {
					// Handle errors for Class.forName
					e.printStackTrace();
				}
			break;
		
	case 3:
		String updateage="update employeeManagement set eage=? where eid=?";
		try {
			PreparedStatement pst=conn.prepareStatement(updateage);
			System.out.println("enter id where to update");
			pst.setInt(2, sc.nextInt());
			System.out.println("enter the age");
			pst.setInt(1,sc.nextInt());
			pst.execute();
			}catch (SQLException se) {
				// Handle errors for JDBC
				se.printStackTrace();
			} catch (Exception e) {
				// Handle errors for Class.forName
				e.printStackTrace();
			}
		break;
	case 4:
		String updatedes="update employeeManagement set edes=? where eid=?";
		try {
			PreparedStatement pst=conn.prepareStatement(updatedes);
			System.out.println("enter id where to update");
			pst.setInt(2, sc.nextInt());
			System.out.println("enter the designation");
			pst.setString(1,sc.next());
			pst.execute();
			}catch (SQLException se) {
				// Handle errors for JDBC
				se.printStackTrace();
			} catch (Exception e) {
				// Handle errors for Class.forName
				e.printStackTrace();
			}
		break;
	case 5:
		String updatedep="update employeeManagement set edep=? where eid=?";
		try {
			PreparedStatement pst=conn.prepareStatement(updatedep);
			System.out.println("enter id where to update");
			pst.setInt(2, sc.nextInt());
			System.out.println("enter the department");
			pst.setString(1,sc.next());
			pst.execute();
			}catch (SQLException se) {
				// Handle errors for JDBC
				se.printStackTrace();
			} catch (Exception e) {
				// Handle errors for Class.forName
				e.printStackTrace();
			}
		break;
	case 6:
		String updatesalary="update employeeManagement set esalary=? where eid=?";
		try {
			PreparedStatement pst=conn.prepareStatement(updatesalary);
			System.out.println("enter id where to update");
			pst.setInt(2, sc.nextInt());
			System.out.println("enter the salary");
			pst.setDouble(1,sc.nextDouble());
			pst.execute();
			}catch (SQLException se) {
				// Handle errors for JDBC
				se.printStackTrace();
			} catch (Exception e) {
				// Handle errors for Class.forName
				e.printStackTrace();
			}
		break;
	case 7:
		String updateEmployee="update employeeManagement set ename=?,eid=?,eage=?,edes=?,edept=?,esalary=? where eid=?";
		try {
			PreparedStatement pst=conn.prepareStatement(updateEmployee);
			System.out.println("enter id where to update");
			pst.setInt(7, sc.nextInt());
			System.out.println("enter the employee name");
			pst.setString(1,sc.next());
			System.out.println("enter the id");
			pst.setInt(2,sc.nextInt());
			System.out.println("enter the age");
			pst.setInt(3,sc.nextInt());
			System.out.println("enter the designation");
			pst.setString(4,sc.next());
			System.out.println("enter the department");
			pst.setString(5,sc.next());
			System.out.println("enter the salary");
			pst.setDouble(6,sc.nextDouble());
			pst.execute();
			
		}catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
	break;
	default:System.out.println("invalid option");
}
}
	public void viewEmployeeById(int eid) {
		String searche="select eid from employeeManagement where eid=?";
		String viewemp="select * from employeeManagement where eid=?";
		try {
			PreparedStatement pst1=conn.prepareStatement(searche);
			pst1.setInt(1, eid);
			ResultSet rs1=pst1.executeQuery();
			if(rs1.next()) { 
				try{
		PreparedStatement pst=conn.prepareStatement(viewemp);
		pst.setInt(1, eid);
		ResultSet rs=pst.executeQuery();
		while(rs.next()) {
			
			
			String name = rs.getString("ename");
			int empid = rs.getInt("eid");
			int age = rs.getInt("eage");
			String designation = rs.getString("edes");
			String department = rs.getString("edept");
			Double salary=rs.getDouble("esalary");
// Display values
			System.out.print(" Name: " + name);
			System.out.print("ID: " + empid);
			System.out.print(", Age: " + age);
			System.out.print(", Designation: " + designation);
			System.out.print(", Department: " + department);
			System.out.println(",Salary:"+salary);
			
		System.out.println();
		}}catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
			}}
		else {
			System.out.println("Employee not found");
		}
		}catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
		
	}
	public  void deleteEmployee(int eid) {
		
		String searchemp="select eid from employeeManagement where eid=?";
		String delemp="delete from employeeManagement where eid=?";
		try {
			PreparedStatement pst=conn.prepareStatement(searchemp);
			pst.setInt(1, eid);
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				try {
					PreparedStatement pst1=conn.prepareStatement(delemp);
					pst1.setInt(1, eid);
					pst1.execute();
					System.out.println("employee deleted sucessfully");
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			else {
				System.out.println("Employee not found");
			}
		}catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
}
	public void viewEmployees() {
		String viewemp="select * from employeeManagement";
		try {
		 stmt =  conn.createStatement();
		 ResultSet rs=stmt.executeQuery(viewemp);
			while(rs.next()) {
				
				
				String name = rs.getString("ename");
				int empid = rs.getInt("eid");
				int age = rs.getInt("eage");
				String designation = rs.getString("edes");
				String department = rs.getString("edept");
				Double salary=rs.getDouble("esalary");
	// Display values
				System.out.print(" Name: " + name);
				System.out.print("ID: " + empid);
				System.out.print(", Age: " + age);
				System.out.print(", Designation: " + designation);
				System.out.print(", Department: " + department);
				System.out.println(",Salary:"+salary);
				
			System.out.println();
		 
		}}catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
		
		
	}
	
		public void statistics() {
			//no of employees in each  department
		String noemplys="select edept, count(eid) from employeeManagement group by edept";
		try {
			stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(noemplys);
			System.out.println("no of employees in each department " );
			while(rs.next()) {
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				
			}}catch (SQLException se) {
				// Handle errors for JDBC
				se.printStackTrace();
			} catch (Exception e) {
				// Handle errors for Class.forName
				e.printStackTrace();
			}
	//employees whose salary is greater than 50000
		String empg="select * from employeeManagement where esalary>50000";
		try {
			stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(empg);
			System.out.println("no of employees having salary greater than 50000" );
			while(rs.next()) {
				String name = rs.getString("ename");
				Double salary=rs.getDouble("esalary");
				
				System.out.print(" Name: " + name);
				System.out.println(",Salary:"+salary);
				
				
				
			}}catch (SQLException se) {
				// Handle errors for JDBC
				se.printStackTrace();
			} catch (Exception e) {
				// Handle errors for Class.forName
				e.printStackTrace();
			}
//employees whose name start with v
		String sname="select * from employeeManagement where ename LIKE 'v%'";
		try {
			stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sname);
			System.out.println("employees whose name start with v" );
			while(rs.next()) {
				String name = rs.getString("ename");
		System.out.print(" Name: " + name);
		System.out.println();
		}}catch (SQLException se) {
				// Handle errors for JDBC
				se.printStackTrace();
			} catch (Exception e) {
				// Handle errors for Class.forName
				e.printStackTrace();
			}
//highest salary
		String maxsal="select ename,max(esalary)  as esalary from employeeManagement";
		try {
			stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(maxsal);
			System.out.println("employee having the highest salary" );
			while(rs.next()) {
				
				Double salary=rs.getDouble("esalary");
				System.out.println("name"+":"+rs.getString("ename")+":");
		
		System.out.println(salary);
		System.out.println();
		}}catch (SQLException se) {
				// Handle errors for JDBC
				se.printStackTrace();
			} catch (Exception e) {
				// Handle errors for Class.forName
				e.printStackTrace();
			}
//lowest salary
		String lowestsal="select ename,min(esalary) as esalary from employeeManagement";
		try {
			stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(lowestsal);
			System.out.println("employee having the lowest salary" );
			while(rs.next()) {
				
				Double salary=rs.getDouble("esalary");
				System.out.println("name"+":"+rs.getString("ename"));
		
		System.out.println(salary);
		System.out.println();
		}}catch (SQLException se) {
				// Handle errors for JDBC
				se.printStackTrace();
			} catch (Exception e) {
				// Handle errors for Class.forName
				e.printStackTrace();
			}
		//employees having age greater than 30
		String empage="select ename,eage,count(eid) from employeeManagement where eage>30 group by edept";
		try {
			stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(empage);
			System.out.println("employee having the age greater than 30" );
			while(rs.next()) {
				
				
				System.out.println("name"+":"+rs.getString("ename"));
		System.out.println("age"+":"+rs.getInt("eage"));
		System.out.println(rs.getString(3));
		
		System.out.println();
		}}catch (SQLException se) {
				// Handle errors for JDBC
				se.printStackTrace();
			} catch (Exception e) {
				// Handle errors for Class.forName
				e.printStackTrace();
			}
		
}
		public void Import() throws IOException {
		       String O;int ctr=0;
		       try {
		       BufferedReader br=new BufferedReader(new FileReader("D:\\\\files\\\\empdbimport.txt"));
		       while((O=br.readLine())!=null) {
		           ctr++;
		           String[] array=O.split(",");

		           String insertQuery="insert into EmployeeManagement values(?,?,?,?,?,?)";
		           try
		           {
		           PreparedStatement pstmt = conn.prepareStatement(insertQuery);
		            pstmt.setString(1, array[0]);
		            pstmt.setInt(2, Integer.parseInt(array[1]));
		            pstmt.setInt(3, Integer.parseInt(array[2]));
		            pstmt.setString(4, array[3]);
		            pstmt.setString(5, array[4]);
		            pstmt.setDouble(6, Double.parseDouble(array[5]));
		            pstmt.execute();
		       }catch (SQLException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        }

		       System.out.println(ctr+" Employees Imported Successfully");

		   }
		       br.close();
		       }
		       catch(FileNotFoundException e) {
		           e.printStackTrace();
		       }
		       catch(Exception e) {
		           e.printStackTrace();
		       }
		   }

		public void Export()throws IOException {

	        try {
	            List<Employees> empList=new ArrayList();

	            String fetchQuery="select * from EmployeeManagement";
	            try {
	                Statement stmt= conn.createStatement();
	                ResultSet rs=stmt.executeQuery(fetchQuery);
	                while(rs.next())
	                {
	                    String name=rs.getString(1);
	                    int id=rs.getInt(2);
	                    int age=rs.getInt(3);
	                    String designation=rs.getString(4);
	                    String dept=rs.getString(5);
	                    double sal=rs.getDouble(6);
	                    empList.add(new Employees(name, id, age,  designation, dept, sal));
	                }
	            } catch (SQLException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	           BufferedWriter br=new BufferedWriter(new FileWriter("D:\\files\\empdbexport.txt"));
	           br.write("\t\t    #######################################################################################################\n");

	           br.write("\t\tName: \t\t Id: \t\t Age: \t\t Designation: \t\t  Department: \t\t  Salary:\n");
	           br.write("\t\t    #######################################################################################################\n");
	           for(Employees el:empList) {
	               br.write("\t\t\t"+el.getEmpName()+"\t\t\t"+el.getEmpId()+"\t\t\t"+el.getAge()+"\t\t\t"+el.getDesignation()+"\t\t\t"+el.getDepartment()+"\t\t\t"+el.getSalary()+"\n");
	               br.write("\t\t    --------------------------------------------------------------------------------------------------------\n");

	       }
	       br.close();

	   }
	       catch(FileNotFoundException e) {
	           e.printStackTrace();
	       }
	       catch(Exception e) {
	           e.printStackTrace();
	       }
	       System.out.println("Export Successful");
	}
		  

		
}
	
