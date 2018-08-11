package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/*
	DAO에서 사용할 dbcp연동,  try~catch()의 반복적인 사용 등을
	편리하게 쓸 수 있도록 구성해 놓은 클래스
 */
public class DBManager {
	public static Connection getConnectin(){
		Connection conn = null;
		try{
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
			conn = ds.getConnection();
		
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}
	public static void close(Connection conn, Statement stmt, ResultSet rs){
		try{
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void close(Connection conn, Statement stmt){
		try{
			stmt.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
