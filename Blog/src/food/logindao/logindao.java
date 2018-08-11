package food.logindao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import food.logindto.loginVO;
import sun.security.jca.GetInstance.Instance;
import util.DBManager;

public class logindao {
	private logindao() {
	}

	private static logindao instance = new logindao();

	public static logindao getInstance() {
		return instance;
	}

	public int userCheck(String id, String pass) {
		System.out.println("dao - userCheck() 메서드");
		int result = -1;
		String sql = "select pass from idData where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnectin();
												
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				if (rs.getString("pass") != null && rs.getString("pass").equals(pass)) {
					result = 1;
				} else {
					result = 0; 
				}
			} else {
				result = -1; 
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			DBManager.close(conn, pstmt, rs);

		}
		// #10] LoginServlet의 doPost로 가자!
		return result; // 1 0, -1
	}

	public loginVO getlogin(String id) {
		loginVO vo = null;

		String sql = "select * from iddata where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnectin();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo = new loginVO();
				vo.setId(rs.getString("id"));
				vo.setPass(rs.getString("pass"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setNickname(rs.getString("nickname"));
				vo.setWritedate(rs.getTimestamp("writedate"));
				vo.setAdmin(rs.getInt("admin"));
				vo.setAddress(rs.getString("address"));
				vo.setCompanyName(rs.getString("companyName"));
				vo.setCompanyPhone(rs.getString("companyphone"));
			}

		} catch (Exception e) {

		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return vo;
		

	}
	public int confirmID(String id){
		int result = -1;
		String sql="select id from iddata where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
				conn = DBManager.getConnectin(); 
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				
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
	public String IDFind(loginVO vo){
		String resultStr = "";
		String sql="select id from iddata where name=? and nickname=? and email=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			conn = DBManager.getConnectin(); 
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getNickname());
			pstmt.setString(3, vo.getEmail());
			
			System.out.println(vo.getName()+":getname");
			System.out.println(vo.getNickname()+":getname");
			System.out.println(vo.getName()+":getname");
			
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				resultStr = rs.getString("id"); 
			}else{
				resultStr = "";
			}
		}catch(Exception e){
			
		}finally{
			DBManager.close(conn, pstmt, rs);
		}

		
		return resultStr;
	}
	public int PassFind(String name,String id){
		int result = 0;
		String sql="select id from iddata where id=? and name=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = DBManager.getConnectin(); 
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				result = 1; 
			}
		}catch(Exception e){
			
		}finally{
			DBManager.close(conn, pstmt, rs);
		}

		
		return result;
	}
	
	public int insertMember(loginVO vo){
		
		String sql="insert into iddata(id,pass,name,nickname,email,admin,address,companyName,companyPhone) values(?,?,?,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;

		
		int result=0;
		try{
			conn = DBManager.getConnectin();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPass());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getNickname());
			pstmt.setString(5, vo.getEmail());
			pstmt.setInt(6, vo.getAdmin());
			pstmt.setString(7, vo.getAddress());
			pstmt.setString(8, vo.getCompanyName());
			pstmt.setString(9, vo.getCompanyPhone());
			result = pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt);
		}
		
		System.out.println("result"+result);
		
		return result;
	}
	
	
	public int deleteMember(String id){
		
		String sql="delete from iddata where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;

		int result=0;
		try{
			conn = DBManager.getConnectin();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			result = pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt);
		}
		
		System.out.println("result"+result);
		
		return result;
	}
	
	
	
	public int updateMember(loginVO vo){
		String sql="update iddata set pass=?, email=?, nickname=?, admin=?, address=? ,companyName=?, companyPhone=?  where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try{
			conn = DBManager.getConnectin();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPass());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getNickname());
			pstmt.setInt(4, vo.getAdmin());
			
			
			pstmt.setString(5, vo.getAddress());
			pstmt.setString(6, vo.getCompanyName());
			pstmt.setString(7, vo.getCompanyPhone());
			pstmt.setString(8, vo.getId());
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return result;

	}
	public int updatePass(String id, String pass){
		String sql="update iddata set pass=? where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try{
			conn = DBManager.getConnectin();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pass);

			pstmt.setString(2, id);
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return result;
		
	}
}
