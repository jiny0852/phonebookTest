package com.javaex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;

@Repository
public class PhonebookDao {
	
	// 필드
	
	@Autowired
	private SqlSession sqlSession;
	


	public int deletePerson(int no) {
		
		System.out.println("phonebookDao.deletePerson()");
		
		Map<String, Object> personMap = new HashMap<String, Object>();
		personMap.put("no", no);

		
		int count = sqlSession.delete("phonebook.delete", personMap);
		
		//int count = sqlSession.delete("phonebook.delete", no);
		
		

		
		return count;
	}
	
	
	
	//사랑 정보 수정하기 1명
	public int updatePerson(PersonVo personVo) {
		
		System.out.println("phonebookDao.updatePerson()");
		
		int count = sqlSession.update("phonebook.update", personVo);
		

		
		return count;
	}
	
	public int updatePerson2(PersonVo personVo) {
		
		System.out.println("phonebookDao.updatePerson()");
		
		int count = sqlSession.update("phonebook.update", personVo);
		

		
		return count;
	}
	
	
	//사람 1명 정보 가져오기
	public Map<String, Object> getPersonOne2(int no) {
		
		System.out.println("phonebookDao.getPersonOne2()");
		
		Map<String, Object> personMap = sqlSession.selectOne("phonebook.selectOneMap", no);
		
		System.out.println(personMap);
		
		
		return personMap;
	}
	
	public PersonVo getPersonOne(int no) {
		
		System.out.println("phonebookDao.getPersonOne()");
		
		
		PersonVo personVo = sqlSession.selectOne("phonebook.selectOne", no);
		
		
		
		return personVo;
	}
	
	
	//사람정보 저장
	public int insertPerson(PersonVo personVo) {
		
		System.out.println("phonebookDao.insertPerson()");
		
		//int count = sqlSession.insert("phonebook.insert", personVo);
		
		String name = "정우성";
		String hp = "010";
		String company = "02";
		
		Map<String, String> pMap = new HashMap<String, String>();
		pMap.put("name", name);
		pMap.put("hp", hp);
		pMap.put("company", company);
		
		pMap.get("name");
		
		int count = sqlSession.insert("phonebook.insert2", personVo);
		
		
		
		return count;
		
	}
	
	
	
	//리스트 가져오기
	public List<PersonVo> getPersonList() {
		
		System.out.println("phonebookDao.getPersonList()");
		
		List<PersonVo> personList = sqlSession.selectList("phonebook.selectList");
		
		System.out.println("===============");
		System.out.println(personList);
		System.out.println("===============");
		
		
		return personList;
		
	}
	
	
	
	
	
	
}
