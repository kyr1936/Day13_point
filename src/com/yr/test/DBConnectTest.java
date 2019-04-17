package com.yr.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import com.yr.point.PointDAO;
import com.yr.point.PointDTO;

public class DBConnectTest {

	@Test
	public void selectListTest() throws Exception {
		PointDAO dao = new PointDAO();
		ArrayList<PointDTO> ar = dao.selectList();
		assertNotEquals(0, ar.size());
	}
	
	
	
	
	
	//@Test
	public void selectOneTest() throws Exception {
		PointDAO dao = new PointDAO();
		PointDTO dto = dao.selectOne(2);
		assertNotNull(dto);
		
	}
	
	/*
	@Test
	public void deleteTest() throws Exception {
		PointDAO dao = new PointDAO();
		int result = dao.delete(5);
		assertEquals(1, result);
		
	}
	
	@Test
	public void test() throws Exception {
		
		PointDAO dao = new PointDAO();
		PointDTO dto = new PointDTO();
		dto.setNum(2);
		dto.setSid("id");
		dto.setKor(20);
		int result = dao.insert(dto);
		
		assertEquals(1, result);
	}
*/
	
	
}
