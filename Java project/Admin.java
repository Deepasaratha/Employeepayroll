package lab;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
public class Admin
{
	String user_name,passward,admin_name,password,emp_name,emp_dept,emp_dob,emp_address,blood_group,email_id,emp_gender,emp_state,join_date,marital_status,emp_shift,performance_level,bank_name,pf_no,pancard_no;
	int emp_id,bonus,increment,overtime_amount,transport_allowance,canteen_deduction,pf_amount,medical_allowance;
	byte emp_age,taken_leave;
    long admin_phno,emp_phno,aadhar_no,emp_salary,incometax_payable,bank_acno;	
	Scanner s = new Scanner(System.in);
	
	//Admin Login
	boolean Admin(String un,String pw)
	{
		boolean res=false;
		try
		{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/payroll","root","");
	        PreparedStatement ps = con.prepareStatement("select * from admininfo where admin_name=? and password=?");
			ps.setString(1, un);
			ps.setString(2, pw);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				res=!res;
			}
		}
			catch(Exception e)
			{
				System.out.println(e);
			}
			return res;
	}
	
	//Employee Login
	boolean User(String un1,String pw1)
	{
		boolean res=false;
		try
		{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/payroll","root","");
	        PreparedStatement ps = con.prepareStatement("select * from emplogin where user_name=? and passward=?");
			ps.setString(1, un1);
			ps.setString(2, pw1);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				res=!res;
			}
		}
			catch(Exception e)
			{
				System.out.println(e);
			}
			return res;
	}


	public static void main(String[] args)
	{
		
	    Lapone p = new Lapone();
	    Laptwo l = new Laptwo();
	    Lapthree m = new Lapthree();
		Admin a = new Admin();
		Scanner sc = new Scanner(System.in);
		System.out.println("\n-----------Welcome To Employee Payroll----------- \n");
		System.out.println("\n1.Admin Login \n2.Employee Login");
		System.out.println("<-- Select any one Login option -->");
		System.out.println();
		int z = sc.nextInt();
		if(z==1)
		{
		  System.out.println("ADMIN LOGIN PAGE");
		  System.out.println("Enter the Admin name :");
		  String un=sc.next();
		  System.out.println("Enter the Password :");
		  String pw=sc.next();
		  boolean k=a.Admin(un, pw);
		  if(k==true)
		  {
			  System.out.println("Successfully Login");
		  }
		  else
		  {
			  System.out.println("Invalid Admin name or Password");
		  }
			  while(true)
			  {
				  int xyz;
				  System.out.println("\nChoose any one \n1.Admin Information \n 2.Employee Informtaion\n");
				  xyz=sc.nextInt();
				  if(xyz==1)
				  {
			 int ch;
	       Scanner s1 = new Scanner(System.in);
	       while(true)
	       {
	    	   System.out.println("\n*****Welcome To Admin Information Page*****");
				  System.out.println("\n 1.Add \n2.update \n3.Delete \n4.Search \n5.Print \n6.fhread \n7.Exit  ");
				  System.out.println("\n Select the option :");
	           ch = s1.nextInt();
	           if(ch==1)
	           {
	               m.insert();
	           }
	           else if(ch==2)
	           {
	               m.update();
	           }
	           else if(ch==3)
	           {
	               m.delete();
	           }
	           else if(ch==4)
	           {
	               m.find();
	           }
	           else if(ch==5)
	           {
	               m.printinfo();
	           }
	           else if(ch==6)
				{
					m.fhread();
				}
	           else if(ch==7)
	           {
	               System.out.println("Thank you...");
	               break;
	           }
	           else
	           {
	               System.out.println("Invalid Choice...");
	           }
	          }
	           }
			 
		
		
	      	else if(xyz==2)
	      	{
	      		 int ch;
			       Scanner s1 = new Scanner(System.in);
			       while(true)
			       {
			    	   System.out.println("\n*****Welcome To Employee Information Page*****");
			           System.out.println("1.Add\n2.Update\n3.Delete\n4.Search\n5.print\n6.fhread\n7.Exit\n");
			           ch = s1.nextInt();
			           if(ch==1)
			           {
			               p.insert();
			           }
			           else if(ch==2)
			           {
			               p.update();
			           }
			           else if(ch==3)
			           {
			               p.delete();
			           }
			           else if(ch==4)
			           {
			               p.find();
			           }
			           else if(ch==5)
			           {
			               p.printinfo();
			           }
			           else if(ch==6)
						{
							p.fhread();
						}
			           else if(ch==7)
			           {
			               System.out.println("Thank you...");
			               break;
			           }
			           
			           else
			           {
			               System.out.println("Invalid Choice...");
			           }
			       }
	      	}
			  }
		}
		
		  else if(z==2)
			  {
			    System.out.println("EMPLOYEE LOGIN PAGE");
				System.out.println("Enter the username : ");
				String un1=sc.next();
				System.out.println("Enter the Password : ");
				String pw1=sc.next();
				boolean r1=a.User(un1, pw1);
				if(r1==true)
				{
					System.out.println("Successfully Login");
				}
				else
				{
					System.out.println("Invalid username or password");
				}
			    while(true)
			    {
			    	int str;
			      System.out.println("\n choose any one \n 1.Employeeinfo \n2.Salaryinfo\n");
			      str=sc.nextInt();
			      if(str==1)
			      {		    
			      int ch;
			       Scanner s1 = new Scanner(System.in);
			       while(true)
			       {
			    	   System.out.println(" \n *Employeeinfo * \nselect below options:");
			           System.out.println("1.Add\n2.Update\n3.Delete\n4.Search\n5.print\n6.fhread\n7.Exit\n");
			           ch = s1.nextInt();
			           if(ch==1)
			           {
			               p.insert();
			           }
			           else if(ch==2)
			           {
			               p.update();
			           }
			           else if(ch==3)
			           {
			               p.delete();
			           }
			           else if(ch==4)
			           {
			               p.find();
			           }
			           else if(ch==5)
			           {
			               p.printinfo();
			           }
			           else if(ch==6)
						{
							p.fhread();
						}
			           else if(ch==7)
			           {
			               System.out.println("Thank you...");
			               break;
			           }
			           
			           else
			           {
			               System.out.println("Invalid Choice...");
			           }
			       }
			      }
			    
			      
			    else if(str==2)
		    		   {
		       
                 int ch;
              Scanner s1 = new Scanner(System.in);
              while(true)
               {
	         System.out.println(" \n * Salaryinfo * \n select below options:");
              System.out.println("1.Add\n2.Update\n3.Delete\n4.Search\n5.print\n6.fh1read\n7.Exit\nselect any 1:");
              ch = s1.nextInt();
             if(ch==1)
               {
                  l.insert();
                }
             else if(ch==2)
             {
              l.update();
              }
              else if(ch==3)
              {
              l.delete();
               }
             else if(ch==4)
            {
               l.find();
             }
            else if(ch==5)
            {
              l.printinfo();
              }
             else if(ch==6)
	        	{
		    	l.fh1read();
	        	}
            else if(ch==7)
            {
            System.out.println("Thank you...");
             break;
             }
              else
             {
              System.out.println("Invalid Choice...");
               }
              }
		    		   }
			    }
			  }
                	}
               }
	          
              





/*package lab;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
public class Admin
{
	String user_name,passward,admin_name,password,emp_name,emp_dept,emp_dob,emp_address,blood_group,email_id,emp_gender,emp_state,join_date,marital_status,emp_shift,performance_level,bank_name,pf_no,pancard_no;
	int emp_id,bonus,increment,overtime_amount,transport_allowance,canteen_deduction,pf_amount,medical_allowance;
	byte emp_age,taken_leave;
    long admin_phno,emp_phno,aadhar_no,emp_salary,incometax_payable,bank_acno;	
	Scanner s = new Scanner(System.in);
	
	//Admin Login
	boolean Admin(String un,String pw)
	{
		boolean res=false;
		try
		{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/payroll","root","");
	        PreparedStatement ps = con.prepareStatement("select * from admininfo where admin_name=? and password=?");
			ps.setString(1, un);
			ps.setString(2, pw);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				res=!res;
			}
		}
			catch(Exception e)
			{
				System.out.println(e);
			}
			return res;
	}
	
	//Employee Login
	boolean User(String un1,String pw1)
	{
		boolean res=false;
		try
		{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/payroll","root","");
	        PreparedStatement ps = con.prepareStatement("select * from emplogin where user_name=? and passward=?");
			ps.setString(1, un1);
			ps.setString(2, pw1);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				res=!res;
			}
		}
			catch(Exception e)
			{
				System.out.println(e);
			}
			return res;
	}


	public static void main(String[] args)
	{
		
	    Lapone p = new Lapone();
	    Laptwo l = new Laptwo();
	    Lapthree m = new Lapthree();
		Admin a = new Admin();
		Scanner sc = new Scanner(System.in);
		System.out.println("\n-----------Welcome To Employee Payroll----------- \n");
		System.out.println("\n1.Admin Login \n2.Employee Login");
		System.out.println("<-- Select any one Login option -->");
		System.out.println();
		int z = sc.nextInt();
		if(z==1)
		{
		  System.out.println("ADMIN LOGIN PAGE");
		  System.out.println("Enter the Admin name :");
		  String un=sc.next();
		  System.out.println("Enter the Password :");
		  String pw=sc.next();
		  boolean k=a.Admin(un, pw);
		  if(k==true)
		  {
			  System.out.println("Successfully Login");
		  }
		  else
		  {
			  System.out.println("Invalid Admin name or Password");
		  }
			  while(true)
			  {
				  int xyz;
				  System.out.println("\nChoose any one \n1.Admin Information \n 2.Employee Informtaion\n");
				  xyz=sc.nextInt();
				  if(xyz==1)
				  {
			 int ch;
	       Scanner s1 = new Scanner(System.in);
	       while(true)
	       {
	    	   System.out.println("\n*****Welcome To Admin Information Page*****");
				  System.out.println("\n 1.Add \n2.update \n3.Delete \n4.Search \n5.Print \n6.fhread \n7.Exit  ");
				  System.out.println("\n Select the option :");
	           ch = s1.nextInt();
	           if(ch==1)
	           {
	               m.insert();
	           }
	           else if(ch==2)
	           {
	               m.update();
	           }
	           else if(ch==3)
	           {
	               m.delete();
	           }
	           else if(ch==4)
	           {
	               m.find();
	           }
	           else if(ch==5)
	           {
	               m.printinfo();
	           }
	           else if(ch==6)
				{
					m.fhread();
				}
	           else if(ch==7)
	           {
	               System.out.println("Thank you...");
	               break;
	           }
	           else
	           {
	               System.out.println("Invalid Choice...");
	           }
	          }
	           }
			 
		
		
	      	else if(xyz==2)
	      	{
	      		 int ch;
			       Scanner s1 = new Scanner(System.in);
			       while(true)
			       {
			    	   System.out.println("\n*****Welcome To Employee Information Page*****");
			           System.out.println("1.Add\n2.Update\n3.Delete\n4.Search\n5.print\n6.fhread\n7.Exit\n");
			           ch = s1.nextInt();
			           if(ch==1)
			           {
			               p.insert();
			           }
			           else if(ch==2)
			           {
			               p.update();
			           }
			           else if(ch==3)
			           {
			               p.delete();
			           }
			           else if(ch==4)
			           {
			               p.find();
			           }
			           else if(ch==5)
			           {
			               p.printinfo();
			           }
			           else if(ch==6)
						{
							p.fhread();
						}
			           else if(ch==7)
			           {
			               System.out.println("Thank you...");
			               break;
			           }
			           
			           else
			           {
			               System.out.println("Invalid Choice...");
			           }
			       }
	      	}
		
		
		  else if(z==2)
			  {
			    System.out.println("EMPLOYEE LOGIN PAGE");
				System.out.println("Enter the username : ");
				String un1=sc.next();
				System.out.println("Enter the Password : ");
				String pw1=sc.next();
				boolean r1=a.User(un1, pw1);
				if(r1==true)
				{
					System.out.println("Successfully Login");
				}
				else
				{
					System.out.println("Invalid username or password");
				}
			    while(true)
			    {
			    	int str;
			      System.out.println("\n choose any one \n 1.Employeeinfo \n2.Salaryinfo\n");
			      str=sc.nextInt();
			      if(str==1)
			      {		    
			      int ch;
			       Scanner s1 = new Scanner(System.in);
			       while(true)
			       {
			    	   System.out.println(" \n *Employeeinfo * \nselect below options:");
			           System.out.println("1.Add\n2.Update\n3.Delete\n4.Search\n5.print\n6.fhread\n7.Exit\n");
			           ch = s1.nextInt();
			           if(ch==1)
			           {
			               p.insert();
			           }
			           else if(ch==2)
			           {
			               p.update();
			           }
			           else if(ch==3)
			           {
			               p.delete();
			           }
			           else if(ch==4)
			           {
			               p.find();
			           }
			           else if(ch==5)
			           {
			               p.printinfo();
			           }
			           else if(ch==6)
						{
							p.fhread();
						}
			           else if(ch==7)
			           {
			               System.out.println("Thank you...");
			               break;
			           }
			           
			           else
			           {
			               System.out.println("Invalid Choice...");
			           }
			       }
			      }
			    
			      
			    else if(str==2)
		    		   {
		       
                 int ch;
              Scanner s1 = new Scanner(System.in);
              while(true)
               {
	         System.out.println(" \n * Salaryinfo * \n select below options:");
              System.out.println("1.Add\n2.Update\n3.Delete\n4.Search\n5.print\n6.fh1read\n7.Exit\nselect any 1:");
              ch = s1.nextInt();
             if(ch==1)
               {
                  l.insert();
                }
             else if(ch==2)
             {
              l.update();
              }
              else if(ch==3)
              {
              l.delete();
               }
             else if(ch==4)
            {
               l.find();
             }
            else if(ch==5)
            {
              l.printinfo();
              }
             else if(ch==6)
	        	{
		    	l.fh1read();
	        	}
            else if(ch==7)
            {
            System.out.println("Thank you...");
             break;
             }
              else
             {
              System.out.println("Invalid Choice...");
               }
              }
		    		   }
			    }
			  }
                	}
               }
	          }
                 }*/
              







