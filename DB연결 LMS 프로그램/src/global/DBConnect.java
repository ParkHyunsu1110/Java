package global;

import java.sql.Connection;
import java.sql.SQLException;

public class DBConnect {

	private static Connection conn;
	private static java.sql.Statement stmt;
	public static java.sql.ResultSet rs;
	
	public DBConnect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.conn = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/lms?serverTimezone=UTC&useSSL=false","root","adgjl13579");
			this.stmt = this.conn.createStatement();
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found");
		} catch (SQLException e) {
			System.out.println("connection error");
		}
	}
	
	public void update(String dbCommand) {
		try {
			this.stmt.executeUpdate(dbCommand);
		}catch(Exception e) {
			System.out.println("update error : " + e);
		}
	}
	
	public void select(String dbCommand) {
		try {
			this.rs = this.stmt.executeQuery(dbCommand);
		}catch(Exception e) {
			System.out.println("select error : " + e);
		}
	}
	
	public void close() {
		try {
			this.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
