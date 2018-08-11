package food.logindao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import food.logindto.OutStaticsVo;
import util.DBManager;

public class OutStaticsdao {

	private OutStaticsdao(){
		
	}
	private static OutStaticsdao instance = new OutStaticsdao();
	public static OutStaticsdao getInstance(){
		return instance;
	}

	
	public int insertOutStatics(OutStaticsVo vo){
		
		String sql="insert into statics values(statics_seq.nextval,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;

		
		int result=0;
		try{
			System.out.println(vo.getOutNum()+": numnum");
			System.out.println(vo.getContent());
			System.out.println(vo.getAdmin());
			conn = DBManager.getConnectin();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getOutNum());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getAdmin());

			result = pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt);
		}
		
		System.out.println("result"+result);
		
		return result;
	}
	
	
}

