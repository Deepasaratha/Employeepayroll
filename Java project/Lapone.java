package lab;
import java.sql.*;
import java.io.*;
import java.util.Scanner;
public class Lapone extends Admin
{
      
void insert()
	   {
	       try
	       {
	    	   FileWriter f = new FileWriter("employeeinsert.txt");
	           System.out.println("Enter the employee name :");
	           emp_name = s.next();
	           System.out.println("Enter the employee id :");
	           emp_id = s.nextInt();
	           System.out.println("Enter the employee department :");
	           emp_dept = s.next();
	           System.out.println("Enter the employee Phno :");
	           emp_phno = s.nextLong();
	           System.out.println("Enter the employee date of birth :");
	           emp_dob = s.next();
	           System.out.println("Enter the age :");
	           emp_age = s.nextByte();
	           System.out.println("Enter the employee address  :");
	           emp_address = s.next();
	           System.out.println("Enter the blood group :");
	           blood_group = s.next();
	           System.out.println("Enter the email id :");
	           email_id = s.next();
	           System.out.println("Enter the employee gender :");
	           emp_gender = s.next();
	           System.out.println("Enter the aadhar no :");
	           aadhar_no = s.nextLong();
	           System.out.println("Enter the employee state :");
	           emp_state = s.next();
	           System.out.println("Enter the employee join date :");
	           join_date = s.next();
	           System.out.println("Enter the employee marital status :");
	           marital_status = s.next();
	           System.out.println("Enter the employee shift :");
	           emp_shift = s.next();
	           System.out.println("Enter the taken leave :");
	           taken_leave = s.nextByte();
	           System.out.println("Enter the employee performace level :");
	           performance_level = s.next();  
	           Connection con = DriverManager.getConnection("jdbc:mysql://localhost/payroll","root","");
	           PreparedStatement ps = con.prepareStatement("insert into emploinfo values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
	           ps.setString(1, emp_name);
	           ps.setInt(2, emp_id);
	           ps.setString(3, emp_dept);
	           ps.setLong(4, emp_phno);
	           ps.setString(5, emp_dob);
	           ps.setByte(6, emp_age);
	           ps.setString(7, emp_address);
	           ps.setString(8, blood_group);
	           ps.setString(9, email_id);
	           ps.setString(10, emp_gender);
	           ps.setLong(11, aadhar_no);
	           ps.setString(12, emp_state);
	           ps.setString(13, join_date);
	           ps.setString(14, marital_status);
	           ps.setString(15, emp_shift);
	           ps.setByte(16, taken_leave);
	           ps.setString(17, performance_level);
	           ps.executeUpdate();
	           con.close();
	           System.out.println("Data Saved...");
	           String s1 = emp_name;
	           String s2 = String.valueOf(emp_id);
	           String s3 = emp_dept;
	           String s4 = String.valueOf(emp_phno);
	           String s5 = emp_dob;
	           String s6 = String.valueOf(emp_age);
	           String s7 = emp_address;
	           String s8 = blood_group;
	           String s9 = email_id;
	           String s10 = emp_gender;
	           String s11 = String.valueOf(aadhar_no);
	           String s12 = emp_state;
	           String s13 = join_date;
	           String s14 = marital_status;
	           String s15 = emp_shift;
	           String s16 = String.valueOf(taken_leave);
	           String s17 = performance_level;
	           f.write(s1 + "\n");
	           f.write(s2 + "\n");
	           f.write(s3 + "\n");
	           f.write(s4 + "\n");
	           f.write(s5 + "\n");
	           f.write(s6 + "\n");
	           f.write(s7 + "\n");
	           f.write(s8 + "\n");
	           f.write(s9 + "\n");
	           f.write(s10 + "\n");
	           f.write(s11 + "\n");
	           f.write(s12 + "\n");
	           f.write(s13 + "\n");
	           f.write(s14 + "\n");
	           f.write(s15 + "\n");
	           f.write(s16 + "\n");
	           f.write(s17 + "\n");
	           f.close();
	           System.out.println("Filesaved...");
	       }
	       catch(Exception e)
	       {
	           System.out.println(e);
	       } 
	   }

    void fhread()
    {
	try
	{
	FileReader fr = new FileReader("employeeinsert.txt");
	int n;
	String s= " ";
	while((n=fr.read())!=-1)
	{
		s=s+(char)n;
	}
	System.out.print(s);
	fr.close();
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
    }
	   

void update()
	   {
	       try
	       {
	    	   System.out.println("Enter the employee ID :");
	           emp_id = s.nextInt();
	    	   System.out.println("Enter the employee phno :");
	           emp_phno = s.nextLong();  
	           Connection con = DriverManager.getConnection("jdbc:mysql://localhost/payroll","root","");
	           PreparedStatement ps = con.prepareStatement("update emploinfo set emp_id =? where emp_phno =?");
	           ps.setInt(1, emp_id);
	           ps.setLong(2, emp_phno);
	           int r = ps.executeUpdate();
	           con.close();
	           if(r!=0)
	           {
	               System.out.println(r+" record updated");
	           }
	           else
	           {
	               System.out.println("Invalid Name");
	           } 
	       }
	       catch(Exception e)
	       {
	           System.out.println(e);
	       }
	   }
	   
	   
void delete()
	   {
	       try
	       {
	    	   System.out.println("Enter the employee join date :");
	           join_date = s.next();
	           Connection con = DriverManager.getConnection("jdbc:mysql://localhost/payroll","root","");
	           PreparedStatement ps = con.prepareStatement("delete from emploinfo where join_date =?");
	           ps.setString(1, join_date);
	           int r = ps.executeUpdate();
	           con.close();
	           if(r!=0)
	           {
	               System.out.println(r+" record deleted");
	           }
	           else
	           {
	               System.out.println("Invalid Name");
	           }
	           
	       }
	       catch(Exception e)
	       {
	           System.out.println(e);
	       }
	   }

	   
void find()
	   {
	       try
	       {
	           System.out.println("Enter the Emp_Name :");
	           emp_name = s.nextLine();
	           Connection con = DriverManager.getConnection("jdbc:mysql://localhost/payroll","root","");
	           PreparedStatement ps = con.prepareStatement("select * from emploinfo where emp_name =?");
	           ps.setString(1, emp_name);
	           ResultSet rs = ps.executeQuery();
	           int c =0;
	           while(rs.next())
	           {
	               System.out.println("emp_name ="+ rs.getString(1));
	               System.out.println("emp_Phno ="+ rs.getLong(4));
	               System.out.println("emp address ="+rs.getString(7));
	               System.out.println("emp shift ="+ rs.getString(15));
	               System.out.println("............................");
	               c=1;
	           }
	           if(c==0)
	           {
	               System.out.println("Invalid Name");
	           }
	           con.close();
	       }
	       catch(Exception e)
	       {
	           System.out.println(e);
	       }
	   }
	   

void printinfo()
	   {
	       try
	       {
	           Connection con = DriverManager.getConnection("jdbc:mysql://localhost/payroll","root","");
	           Statement st = con.createStatement();
	           ResultSet rs = st.executeQuery("select * from emploinfo");
	           int c =0;
	           while(rs.next())
	           {
	               System.out.println("emp name ="+ rs.getString(1));
	               System.out.println("blood group ="+ rs.getString(8));
	               System.out.println("emp age ="+ rs.getInt(6));
	              System.out.println("Performance level ="+ rs.getString(17));
	               System.out.println("............................");
	               c=1;
	           }
	           if(c==0)
	           {
	               System.out.println("Table is empty");
	           }
	           con.close();
	       }
	       catch(Exception e)
	       {
	           System.out.println(e);
	       }
	   }
	

	public static void main(String[] args)
	{
		Lapone p=new Lapone();
		 int ch;
	       Scanner s1 = new Scanner(System.in);
	       while(true)
	       {
	    	   System.out.println("Welcome to Employee details");
	           System.out.println("1.Add\n2.Update\n3.Delete\n4.Search\n5.print\n6.fhread\n7.Exit\nselect any 1:");
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

