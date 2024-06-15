package com.recruit.service;

import com.recruit.impl.RecruitDAO;
import com.recruit.impl.RecruitDTO;

// ������ ���� Ŭ����
public class RecruitCreateService {
	private RecruitDAO rDAO;
	
	public RecruitCreateService(RecruitDAO rDAO){
		super();
		this.rDAO = rDAO;		
	}
	
	// ������ �ߺ� Ȯ�� (����� ����)
	public boolean verify(String recruitId) {
		RecruitDTO rDTO = rDAO.select(recruitId);
		if(rDTO == null) {	// ������ ����
			return true;
		} else {				// ������ ����
			return false;
		}
	}
	
	// �� ������ ����
	public void create(RecruitDTO rDTO) {
		// ������ �ߺ� üũ �� ������ ����
		if(verify(rDTO.getRecruitId())) {	// ������ ���� - ����
			rDAO.insert(rDTO);
		} else {						// ������ ����
			System.out.println("ID �ߺ�");
		}
	}
}
