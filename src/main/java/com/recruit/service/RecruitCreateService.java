package com.recruit.service;

import com.recruit.impl.RecruitDAO;
import com.recruit.impl.RecruitDTO;

// 데이터 생성 클래스
public class RecruitCreateService {
	private RecruitDAO rDAO;
	
	public RecruitCreateService(RecruitDAO rDAO){
		super();
		this.rDAO = rDAO;		
	}
	
	// 데이터 중복 확인 (없어야 생성)
	public boolean verify(String recruitId) {
		RecruitDTO rDTO = rDAO.select(recruitId);
		if(rDTO == null) {	// 데이터 없음
			return true;
		} else {				// 데이터 있음
			return false;
		}
	}
	
	// 새 데이터 생성
	public void create(RecruitDTO rDTO) {
		// 데이터 중복 체크 후 데이터 저장
		if(verify(rDTO.getRecruitId())) {	// 데이터 없음 - 저장
			rDAO.insert(rDTO);
		} else {						// 데이터 있음
			System.out.println("ID 중복");
		}
	}
}
