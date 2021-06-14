package BBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BbddMarcos {
	public static Connection conectar() throws SQLException {
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost/jardineria?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
				"root", "admin");
		System.out.println("No he dado error");
		return conn;

	}
}
