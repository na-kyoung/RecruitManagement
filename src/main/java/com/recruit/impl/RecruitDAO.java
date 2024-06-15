package com.recruit.impl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class RecruitDAO {
	
	// ������� ����ϱ� ���� LinkedHashMap ���
	private Map<String, RecruitDTO> recruitInfo = new LinkedHashMap<String, RecruitDTO>();
	
	// ������ ����
	public void insert(RecruitDTO rdto) {
		recruitInfo.put(rdto.getRecruitId(), rdto);
	}
	
	// ������ ���� (������ �ߺ� ���� Ȯ�ο�)
	public RecruitDTO select(String recruitId) {
		return recruitInfo.get(recruitId);
	}

	// ������ ����
	public void update(RecruitDTO rdto) {
		recruitInfo.put(rdto.getRecruitId(), rdto);
	}
	
	// ������ ����
	public void delete(String recruitId) {
		recruitInfo.remove(recruitId);
	}
	
	// ������ ��ȸ (��ü ������ ��ȸ��)
	public Map<String, RecruitDTO> select() {
		return recruitInfo;
	}

}
