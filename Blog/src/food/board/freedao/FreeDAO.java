package food.board.freedao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import food.board.dto.foodVO;
import util.DBManager;

public class FreeDAO {

	private FreeDAO() {
	}

	private static FreeDAO instance = new FreeDAO();

	public static FreeDAO getInstance() {
		return instance;
	}

	/**
	 */
	public List<foodVO> selectAllBoards(int num) {

		List<foodVO> list = new ArrayList<foodVO>();

		String sql = "select * from BoardData free inner join idData id on free.id=id.id where free.boardkind=? order by num desc";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		foodVO vo = null;
		System.out.println("들어옴?");
		try {
			conn = DBManager.getConnectin();
			stmt = conn.prepareStatement(sql); 
			stmt.setInt(1,num);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				vo = new foodVO();
				vo.setNum(rs.getInt("num"));
				vo.setPass(rs.getString("pass"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setReadcount(rs.getInt("readcount"));
				vo.setWritedate(rs.getTimestamp("writedate"));
				
				
				list.add(vo);
			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			DBManager.close(conn, stmt, rs);

		}
		return list;
	}

	/**
	 * 데이터 삽입
	 * 
	 * @param vo
	 */
	public void insertBoard(foodVO vo) {
		String sql = "insert into boarddata(num,id,title, content,boardkind) values("
				+ "BoardData_seq.nextval, ?, ?, ?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnectin();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.setInt(4, vo.getBoardkind());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	/**
	 */
	public void updateReadCount(String num) {
		String sql = "update boarddata  set readcount = readcount+1 where num=?";
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

	/**
	 * 글번호 한건에 대한 모든 내용(6개 컬럼)을 읽어 와서 리턴 시키자!
	 * 
	 * @param num
	 * @return
	 */
	public foodVO selectOneBoard(String num) {

		String sql = "select * from boarddata free inner join idData id on free.id=id.id where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		foodVO vo = null;
		try {
			conn = DBManager.getConnectin();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				vo = new foodVO();
				vo.setNum(rs.getInt("NuM"));
				vo.setId(rs.getString("id"));
				vo.setPass(rs.getString("pass"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setReadcount(rs.getInt("readcount"));
				vo.setWritedate(rs.getTimestamp("writedate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return vo;

	}

	public foodVO checkPassword(String num, String pass) {
		String sql = "select * from BoardData free inner join idData id on free.id=id.id where free.num=? and id.pass=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		foodVO vo = null;
		System.out.println("id"+num+pass);
		try {
			conn = DBManager.getConnectin();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, num);
			pstmt.setString(2, pass);
			rs = pstmt.executeQuery();

			if (rs.next()) { 
				vo = new foodVO();
				vo.setNum(rs.getInt("NuM"));
				vo.setPass(rs.getString("pass"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setReadcount(rs.getInt("readcount"));
				vo.setWritedate(rs.getTimestamp("writedate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return vo;
	}

	/**
	 * .
	 */
	public void updateFree(foodVO vo) {
		String sql = "update boarddata  set title=?, content=? where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		System.out.println("11");

		try {
			conn = DBManager.getConnectin();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getNum()); 
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	/**
	 * 
	 * @param num
	 */
	public void deleteFree(String num) {
		String sql ="delete from boarddata where num=?";
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

}
