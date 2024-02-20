package lab;
import java.sql.Connection;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class Lapthree extends Admin
{
	 void insert()
		   {
		       try
		       {
		    	   FileWriter f = new FileWriter("admin.txt");
		    	   System.out.println("Enter the Admin Name :");
		           admin_name = s.next();
		           System.out.println("Enter the Password :");
		           password = s.next();
		           System.out.println("............................");
		           Connection con = DriverManager.getConnection("jdbc:mysql://localhost/payroll","root","");
		           PreparedStatement ps = con.prepareStatement("insert into admininfo values(?,?)");
		           ps.setString(1, admin_name);
		           ps.setString(2, password);
		           ps.executeUpdate();
		           con.close();
		           System.out.println("Data Saved...");
		           String s1=admin_name;
		           String s2=password;
		           f.write(s1 + "\n");
		           f.write(s2 + "\n");
		           f.close();
		           System.out.println("File saved...");
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
	    	   System.out.println("Enter the Admin name :");
	           admin_name = s.next();
	    	   System.out.println("Enter the password :");
	           password = s.next();  
	           System.out.println("............................");
	           Connection con = DriverManager.getConnection("jdbc:mysql://localhost/payroll","root","");
	           PreparedStatement ps = con.prepareStatement("update admininfo set password =? where admin_name =?");
	           ps.setString(1, password);
	           ps.setString(2, admin_name);
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
	    	   System.out.println("Enter the Admin_name :");
	           admin_name = s.next();
	           System.out.println("............................");
	           Connection con = DriverManager.getConnection("jdbc:mysql://localhost/payroll","root","");
	           PreparedStatement ps = con.prepareStatement("delete from admininfo where admin_name =?");
	           ps.setString(1, admin_name);
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
	           System.out.println("Enter the Admin_name :");
	           admin_name = s.next();
	           Connection con = DriverManager.getConnection("jdbc:mysql://localhost/payroll","root","");
	           PreparedStatement ps = con.prepareStatement("select * from admininfo where admin_name =?");
	           ps.setString(1, admin_name);
	           ResultSet rs = ps.executeQuery();
	           int c =0;
	           while(rs.next())
	           {
	               System.out.println("admin_name ="+ rs.getString(1));
	               System.out.println("password ="+ rs.getString(2));
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
	           ResultSet rs = st.executeQuery("select * from admininfo");
	           int c =0;
	           while(rs.next())
	           {
	               System.out.println("Admin_name ="+ rs.getString(1));
	               System.out.println("password ="+ rs.getString(2));
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
	 
	 void fhread()
		{
			try
			{
			FileReader fr = new FileReader("admin.txt");
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
	
	
	public static void main(String[] args) 
	{
		Lapthree m = new Lapthree();
		 int ch;
	       Scanner s1 = new Scanner(System.in);
	       while(true)
	       {
	    	   System.out.println("Welcome to Admin details");
	           System.out.println("1.Add\n2.Update\n3.Delete\n4.Search\n5.print\n6.fhread\n7.Exit\nselect any 1:");
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
		}
