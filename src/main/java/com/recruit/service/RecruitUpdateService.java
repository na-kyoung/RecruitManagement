package com.recruit.service;

import com.recruit.impl.RecruitDAO;
import com.recruit.impl.RecruitDTO;

// ������ ���� Ŭ����
public class RecruitUpdateService {
	private RecruitDAO rDAO;
		
	public RecruitUpdateService(RecruitDAO rDAO) {
		this.rDAO = rDAO;
	}

	// ������ �ߺ� Ȯ�� (�־�� ����)
	public boolean verify(String recruitId) {
		RecruitDTO rDTO = rDAO.select(recruitId);
		if(rDTO != null) {	// ������ ����
			return true;
		} else {				// ������ ����
			return false;
		}
	}
	
	// ������ ����
	public void update(RecruitDTO rDTO) {
		if(verify(rDTO.getRecruitId())) {	// ������ ���� - ����
			rDAO.update(rDTO);
		} else {						// ������ ����
			System.out.println("No Information. Check recruitId!");
		}
		
	}

}
