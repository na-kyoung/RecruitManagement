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
		
		// �ʱ� ������
		InitSampleData sampleData = (InitSampleData) context.getBean("initSampleData");

		// �迭�� �ʱ� ������ ����
		String[] recruitIdData = sampleData.getRecruitIdData();
		String[] companyData = sampleData.getCompanyData();
		String[] fieldData = sampleData.getFieldData();
		String[] peopleData = sampleData.getPeopleData();
		String[] salaryData = sampleData.getSalaryData();
		String[] deadlineData = sampleData.getDeadlineData();
		
//		System.out.println("--- �迭 ������ ��� ����");
//		for(int i=0; i<recruitIdData.length; i++) {
//			System.out.println(	recruitIdData[i] + " : " + 
//					companyData[i] + " : " + 
//					fieldData[i] + " : " + 
//					peopleData[i] + " : " + 
//					salaryData[i] + " : " + 
//					deadlineData[i] );
//		}
//		System.out.println("--- �迭 ������ ��� �Ϸ�");
		
		
		
		// #1. ���ο� ������ ���� ��ü
		RecruitCreateService rCreateService = (RecruitCreateService) context.getBean("rCreateService");
		
		// #2. �ʱ� ������ DTO ��ü�� ����
		for(int i=0; i<recruitIdData.length; i++) {
			RecruitDTO rdto_1 = new RecruitDTO(); //�Ź� ���� �ҷ��;� ��
			rdto_1.setRecruitId(recruitIdData[i]);
			rdto_1.setCompany(companyData[i]);
			rdto_1.setField(fieldData[i]);
			rdto_1.setPeople(peopleData[i]);
			rdto_1.setSalary(salaryData[i]);
			rdto_1.setDeadline(deadlineData[i]);
			rCreateService.create(rdto_1);
		}
		
		// #3. ��ü ������ ���
//		RecruitDAO rdao = (RecruitDAO) context.getBean("rdao");
//		Map<String, RecruitDTO> RecruitInfo = rdao.select();
//		
//		System.out.println("--- ��ü ������ ��� ����");
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
//		System.out.println("--- ��ü ������ ��� ����");
		
		// #4. ���� ������ ������ ����
//		RecruitDTO rdto_2 = new RecruitDTO("r0006", "Daangn", "Full Stack Developer", "10", "4200", "2025.01.31");
		
		// #5. ������ ����
//		rCreateService.create(rdto_2);
		
		// #6. ������ ���� �� ��ü ������ ���
//		System.out.println("--- ������ ���� �� ��ü ������ ��� ����");
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
//		System.out.println("--- ������ ���� �� ��ü ������ ��� ����");
		
		// #3. ������ ���� �� ���
		RecruitReadService rReadService = (RecruitReadService) context.getBean("rReadService");
		System.out.println("----- ������ ���� �� ��ü ������ ���");
		rReadService.read(); // ���
		
		// #4. ������ �߰� �� ���
		RecruitDTO rdto_2 = new RecruitDTO("r0006", "Daangn", "Full Stack Developer", "10", "4200", "2025.01.31");
		rCreateService.create(rdto_2); // ������ ����
		System.out.println("----- ������ �߰� �� ��ü ������ ���");
		rReadService.read(); // ���
		
		// #5. ������ ���� �� ���
		RecruitUpdateService rUpdateService = (RecruitUpdateService) context.getBean("rUpdateService");
		rUpdateService.update(new RecruitDTO("r0006", "Daangn", "Web Designer", "10", "3200", "2025.02.28")); // ������ ����
		System.out.println("----- ������ ���� �� ��ü ������ ���");
		rReadService.read(); // ���
		
		// #6. ������ ���� �� ���
		RecruitDeleteService rDeleteService = (RecruitDeleteService) context.getBean("rDeleteService");
		rDeleteService.delete("r0006"); // ������ ����
		System.out.println("----- ������ ���� �� ��ü ������ ���");
		rReadService.read(); // ���
	}

}
