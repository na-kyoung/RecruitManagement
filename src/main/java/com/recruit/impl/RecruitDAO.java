package com.recruit.impl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class RecruitDAO {
	
	// 순서대로 출력하기 위해 LinkedHashMap 사용
	private Map<String, RecruitDTO> recruitInfo = new LinkedHashMap<String, RecruitDTO>();
	
	// 데이터 저장
	public void insert(RecruitDTO rdto) {
		recruitInfo.put(rdto.getRecruitId(), rdto);
	}
	
	// 데이터 선택 (데이터 중복 여부 확인용)
	public RecruitDTO select(String recruitId) {
		return recruitInfo.get(recruitId);
	}

	// 데이터 수정
	public void update(RecruitDTO rdto) {
		recruitInfo.put(rdto.getRecruitId(), rdto);
	}
	
	// 데이터 삭제
	public void delete(String recruitId) {
		recruitInfo.remove(recruitId);
	}
	
	// 데이터 조회 (전체 데이터 조회용)
	public Map<String, RecruitDTO> select() {
		return recruitInfo;
	}

}
