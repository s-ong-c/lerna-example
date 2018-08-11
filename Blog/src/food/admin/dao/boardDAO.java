package food.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import food.admin.dto.BoardVO;
import food.admin.dto.MemberVO;
import food.admin.dto.OutMemberVO;
import util.DBManager;

public class boardDAO {

	private boardDAO() {
	}
	private static boardDAO instance = new boardDAO();

	public static boardDAO getInstance() {
		return instance;
	}
	
	
	public List<MemberVO> selectAllBoards() {

		List<MemberVO> list = new ArrayList<MemberVO>();
		String sql = "select * from idData where admin=0 order by id desc";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		MemberVO vo = null;
		try {
			conn = DBManager.getConnectin();
			stmt = conn.createStatement(); // conn.prepareStatement(sql);

			rs = stmt.executeQuery(sql); // pstmt.executeQuery();

			while (rs.next()) { // 행 단위 변화
				vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setPass(rs.getString("pass"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setNickname(rs.getString("nickname"));
				vo.setWritedate(rs.getTimestamp("writedate"));
				vo.setAdmin(rs.getInt("admin"));
				
				list.add(vo);
			}

		} catch (Exception e) {
			
			e.printStackTrace();

		} finally {
			DBManager.close(conn, stmt, rs);

		}
		return list;
	}
	public List<MemberVO> selectGradeBoard() {
		
		List<MemberVO> list = new ArrayList<MemberVO>();
		String sql = "select * from idData order by id desc";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		MemberVO vo = null;
		try {
			conn = DBManager.getConnectin();
			stmt = conn.createStatement(); // conn.prepareStatement(sql);
			
			rs = stmt.executeQuery(sql); // pstmt.executeQuery();
			
			while (rs.next()) { // 행 단위 변화
				vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setAdmin(rs.getInt("admin"));
				
				list.add(vo);
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			DBManager.close(conn, stmt, rs);
			
		}
		return list;
	}
	
	public List<OutMemberVO> selectAllOutMember() {

		List<OutMemberVO> list = new ArrayList<OutMemberVO>();
		String sql = "select * from statics order by num desc";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		OutMemberVO vo = null;
		try {
			conn = DBManager.getConnectin();
			stmt = conn.createStatement(); // conn.prepareStatement(sql);

			rs = stmt.executeQuery(sql); // pstmt.executeQuery();

			while (rs.next()) { // 행 단위 변화
				vo = new OutMemberVO();
				vo.setNum(rs.getInt("num"));
				vo.setOutNum(rs.getInt("outNum"));
				vo.setContent(rs.getString("content"));
				vo.setAdmin(rs.getInt("admin"));
				
				list.add(vo);
			}

		} catch (Exception e) {
			
			e.printStackTrace();

		} finally {
			DBManager.close(conn, stmt, rs);

		}
		return list;
	}
	
	

	public List<MemberVO> selectCompanyAllBoards() {

		List<MemberVO> list = new ArrayList<MemberVO>();
		String sql = "select * from idData where admin=1 order by id desc ";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		MemberVO vo = null;
		try {
			conn = DBManager.getConnectin();
			stmt = conn.createStatement(); // conn.prepareStatement(sql);

			rs = stmt.executeQuery(sql); // pstmt.executeQuery();

			while (rs.next()) { // 행 단위 변화
				vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setPass(rs.getString("pass"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setNickname(rs.getString("nickname"));
				vo.setWritedate(rs.getTimestamp("writedate"));
				vo.setAdmin(rs.getInt("admin"));
				vo.setAddress(rs.getString("address"));
				vo.setCompanyName(rs.getString("companyName"));
				vo.setCompanyPhone(rs.getString("companyPhone"));
				
				list.add(vo);
			}

		} catch (Exception e) {
			
			e.printStackTrace();

		} finally {
			DBManager.close(conn, stmt, rs);

		}
		return list;
	}


	
		public void selectDelete(String id){
			System.out.println(id+": id");
			String sql = "delete from idData where id=?";
			Connection conn = null;
			PreparedStatement pstmt = null;

			try {
				conn = DBManager.getConnectin();
				pstmt = conn.prepareStatement(sql);

				pstmt.setString(1, id);
				pstmt.executeUpdate();

				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
		public void selectOutMemberDelete(String num){
			System.out.println(num+": num");
			String sql = "delete from statics where num=?";
			Connection conn = null;
			PreparedStatement pstmt = null;

			try {
				conn = DBManager.getConnectin();
				pstmt = conn.prepareStatement(sql);

				pstmt.setString(1, num);
				pstmt.executeUpdate();

				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
		public void selectBoardDelete(String num){
			System.out.println(num+": num");
			String sql = "delete from BoardData where num=?";
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			try {
				conn = DBManager.getConnectin();
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, num);
				pstmt.executeUpdate();
				
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
	public void memberInsertUpdate(MemberVO vo){
		String sql = "update idData set pass=?, name=?, nickname=?, email=? where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnectin();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPass());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getNickname());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getId());
			System.out.println("vovoovovovovoovovovoovovov");
			System.out.println(vo.getPass());
			System.out.println(vo.getName());
			System.out.println(vo.getNickname());
			System.out.println(vo.getEmail());
			System.out.println(vo.getId());
			
 // 문장 완성됐다~
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		//#89] 리턴!
	}
	public void gradeInsertUpdate(MemberVO vo){
		String sql = "update idData set admin=? where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnectin();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getAdmin());
			pstmt.setString(2, vo.getId());
			System.out.println("vovoovovovovoovovovoovovov");
			System.out.println(vo.getId());
			System.out.println(vo.getAdmin());
 // 문장 완성됐다~
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		//#89] 리턴!
	}
	public void companyInsertUpdate(MemberVO vo){
		String sql = "update idData set pass=?, name=?, nickname=?, email=?, address=?, companyName=?, companyPhone=? where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnectin();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPass());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getNickname());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getAddress());
			pstmt.setString(6, vo.getCompanyName());
			pstmt.setString(7, vo.getCompanyPhone());
			
			pstmt.setString(8, vo.getId());
			System.out.println("vovoovovovovoovovovoovovov");
			System.out.println(vo.getPass());
			System.out.println(vo.getName());
			System.out.println(vo.getNickname());
			System.out.println(vo.getEmail());
			System.out.println(vo.getId());
			
			// 문장 완성됐다~
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		//#89] 리턴!
	}
	
	public MemberVO SelectOneMember(String id){
		
		String sql = "select * from idData where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVO vo = null;
		try {
			conn = DBManager.getConnectin();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) { // 글 한건!
				vo = new MemberVO();
				vo.setPass(rs.getString("pass"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setNickname(rs.getString("nickname"));
				vo.setId(rs.getString("id"));
				vo.setAdmin(rs.getInt("admin"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		// #46] BoardViewAction으로 돌아가자
		return vo;

	}

public MemberVO SelectOneGrade(String id){
		
		String sql = "select * from idData where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVO vo = null;
		try {
			conn = DBManager.getConnectin();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) { // 글 한건!
				vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setAdmin(rs.getInt("admin"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		// #46] BoardViewAction으로 돌아가자
		return vo;

	}


	
	
public MemberVO SelectOneCompany(String id){
		
		String sql = "select * from idData where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVO vo = null;
		try {
			conn = DBManager.getConnectin();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) { // 글 한건!
				vo = new MemberVO();
				vo.setPass(rs.getString("pass"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setNickname(rs.getString("nickname"));
				vo.setId(rs.getString("id"));
				vo.setAddress(rs.getString("address"));
				vo.setCompanyName(rs.getString("companyName"));
				vo.setCompanyPhone(rs.getString("companyPhone"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		// #46] BoardViewAction으로 돌아가자
		return vo;

	}
	public List<MemberVO> selectOneBoards(String searchtext) {

		List<MemberVO> list = new ArrayList<MemberVO>();

		String sql = "select * from idData  where id LIKE '%"+searchtext+"%'  order by id desc";
		Connection conn = null;
		Statement pstmt = null;
		ResultSet rs = null;
		MemberVO vo = null;
		try {
			conn = DBManager.getConnectin();
			pstmt = conn.createStatement();
			rs = pstmt.executeQuery(sql); // pstmt.executeQuery();

			while (rs.next()) { // 행 단위 변화
				
				vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setPass(rs.getString("pass"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setNickname(rs.getString("nickname"));
				vo.setWritedate(rs.getTimestamp("writedate"));
				vo.setAdmin(rs.getInt("admin"));

				list.add(vo);
			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			DBManager.close(conn, pstmt, rs);

		}
		// #10] BoardListAction으로 가자!!!!!
		return list;
	}
	public List<MemberVO> selectOneGrades(String searchtext) {

		List<MemberVO> list = new ArrayList<MemberVO>();

		String sql = "select * from idData  where id LIKE '%"+searchtext+"%'  order by id desc";
		Connection conn = null;
		Statement pstmt = null;
		ResultSet rs = null;
		MemberVO vo = null;
		try {
			conn = DBManager.getConnectin();
			pstmt = conn.createStatement();
			rs = pstmt.executeQuery(sql); // pstmt.executeQuery();

			while (rs.next()) { // 행 단위 변화
				
				vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setAdmin(rs.getInt("admin"));

				list.add(vo);
			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			DBManager.close(conn, pstmt, rs);

		}
		return list;
	}
	public List<MemberVO> selectOneCompanys(String searchtext) {
		
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		String sql = "select * from idData  where id LIKE '%"+searchtext+"%'  order by id desc";
		Connection conn = null;
		Statement pstmt = null;
		ResultSet rs = null;
		MemberVO vo = null;
		try {
			conn = DBManager.getConnectin();
			pstmt = conn.createStatement();
			rs = pstmt.executeQuery(sql); // pstmt.executeQuery();
			
			while (rs.next()) { // 행 단위 변화
				
				vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setPass(rs.getString("pass"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setNickname(rs.getString("nickname"));
				vo.setWritedate(rs.getTimestamp("writedate"));
				vo.setAdmin(rs.getInt("admin"));
				vo.setAddress(rs.getString("address"));
				vo.setCompanyName(rs.getString("companyName"));
				vo.setCompanyPhone(rs.getString("companyPhone"));
				
				list.add(vo);
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			DBManager.close(conn, pstmt, rs);
			
		}
		// #10] BoardListAction으로 가자!!!!!
		return list;
	}
	public List<BoardVO> selectOneBoardBoards(String boardsearchtext, String optionnum) {
		
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		String sql = "select * from BoardData where "+optionnum+" LIKE '%"+boardsearchtext+"%' order by title desc";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		BoardVO vo = null;
		try {
			conn = DBManager.getConnectin();
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql); // pstmt.executeQuery();
			
			while (rs.next()) { // 행 단위 변화
				vo = new BoardVO();
				vo.setNum(rs.getInt("num"));
				vo.setId(rs.getString("id"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setReadcount(rs.getInt("readcount"));
				vo.setWritedate(rs.getTimestamp("writedate"));
				vo.setFileRoad(rs.getString("fileRoad"));
				vo.setBoardkind(rs.getString("boardkind"));
				
				list.add(vo);
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			DBManager.close(conn, stmt, rs);
			
		}
		return list;
	}
	public List<BoardVO> selectAll() {

		List<BoardVO> list = new ArrayList<BoardVO>();
		String sql = "select * from BoardData order by num desc";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		BoardVO vo = null;
		try {
			conn = DBManager.getConnectin();
			stmt = conn.createStatement(); // conn.prepareStatement(sql);

			rs = stmt.executeQuery(sql); // pstmt.executeQuery();

			while (rs.next()) { // 행 단위 변화
				vo = new BoardVO();
				vo.setNum(rs.getInt("num"));
				vo.setId(rs.getString("id"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setReadcount(rs.getInt("readcount"));
				vo.setWritedate(rs.getTimestamp("writedate"));
				vo.setFileRoad(rs.getString("fileRoad"));
				
				list.add(vo);
			}

		} catch (Exception e) {
			
			e.printStackTrace();

		} finally {
			DBManager.close(conn, stmt, rs);

		}
		return list;
	}

}
