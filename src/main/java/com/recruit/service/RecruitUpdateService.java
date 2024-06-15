package com.recruit.service;

import com.recruit.impl.RecruitDAO;
import com.recruit.impl.RecruitDTO;

// 데이터 수정 클래스
public class RecruitUpdateService {
	private RecruitDAO rDAO;
		
	public RecruitUpdateService(RecruitDAO rDAO) {
		this.rDAO = rDAO;
	}

	// 데이터 중복 확인 (있어야 수정)
	public boolean verify(String recruitId) {
		RecruitDTO rDTO = rDAO.select(recruitId);
		if(rDTO != null) {	// 데이터 있음
			return true;
		} else {				// 데이터 없음
			return false;
		}
	}
	
	// 데이터 수정
	public void update(RecruitDTO rDTO) {
		if(verify(rDTO.getRecruitId())) {	// 데이터 있음 - 수정
			rDAO.update(rDTO);
		} else {						// 데이터 없음
			System.out.println("No Information. Check recruitId!");
		}
		
	}

}
