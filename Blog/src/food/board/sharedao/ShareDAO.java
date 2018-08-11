package food.board.sharedao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import food.board.dto.foodVO;
import util.DBManager;

public class ShareDAO {

	private ShareDAO(){}
	
	private static ShareDAO instance = new ShareDAO();
	
	public static ShareDAO getInstance(){
		return instance;
	}

	//shareListAction에서 넘어옴
	public List<foodVO>selectAllBoard(){
		List<foodVO> list = new ArrayList<foodVO>();
		String sql = "select * from BoardData free inner join idData id on free.id=id.id order by num desc";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		foodVO vo = null;
		
		try {
			conn = DBManager.getConnectin();
			stmt = conn.createStatement(); // conn.prepareStatement(sql);

			rs = stmt.executeQuery(sql); // pstmt.executeQuery();

			while (rs.next()) { // 행 단위 변화
				vo = new foodVO();
				vo.setNum(rs.getInt("NuM"));
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
		// #10] BoardListAction으로 가자!!!!!
		return list;
	}
	
	/**
	 * @param vo
	 * 
	 * */
	//데이터를 삽입한다.
	
	public void insertShareBoard(foodVO vo){
		String sql = "insert into BoardData(title, content, fileRoad) values("
				+ "BoardData_seq.nextval, ?, ?, ?)";
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	try {
		conn = DBManager.getConnectin();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getTitle());
		pstmt.setString(2, vo.getContent());
		pstmt.setString(3, vo.getFileRoad());
		 // 문장 완성됐다~

		// int result = pstmt.executeUpdate(); //result 에는 insert 실행 row수가
		// 담기게 된다.
		pstmt.executeUpdate();
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		DBManager.close(conn, pstmt);
	}
	// #34] 다시 BoardWriteAction으로 가자
	}
	
	
}
