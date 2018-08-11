package food.logindao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import food.logindto.loginVO;
import util.DBManager;

public class acountdao {
	private acountdao() {
	}

	private static acountdao instance = new acountdao();

	public static acountdao getInstance() {
		return instance;
	}
	
	
	public int confirmtoday(String today){
		int result = -1;
		String sql="select today from acount where today=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
				conn = DBManager.getConnectin(); 
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, today);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()){
					result = 1; 
				}else{
					result = -1;
				}		
		}catch(Exception e){
			
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
	
		
		return result;
	}
	
	

	public int insertacount(String today) {

		String sql = "insert into acount values(?,0)";
		Connection conn = null;
		PreparedStatement pstmt = null;

		int result = 0;
		try {
			conn = DBManager.getConnectin();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, today);

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

		System.out.println("result" + result);

		return result;
	}

	public int updateacount(String today) {
		String sql = "update acount set todaycount=todaycount+1  where today=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = DBManager.getConnectin();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, today);

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;

	}
	public int updatetotalacount() {
		String sql = "update total set totalacount=totalacount+1  where total='main'";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = DBManager.getConnectin();
			pstmt = conn.prepareStatement(sql);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
		
	}
	
	public int acountview(String today){
		int todayCount = 0;
		String sql="select * from acount where today=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		
		try{

			conn = DBManager.getConnectin();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, today);
			rs = pstmt.executeQuery();

			if(rs.next()){
				System.out.println(today+"12341234");
				todayCount=rs.getInt("todaycount");
				System.out.println(rs.getInt("todaycount")+"rs.getInt");
			}
		}catch(Exception e){
			
		}finally{
			DBManager.close(conn, pstmt, rs);
		}

		
		return todayCount;
	}
	
	
	public int totalview(){
		int totalacount = 0;
		String sql="select * from total where total='main'";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = DBManager.getConnectin(); 
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				totalacount=rs.getInt("totalacount");
			}
		}catch(Exception e){
			
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
		
		
		return totalacount;
	}
}
	