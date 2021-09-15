/*import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;*/
import java.util.Scanner;
import java.sql.*;
public class FunctionTest {

	public static void main(String[] args) {
		try {
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			System.out.println("Driver Loaded...");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "newuser123");
			System.out.println("Connected : "+conn);
			
			CallableStatement callableStatement= 
					conn.prepareCall("{ ? = call CALC_SAL(?) }");
			
			System.out.println("Prepared Statement created : "+callableStatement);
			
			Scanner scan1 = new Scanner(System.in);
			
			System.out.println("Enter employee number  : ");
			int employeeNumber= scan1.nextInt();
			
			callableStatement.setInt(2, employeeNumber);
			callableStatement.registerOutParameter(1, Types.INTEGER); //return value is integer
			
			callableStatement.execute(); //run the procedure from oracle
			int salary = callableStatement.getInt(1);
			System.out.println("Total salary : "+salary);
			
			callableStatement.close();
			conn.close();
			System.out.println("DB resources are closed....");
			
			scan1.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
