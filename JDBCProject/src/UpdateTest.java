import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.Scanner;
//import java.sql.*;
public class UpdateTest {

	public static void main(String[] args) {
		try {
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			System.out.println("Driver Loaded...");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "newuser123");
			System.out.println("Connected : "+conn);
			
			PreparedStatement preparedStatement= 
					conn.prepareStatement("update emp set job=?,sal=sal+? where empno=?");
			
			System.out.println("Prepared Statement created : "+preparedStatement);
			
			Scanner scan1 = new Scanner(System.in);
			Scanner scan2 = new Scanner(System.in);
			Scanner scan3 = new Scanner(System.in);
				
			
			System.out.println("Enter NEW job    : ");
			String empJob = scan2.nextLine();
			
			System.out.println("Enter SALARY Upraisal amount : ");
			int salaryUpraisalAmount= scan3.nextInt();
			
			System.out.println("For Which employee number : ");
			int empno = scan1.nextInt();
			
	 
			preparedStatement.setString(1, empJob);
			preparedStatement.setInt(2, salaryUpraisalAmount);
			preparedStatement.setInt(3, empno );
						
			int rows = preparedStatement.executeUpdate();
			System.out.println(rows+" Rows updated ");
		
			preparedStatement.close();
			conn.close();
			System.out.println("DB resources are closed....");
			
			scan1.close();
			scan2.close();
			scan3.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
