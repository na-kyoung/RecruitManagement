package com.recruit.service;

import java.util.Map;

import com.recruit.impl.RecruitDAO;
import com.recruit.impl.RecruitDTO;

// ������ ��ȸ Ŭ����
public class RecruitReadService {
	private RecruitDAO rDAO;
	
	public RecruitReadService(RecruitDAO rDAO) {
		this.rDAO = rDAO;
	}
	
	// ��ü ������ ��ȸ �� ���
	public void read() {
		Map<String, RecruitDTO> RecruitInfo = rDAO.select();
		
		System.out.println("--- readRecruitInfo START");
		for(Map.Entry<String, RecruitDTO> recruit : RecruitInfo.entrySet()) {
			System.out.println(	
//					recruit.getKey() + ", " +
					"Id : " + recruit.getValue().getRecruitId() + " / " +
					"Company : " + recruit.getValue().getCompany() + " / " +
					"Field : " + recruit.getValue().getField() + " / " +
					"People : " + recruit.getValue().getPeople() + " / " +
					"Salary : " + recruit.getValue().getSalary() + " / " +
					"Deadline : " + recruit.getValue().getDeadline() );
		}
		System.out.println("--- readRecruitInfo END");
	}

}
