package com.recruit.service;

import com.recruit.impl.RecruitDAO;
import com.recruit.impl.RecruitDTO;

// 데이터 삭제 클래스
public class RecruitDeleteService {
	private RecruitDAO rDAO;
	
	public RecruitDeleteService(RecruitDAO rDAO) {
		this.rDAO = rDAO;
	}
	
	// 데이터 중복 확인 (있어야 삭제)
	public boolean verify(String recruitId) {
		RecruitDTO rDTO = rDAO.select(recruitId);
		if(rDTO != null) {	// 데이터 있음
			return true;
		} else {				// 데이터 없음
			return false;
		}
	}
	
	// 데이터 삭제
	public void delete(String recruitId) {
		if(verify(recruitId)) {		// 데이터 있음 - 삭제
			rDAO.delete(recruitId);
		} else {				// 데이터 없음
			System.out.println("No Information. Check recruitId!");
		}
	}
}
