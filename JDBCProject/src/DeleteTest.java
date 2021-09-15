import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.Scanner;
//import java.sql.*;
public class DeleteTest {

	public static void main(String[] args) {
		try {
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			System.out.println("Driver Loaded...");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "newuser123");
			System.out.println("Connected : "+conn);
			
			PreparedStatement preparedStatement= 
					conn.prepareStatement("delete from emp where empno=?");
			
			System.out.println("Prepared Statement created : "+preparedStatement);
			
			Scanner scan1 = new Scanner(System.in);

			System.out.println("For Which employee number : ");
			int empno = scan1.nextInt();
			
			preparedStatement.setInt(1, empno );
						
			int rows = preparedStatement.executeUpdate();
			System.out.println(rows+" Rows deleted ");
		
			preparedStatement.close();
			conn.close();
			System.out.println("DB resources are closed....");
			
			scan1.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
