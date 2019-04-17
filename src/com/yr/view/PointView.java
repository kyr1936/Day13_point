package com.yr.view;

import java.util.ArrayList;

import com.yr.point.PointDTO;

public class PointView {

	public void view(String message) {
		System.out.println(message);
	}
	

	public void view(PointDTO dto) {
		System.out.println("num : " + dto.getNum());
		System.out.println("sid : " + dto.getSid());
		System.out.println("kor : " + dto.getKor());
		System.out.println("eng : " + dto.getEng());
		System.out.println("math : " + dto.getMath());
		System.out.println("total : " + dto.getTotal());
		System.out.println("avg : " + dto.getAvg());
		System.out.println("bnum : " + dto.getBnum());
		System.out.println("=======================");
	}

	public void view(ArrayList<PointDTO> ar) {
		for(PointDTO dto:ar) {
			this.view(dto);
		}
		
	}







}
