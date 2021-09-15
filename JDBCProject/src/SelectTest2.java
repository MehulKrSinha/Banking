import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.Scanner;
//import java.sql.*;
public class SelectTest2 {

	public static void main(String[] args) {
		try {
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			System.out.println("Driver Loaded...");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "newuser123");
			System.out.println("Connected : "+conn);
			
			PreparedStatement preparedStatement= 
					conn.prepareStatement("select * from emp where job=?"); 
			System.out.println("Prepared Statement created : "+preparedStatement);
			
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter job to search : ");
			String v_job = scan.nextLine();
			preparedStatement.setString(1, v_job); //fill up the first question mark
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				System.out.println("Emp number  : " + resultSet.getInt(1) );
				System.out.println("Emp name    : " + resultSet.getString(2) );
				System.out.println("Emp Job     : " + resultSet.getString(3) );
				System.out.println("Emp Manager : " + resultSet.getString(4) );
				System.out.println("Emp Joining : " + resultSet.getString(5) );
				System.out.println("Emp Salary  : " + resultSet.getInt(6) );
				System.out.println("Emp Comm    : " + resultSet.getInt(7) );
				System.out.println("Emp Dept    : " + resultSet.getInt(8) );
				System.out.println("-----------------------");
			}
			System.out.println("=============================================");
			Scanner scan2 = new Scanner(System.in);
			System.out.println("Enter starting date : ");
			String fromDate = scan2.nextLine();
			
			Scanner scan3 = new Scanner(System.in);
			System.out.println("Enter ending date   : ");
			String toDate = scan3.nextLine();
			
			//ResultSet dateRs = statement.executeQuery("select * from emp where hiredate between '01-Jan-81' and '31-Dec-81'");
			//ResultSet dateRs = statement.executeQuery("select * from emp where hiredate between "+"'"+fromDate+"'"+" and "+"'"+toDate+"'");
			PreparedStatement preparedStatement2 = conn.prepareStatement("select * from emp where hiredate between ? and ?");
			preparedStatement2.setString(1, fromDate);
			preparedStatement2.setString(2, toDate);
			ResultSet dateRs = preparedStatement2.executeQuery();
			
			while(dateRs.next()) {
				System.out.println("Emp number  : " + dateRs.getInt(1) );
				System.out.println("Emp name    : " + dateRs.getString(2) );
				System.out.println("Emp Job     : " + dateRs.getString(3) );
				System.out.println("Emp Manager : " + dateRs.getString(4) );
				System.out.println("Emp Joining : " + dateRs.getString(5) );
				System.out.println("Emp Salary  : " + dateRs.getInt(6) );
				System.out.println("Emp Comm    : " + dateRs.getInt(7) );
				System.out.println("Emp Dept    : " + dateRs.getInt(8) );
				System.out.println("-----------------------");
			}
			
			scan.close();
			scan2.close();
			scan3.close();
			resultSet.close();
			dateRs.close();
			preparedStatement.close();
			preparedStatement2.close();
			conn.close();
			System.out.println("DB resources are closed....");
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
