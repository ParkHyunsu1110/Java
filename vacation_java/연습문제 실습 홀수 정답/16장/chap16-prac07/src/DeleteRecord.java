import java.io.*;
import java.sql.*;
public class DeleteRecord {
	public static void main (String[] args) {
		Connection conn;
		Statement stmt = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver"); // MySQL ����̹� �ε�
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookdb", "root","1234"); // JDBC ����
			System.out.println("DB ���� �Ϸ�");
			stmt = conn.createStatement(); // SQL�� ó���� Statement ��ü ����
			stmt.executeUpdate("delete from book where title='Pride & Prejudice' and author='���� ����ƾ'"); // ���ڵ� ����
			printTable(stmt);
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC ����̹� �ε� ����");
		} catch (SQLException e) {
			System.out.println("SQL ���� ����");
		}
	}

	// ���ڵ��� �� ���� �� ȭ�鿡 ���
	private static void printTable(Statement stmt) {
		ResultSet srs;
		System.out.printf("%4s|%-30s|%-30s|%-10s\n", "id","title", "publisher", "author");
		try {
			srs = stmt.executeQuery("select * from book");
			while (srs.next()) {
				System.out.printf("%4s|%-30s|%-30s|%-10s\n", new String(srs.getString("id")), srs.getString("title"), srs.getString("publisher"), srs.getString("author"));
			}
		} catch (SQLException e) {
			System.out.println("SQL ���� ����");
		}
	}
}
