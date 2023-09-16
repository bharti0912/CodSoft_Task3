package internship;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;


public class StudentManagementSystem extends javax.swing.JFrame
{
      public static void main(String[] args) throws ClassNotFoundException, SQLException
   {
	 Class.forName("com.mysql.cj.jdbc.Driver");
	 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/intern", "root", "bharti");
	 Statement st=con.createStatement();
	 Scanner sc= new Scanner(System.in);
         String option;
         int option1;
	 for( ; ; )
	 {
         JOptionPane.showMessageDialog(null,"1.Add new Student 2.Update Student Info 3.Search student 4.Remove Student 5.Display all student 6.Exit");

         option=JOptionPane.showInputDialog("Enter Option");
         option1=Integer.parseInt(option);
	 
	 switch(option1)
	 {
	     case 1:     JOptionPane.showMessageDialog(null, "Add New Student ");
	                 PreparedStatement ps=con.prepareStatement("insert into student(roll_no, name, grade, email, age)values(?,?,?,?,?)");
                         String roll_no1;
                         int roll_no11;
                         roll_no1=JOptionPane.showInputDialog("Enter the Roll No");
                         roll_no11=Integer.parseInt(roll_no1);
	            	 String name1;
                         name1=JOptionPane.showInputDialog("Enter the Name");
	            	 String grade1;
                         grade1=JOptionPane.showInputDialog("Enter the Grade");
	            	 String email1;
                         email1=JOptionPane.showInputDialog("Enter the email");
	            	 String age1;
                         int age11;
                         age1=JOptionPane.showInputDialog("Enter the Age");
	            	 age11=Integer.parseInt(age1);
	            	 
	            	 
	            	 ps.setInt(1, roll_no11);
	            	 ps.setString(2, name1);
	            	 ps.setString(3, grade1);
	            	 ps.setString(4, email1);
	            	 ps.setInt(5, age11);
	            	 
	            	 ps.execute();
                         JOptionPane.showMessageDialog(null, "Added Student successfully");
	            	 break;
	             
                         
	     case 2: JOptionPane.showMessageDialog(null, "Update Student Information :");                  
	             PreparedStatement ps2=con.prepareStatement("Update student set age=? where roll_no=?");
                     String age2;
                     int age22;
                     age2=JOptionPane.showInputDialog("Enter the Age : ");
	             age22=Integer.parseInt(age2);
	             String roll_no2;
                     int roll_no22;
                     roll_no2=JOptionPane.showInputDialog("Enter the Roll No : ");
	             roll_no22=Integer.parseInt(age2);
	             	             
	             ps2.setInt(1, age22);
	             ps2.setInt(2, roll_no22);
	             
	             ps2.execute();
                     JOptionPane.showMessageDialog(null, "Student Information Updated Successfully");
	             break;
	             
	     case 3: JOptionPane.showMessageDialog(null, "Searching for a Student Information while Entering the Roll No");
	             PreparedStatement ps3=con.prepareStatement("select * from student where roll_no=?");
                     String roll_no3;
                     int roll_no33;
                     roll_no3=JOptionPane.showInputDialog("Enter the Roll No :");
	             roll_no33=Integer.parseInt(roll_no3);
	             
	             ps3.setInt(1, roll_no33);
	                ResultSet rs3=ps3.executeQuery();
	             while(rs3.next())
	             {
                         System.out.println(rs3.getInt(1));
                         System.out.println(rs3.getString(2));
                         System.out.println(rs3.getString(3));
                         System.out.println(rs3.getString(4));
                         System.out.println(rs3.getInt(5));
	             }
                     JOptionPane.showMessageDialog(null, "Student search successfully");
	             break;
	             
             case 4: JOptionPane.showMessageDialog(null, "Remove Student ");
                     PreparedStatement ps4=con.prepareStatement("delete from student where roll_no=?");
                     String roll_no4;
                     int roll_no44;
                     roll_no4=JOptionPane.showInputDialog("Enter the Roll No to delete the data :");
                     roll_no44=Integer.parseInt(roll_no4);
                     ps4.setInt(1, roll_no44);
                     ps4.execute();
                     JOptionPane.showMessageDialog(null, "Delete Student data Successfully ");
                     break;
                     
	     case 5: JOptionPane.showMessageDialog(null, "Display all student Information");                 
	             PreparedStatement ps5=con.prepareStatement("select * from student");
	             ResultSet rs5=ps5.executeQuery();
	             while(rs5.next())
	             {
	            	 System.out.println(rs5.getInt(1));
                         System.out.println(rs5.getString(2));
                         System.out.println(rs5.getString(3));
                         System.out.println(rs5.getString(4));
                         System.out.println(rs5.getInt(5));
	             }
                     JOptionPane.showMessageDialog(null, "Display all information Successfully");
	             break;
	             
	     case 6: System.exit(0);           
	 }
	 }
   }
}
