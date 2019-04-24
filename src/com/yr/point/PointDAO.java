package com.yr.point;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Set;

import javax.naming.spi.DirStateFactory.Result;

import com.yr.util.DBConnector;

public class PointDAO {		// 조작만 함
	
	// 접근지정자 [그외지정자] 리턴타입 메서드명([매개변수선언])
	
	
	
	public int selectNum() throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "select nvl(max(num),0) from point";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		rs.next();
		int num = rs.getInt(1);
		
	//	DBConnector.disConnect(st, con, rs);
		return num;
		
		
		
	}
	
	
	public ArrayList<PointDTO> selectList() throws Exception {
		Connection con = DBConnector.getConnect();
		String sql = "select*from point order by num desc";
		
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		PointDTO dto = null;
		ArrayList<PointDTO> ar = new ArrayList<PointDTO>();
		while(rs.next()) {
			dto = new PointDTO();
			dto.setNum(rs.getInt("num"));
			dto.setSid(rs.getString("sid"));
			dto.setKor(rs.getInt("kor"));
			dto.setEng(rs.getInt("eng"));
			dto.setMath(rs.getInt("math"));
			dto.setTotal(rs.getInt("total"));
			dto.setAvg(rs.getDouble("avg"));
			dto.setBnum(rs.getInt("bnum"));	
			ar.add(dto);
		
		}
		DBConnector.disConnect(st, con, rs);
		return ar;
	}
	
	
	//select one : 번호num를  입력 받아서 해당하는 데이터를 리턴
	
	public PointDTO selectOne(int num) throws Exception {
		Connection con = DBConnector.getConnect();
		
		String sql = "select*from point where num=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, num);
		
		ResultSet rs = st.executeQuery();
		PointDTO dto = null;
		
		if(rs.next()) {
			dto = new PointDTO();
			dto.setNum(rs.getInt("num"));
			dto.setSid(rs.getString("sid"));
			dto.setKor(rs.getInt("kor"));
			dto.setEng(rs.getInt("eng"));
			dto.setMath(rs.getInt("math"));
			dto.setTotal(rs.getInt("total"));
			dto.setAvg(rs.getDouble("avg"));
			dto.setBnum(rs.getInt("bnum"));	
		} 
		

		DBConnector.disConnect(st, con, rs);
		return dto;
	}
	
	
	// insert
	public int insert(PointDTO dto) throws Exception{
		Connection con = DBConnector.getConnect();
		
		String sql = "insert into point values(?,?,?,?,?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, dto.getNum());
		st.setString(2, dto.getSid());
		st.setInt(3, dto.getKor());
		st.setInt(4, dto.getEng());
		st.setInt(5, dto.getMath());
		st.setInt(6, dto.getTotal());
		st.setDouble(7, dto.getAvg());
		st.setInt(8, dto.getBnum());

		int result = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		
		return result;
	}
	
	// update
	public int update()  throws Exception{
		Connection con = DBConnector.getConnect();
		String sql = "update set";
		
		
		int result=0;
		return result;
	}
	
	// delete
	public int delete(int num) throws Exception {
		
		Connection con = DBConnector.getConnect();
		String sql = "delete point where num=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, num);
		
		int result=st.executeUpdate();
		return result;
	}
	


}
