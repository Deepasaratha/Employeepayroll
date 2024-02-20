package lab;
import java.sql.*;
import java.io.*;
import java.util.Scanner;
public class Laptwo extends Admin
{
	
void insert()
	   {
	       try
	       {
	    	   FileWriter f1 = new FileWriter("salaryinsert.txt");
	    	   System.out.println("Enter the employee name :");
	           emp_name = s.next();
	           System.out.println("Enter the employee id :");
	           emp_id = s.nextInt();
	    	   System.out.println("Enter the employee salary :");
	           emp_salary = s.nextLong();
	           System.out.println("Enter the bonus :");
	           bonus = s.nextInt();
	           System.out.println("Enter the increment :");
	           increment = s.nextInt();
	           System.out.println("Enter the overtime_amount :");
	           overtime_amount = s.nextInt();
	           System.out.println("Enter the transport_allowance :");
	           transport_allowance = s.nextInt();
	           System.out.println("Enter the canteen deduction :");
	           canteen_deduction = s.nextInt();
	           System.out.println("Enter the imcometax payable :");
	           incometax_payable = s.nextLong();
	           System.out.println("Enter the pf amount :");
	           pf_amount = s.nextInt();
	           System.out.println("Enter the pf no :");
	           pf_no = s.next();
	           System.out.println("Enter the bank account no :");
	           bank_acno = s.nextLong();
	           System.out.println("Enter the bank name :");
	           bank_name = s.next();
	           System.out.println("Enter the pancard no :");
	           pancard_no = s.next();
	           System.out.println("Enter the medical_allowance :");
	           medical_allowance = s.nextInt();
	           Connection con = DriverManager.getConnection("jdbc:mysql://localhost/payroll","root","");
	           PreparedStatement ps = con.prepareStatement("insert into salaryinfo values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
	           ps.setString(1, emp_name);
	           ps.setInt(2, emp_id);
	           ps.setLong(3, emp_salary);
	           ps.setInt(4, bonus);
	           ps.setInt(5, increment);
	           ps.setInt(6, overtime_amount);
	           ps.setInt(7, transport_allowance);
	           ps.setInt(8, canteen_deduction);
	           ps.setLong(9, incometax_payable);
	           ps.setInt(10, pf_amount);
	           ps.setString(11, pf_no);
	           ps.setLong(12, bank_acno);
	           ps.setString(13, bank_name);
	           ps.setString(14, pancard_no);
	           ps.setInt(15, medical_allowance);
	           ps.executeUpdate();
	           con.close();
	           System.out.println("Data Saved..."); 
	           String s1 = emp_name;
	           String s2 = String.valueOf(emp_id);
	           String s3 = String.valueOf(emp_salary);
	           String s4 = String.valueOf(bonus);
	           String s5 = String.valueOf(increment);
	           String s6 = String.valueOf(overtime_amount);
	           String s7 = String.valueOf(transport_allowance);
	           String s8 = String.valueOf(canteen_deduction);
	           String s9 = String.valueOf(incometax_payable);
	           String s10 = String.valueOf(pf_amount);
	           String s11 = String.valueOf(pf_no);
	           String s12 = String.valueOf(bank_acno);
	           String s13 = bank_name;
	           String s14 = pancard_no;
	           String s15 = String.valueOf(medical_allowance);
	           f1.write(s1 + "\n");
	           f1.write(s2 + "\n");
	           f1.write(s3 + "\n");
	           f1.write(s4 + "\n");
	           f1.write(s5 + "\n");
	           f1.write(s6 + "\n");
	           f1.write(s7 + "\n");
	           f1.write(s8 + "\n");
	           f1.write(s9 + "\n");
	           f1.write(s10 + "\n");
	           f1.write(s11 + "\n");
	           f1.write(s12 + "\n");
	           f1.write(s13 + "\n");
	           f1.write(s14 + "\n");
	           f1.write(s15 + "\n");
	           f1.close();
	           System.out.println("Filesaved...");
	       }
	       catch(Exception e)
	       {
	           System.out.println(e);
	       } 
	   }
  
     void fh1read()
	 {
		try
		{
		FileReader fr1 = new FileReader("salaryinsert.txt");
		int n;
		String s1= " ";
		while((n=fr1.read())!=-1)
		{
			s1=s1+(char)n;
		}
		System.out.print(s1);
		fr1.close();
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
 	    System.out.println("Enter the employee Pf no :");
        pf_no = s.next();
       
        System.out.println("Enter the employee name :");
        emp_name = s.next();
       
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/payroll","root","");
        PreparedStatement ps = con.prepareStatement("update salaryinfo set pf_no =? where emp_name =?");
        ps.setString(1, pf_no);
       
        ps.setString(2, emp_name);
        
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
 	    System.out.println("Enter the medical allowance :");
        medical_allowance = s.nextInt();
       
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/payroll","root","");
        PreparedStatement ps = con.prepareStatement("delete from salaryinfo where medical_allowance =?");
        ps.setInt(1, medical_allowance);
       
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
        System.out.println("Enter the Pancard number :");
        pancard_no= s.next();
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/payroll","root","");
        PreparedStatement ps = con.prepareStatement("select * from salaryinfo where pancard_no =?");
        ps.setString(1, pancard_no);
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
        ResultSet rs = st.executeQuery("select * from salaryinfo");
        int c =0;
        while(rs.next())
        {
            System.out.println("emp name ="+ rs.getString(1));
            System.out.println("Bonus ="+ rs.getInt(4));
            System.out.println("Pf no ="+ rs.getString(11));
           System.out.println("Bank name ="+ rs.getString(13));
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
		Laptwo l=new Laptwo();
		 int ch;
	       Scanner s1 = new Scanner(System.in);
	       while(true)
	       {
	    	   System.out.println("\nWelcome to Salary details");
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
