package tool.db_mra;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.ResultSet;
import java.sql.Statement;


public class sampSqlite {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String dbname = "db/repo1.db";
		createNewDB(dbname);
//		createNewTable(dbname);
		insertRow(dbname);
	}

	/*
	 * Creating Table
	 */
	private static void createNewTable(String dbname) {

		String url = "jdbc:sqlite:" + dbname;
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName("org.sqlite.JDBC");
		} catch(ClassNotFoundException e) {
			System.out.println("Class org.sqlite.JDBC is not found");
		}

        try {
        	conn = DriverManager.getConnection(url);
            if (conn != null) {

                stmt = conn.createStatement();
                String sql = "CREATE TABLE COMPANY " +
                               "(ID INT PRIMARY KEY     NOT NULL," +
                               " NAME           TEXT    NOT NULL, " + 
                               " AGE            INT     NOT NULL, " + 
                               " ADDRESS        CHAR(50), " + 
                               " SALARY         REAL)";
                
                stmt.executeUpdate(sql);
                stmt.close();
                conn.close();
            }

        } catch (SQLException e) {
        	System.out.println("Error Code: " + e.getErrorCode());
            System.out.println("Error Msg : " + e.getMessage());
            System.exit(0);
        }
	}
	
	
	/*
	 * inserting Row
	 */
	private static void insertRow(String dbname) {

		String url = "jdbc:sqlite:" + dbname;
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName("org.sqlite.JDBC");
		} catch(ClassNotFoundException e) {
			System.out.println("Class org.sqlite.JDBC is not found");
		}

        try {
        	conn = DriverManager.getConnection(url);
            if (conn != null) {

                stmt = conn.createStatement();

                String sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
                        "VALUES (7, 'Mark', 25, 'Rich-Mond ', 65000.00 );"; 
                
                stmt.executeUpdate(sql);
                stmt.close();
                conn.close();
            }

        } catch (SQLException e) {
        	System.out.println("Error Code: " + e.getErrorCode());
            System.out.println("Error Msg : " + e.getMessage());
            System.exit(0);
        }
	}
		
	/*
	 * Creating Database 
	 */
	private static Connection createNewDB(String dbname) {

		String url = "jdbc:sqlite:" + dbname;
		Connection conn = null;
		
		try {
			Class.forName("org.sqlite.JDBC");
		} catch(ClassNotFoundException e) {
			System.out.println("Class org.sqlite.JDBC is not found");
		}

        try {
        	conn = DriverManager.getConnection(url);
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
                conn.close();
            }

        } catch (SQLException e) {
        	System.out.println("Error Code: " + e.getErrorCode());
            System.out.println("Error Msg : " + e.getMessage());
            System.exit(0);
        }
        
        return conn;
	}
}
