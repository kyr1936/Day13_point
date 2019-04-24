package com.yr.control;

import java.util.ArrayList;
import java.util.Scanner;

import com.yr.input.PointInput;
import com.yr.point.PointDAO;
import com.yr.point.PointDTO;
import com.yr.view.PointView;

public class PointController {

	// 1. 정보 추가
	// 2. 정보 삭제
	// 3. 정보 번호 조회
	// 4. 정보 전체 조회
	// 5. 종      료
	private Scanner sc;
	private PointDAO dao;
	private PointInput pi;
	private PointView pv;
	
	public PointController() {
		sc = new Scanner(System.in);
		pi = new PointInput();
		pv = new PointView();
		dao = new PointDAO();
	}

	public void start() throws Exception {
		PointDTO dto = null;
		boolean check = true;
		while(check) {
			System.out.println("1. 정보 추가");
			System.out.println("2. 정보 삭제");
			System.out.println("3. 정보 번호 조회");
			System.out.println("4. 정보 전체 조회");
			System.out.println("5. 종 료");
			int select = sc.nextInt();

			switch(select) {
			case 1: 
				
				dto = pi.setPoint();
				int num = dao.selectNum();
				dto.setNum(num+1);
				
				int result = dao.insert(dto);
				String message = "등록 실패";
				if(result>0) {
					message = "등록 성공";
				}
				pv.view(message);
				break;
			case 2:
				num = pi.setNum("삭제할 ");
				result = dao.delete(num);
				message = "삭제 실패";
				if(result>0) {
					message = "삭제 성공";
				}
				pv.view(message);
				break;
			case 3: 
				num = pi.setNum("조회할 ");
				dto = dao.selectOne(num);


				if(dto!=null) {
					pv.view(dto);
				} else {
					pv.view("번호가 없습니다.");
				}
				break;
			case 4:
				ArrayList<PointDTO> ar = dao.selectList();
				pv.view(ar);

				break;
			case 5:
				System.out.println("종료합니다.");
				check=!check;

			}


		}


	}



}
