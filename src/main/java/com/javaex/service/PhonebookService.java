package com.javaex.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PhonebookDao;
import com.javaex.vo.PersonVo;

@Service
public class PhonebookService {
	
	//필드
	@Autowired
	private PhonebookDao phonebookDao;
	
	
	
	
	//메서드 일반
	
	/* 전화번호 등록 */
	public int exeWritePerson (PersonVo personVo) {
		
		System.out.println("PhonebookService.exeWritePerson()");
		
		System.out.println(personVo);
		
		int count = phonebookDao.insertPerson(personVo);
		
		return count;
		
	}
	
	
	
	/* 전화번호 전체 가져오기 */
	public List<PersonVo> exeGetPersonList() {
		
		System.out.println("PhonebookService.exeGetPerson()");
		
		List<PersonVo> personList = phonebookDao.getPersonList();
		
		
		return personList;
	}
	
	
	/* 전화번호 삭제 */
	public int exePersonDelete (int no) {
		
		System.out.println("PhonebookService.exePersonDelete()");
		
		int count = phonebookDao.deletePerson(no);
		
		return count;
	}
	
	
	/* 전화번호 수정 */
	public int exePersonEdit (PersonVo personVo) {
		
		System.out.println("PhonebookService.exePersonEdit()");
		
		int count = phonebookDao.updatePerson(personVo);
		
		
		return count;
	}
	
	/* 전화번호 수정2 */
	public Map<String, Object> exeEditForm2 (PersonVo personVo) {
		
		System.out.println("PhonebookService.exePersonEdit2()");
		
		int count = phonebookDao.updatePerson(personVo);
		
		
		return null;
	}
	
	
	
	/* 전화번호 한명 가져오기 */
	public PersonVo exeGetPersonOne (int no) {
		
		System.out.println("PhonebookService.exeGetPersonOne()");
		
		PersonVo personVo = phonebookDao.getPersonOne(no);
		
		
		return personVo;
	}
	
	public Map<String, Object> exeGetPersonOne2 (int no) {
		
		System.out.println("PhonebookService.exeGetPersonOne2()");
		
		Map<String, Object> personMap = phonebookDao.getPersonOne2(no);
		
		
		return personMap;
	}
	
	
	

}
