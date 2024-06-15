package com.recruit.service;

import com.recruit.impl.RecruitDAO;
import com.recruit.impl.RecruitDTO;

// ������ ���� Ŭ����
public class RecruitDeleteService {
	private RecruitDAO rDAO;
	
	public RecruitDeleteService(RecruitDAO rDAO) {
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
	public void delete(String recruitId) {
		if(verify(recruitId)) {		// ������ ���� - ����
			rDAO.delete(recruitId);
		} else {				// ������ ����
			System.out.println("No Information. Check recruitId!");
		}
	}
}
