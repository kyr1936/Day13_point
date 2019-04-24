package com.yr.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;
import com.yr.point.PointDAO;
import com.yr.point.PointDTO;

public class DBConnectTest {

//	@Test
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
	
	
//	@Test
	public void deleteTest() throws Exception {
		PointDAO dao = new PointDAO();
		int result = dao.delete(5);
		assertEquals(1, result);
		
	}
	
	@Test
	public void test() throws Exception {
		
		PointDAO dao = new PointDAO();
		Random rd = new Random();
		for(int i=0; i<99; i++) {	
		PointDTO dto = new PointDTO();
		int num = dao.selectNum();
		dto.setNum(num+1);
		dto.setSid("iu"+i);
		dto.setKor(rd.nextInt(101));
		dto.setEng(rd.nextInt(101));
		int result = dao.insert(dto);

		}
	}

	
	
}
