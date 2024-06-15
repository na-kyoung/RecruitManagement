package com.recruit.service;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.recruit.impl.RecruitDAO;
import com.recruit.impl.RecruitDTO;
import com.recruit.util.InitSampleData;

public class RecruitMain {

	public static void main(String[] args) {
		
		// XML
		ApplicationContext context = new ClassPathXmlApplicationContext("recruitContext.xml");
		
		// 초기 데이터
		InitSampleData sampleData = (InitSampleData) context.getBean("initSampleData");

		// 배열에 초기 데이터 저장
		String[] recruitIdData = sampleData.getRecruitIdData();
		String[] companyData = sampleData.getCompanyData();
		String[] fieldData = sampleData.getFieldData();
		String[] peopleData = sampleData.getPeopleData();
		String[] salaryData = sampleData.getSalaryData();
		String[] deadlineData = sampleData.getDeadlineData();
		
//		System.out.println("--- 배열 데이터 출력 시작");
//		for(int i=0; i<recruitIdData.length; i++) {
//			System.out.println(	recruitIdData[i] + " : " + 
//					companyData[i] + " : " + 
//					fieldData[i] + " : " + 
//					peopleData[i] + " : " + 
//					salaryData[i] + " : " + 
//					deadlineData[i] );
//		}
//		System.out.println("--- 배열 데이터 출력 완료");
		
		
		
		// #1. 새로운 데이터 생성 객체
		RecruitCreateService rCreateService = (RecruitCreateService) context.getBean("rCreateService");
		
		// #2. 초기 데이터 DTO 객체에 저장
		for(int i=0; i<recruitIdData.length; i++) {
			RecruitDTO rdto_1 = new RecruitDTO(); //매번 새로 불러와야 함
			rdto_1.setRecruitId(recruitIdData[i]);
			rdto_1.setCompany(companyData[i]);
			rdto_1.setField(fieldData[i]);
			rdto_1.setPeople(peopleData[i]);
			rdto_1.setSalary(salaryData[i]);
			rdto_1.setDeadline(deadlineData[i]);
			rCreateService.create(rdto_1);
		}
		
		// #3. 전체 데이터 출력
//		RecruitDAO rdao = (RecruitDAO) context.getBean("rdao");
//		Map<String, RecruitDTO> RecruitInfo = rdao.select();
//		
//		System.out.println("--- 전체 데이터 출력 시작");
//		for(Map.Entry<String, RecruitDTO> recruit : RecruitInfo.entrySet()) {
//			System.out.println(	
////					"Id" + recruit.getKey() + ", " +
//					"Id : " + recruit.getValue().getRecruitId() + " / " +
//					"Company : " + recruit.getValue().getCompany() + " / " +
//					"Field : " + recruit.getValue().getField() + " / " +
//					"People : " + recruit.getValue().getPeople() + " / " +
//					"Salary : " + recruit.getValue().getSalary() + " / " +
//					"Deadline : " + recruit.getValue().getDeadline() );
//		}
//		System.out.println("--- 전체 데이터 출력 시작");
		
		// #4. 새로 생성할 데이터 설정
//		RecruitDTO rdto_2 = new RecruitDTO("r0006", "Daangn", "Full Stack Developer", "10", "4200", "2025.01.31");
		
		// #5. 데이터 저장
//		rCreateService.create(rdto_2);
		
		// #6. 데이터 저장 후 전체 데이터 출력
//		System.out.println("--- 데이터 저장 후 전체 데이터 출력 시작");
//		for(Map.Entry<String, RecruitDTO> recruit : RecruitInfo.entrySet()) {
//			System.out.println(	
////					"Id" + recruit.getKey() + ", " +
//					"Id : " + recruit.getValue().getRecruitId() + " / " +
//					"Company : " + recruit.getValue().getCompany() + " / " +
//					"Field : " + recruit.getValue().getField() + " / " +
//					"People : " + recruit.getValue().getPeople() + " / " +
//					"Salary : " + recruit.getValue().getSalary() + " / " +
//					"Deadline : " + recruit.getValue().getDeadline() );
//		}
//		System.out.println("--- 데이터 저장 후 전체 데이터 출력 시작");
		
		// #3. 데이터 생성 후 출력
		RecruitReadService rReadService = (RecruitReadService) context.getBean("rReadService");
		System.out.println("----- 데이터 생성 후 전체 데이터 출력");
		rReadService.read(); // 출력
		
		// #4. 데이터 추가 후 출력
		RecruitDTO rdto_2 = new RecruitDTO("r0006", "Daangn", "Full Stack Developer", "10", "4200", "2025.01.31");
		rCreateService.create(rdto_2); // 데이터 저장
		System.out.println("----- 데이터 추가 후 전체 데이터 출력");
		rReadService.read(); // 출력
		
		// #5. 데이터 수정 후 출력
		RecruitUpdateService rUpdateService = (RecruitUpdateService) context.getBean("rUpdateService");
		rUpdateService.update(new RecruitDTO("r0006", "Daangn", "Web Designer", "10", "3200", "2025.02.28")); // 데이터 수정
		System.out.println("----- 데이터 수정 후 전체 데이터 출력");
		rReadService.read(); // 출력
		
		// #6. 데이터 삭제 후 출력
		RecruitDeleteService rDeleteService = (RecruitDeleteService) context.getBean("rDeleteService");
		rDeleteService.delete("r0006"); // 데이터 삭제
		System.out.println("----- 데이터 삭제 후 전체 데이터 출력");
		rReadService.read(); // 출력
	}

}
