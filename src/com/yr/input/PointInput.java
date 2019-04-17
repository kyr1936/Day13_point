package com.yr.input;

import java.util.Scanner;

import com.yr.point.PointDTO;

public class PointInput {
	
	public int setNum(String str) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println(str+"번호를 입력하세요");
		int num = sc.nextInt();
		
		return num;
		
	}
	
	public PointDTO setPoint() {
		Scanner sc = new Scanner(System.in);
		PointDTO dto = new PointDTO();
		
		System.out.println("num 입력");
		dto.setNum(sc.nextInt());
		System.out.println("sid 입력");
		dto.setSid(sc.next());
		System.out.println("kor 입력");
		dto.setKor(sc.nextInt());
		System.out.println("eng 입력");
		dto.setEng(sc.nextInt());
		System.out.println("math 입력");
		dto.setMath(sc.nextInt());
		dto.setTotal(dto.getKor()+dto.getEng()+dto.getMath());
		dto.setAvg(dto.getTotal()/3.0);
		System.out.println("bnum 입력");
		dto.setBnum(sc.nextInt());
		
		return dto;
	}
	
}
