package com.javaex.controller;



import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.PhonebookDao;
import com.javaex.service.PhonebookService;
import com.javaex.vo.PersonVo;



@Controller
public class PhonebookController {
	
	//필드
	//dao를 메모리에 올린다
	/*
	@Autowired
	private PhonebookDao phonebookDao;*/
	
	@Autowired
	private PhonebookService phonebookService;
	
	
	//생성자
	//메서드 gs
	//메서드 일반
	
	//등록폼
	//등록
	//리스트
	//등록폼
	
	
	//메서드 일반 ////////////////////////////////////////	
	
	/* 수정 */
	//  /editform?no=2
	
	@RequestMapping ( value="edit", method= { RequestMethod.GET, RequestMethod.POST } )
	public String edit ( @ModelAttribute PersonVo personVo ) {
		
		System.out.println("phonebookController.editform()");
		
		phonebookService.exePersonEdit(personVo);
		
		

		
		return "redirect:/list";
	} 
	
	/* 수정폼2 db에서 Map으로 데이터 보내줌 */
	@RequestMapping ( value="editform2", method= { RequestMethod.GET, RequestMethod.POST } )
	public String editForm2 ( @RequestParam(value="no") int no , Model model) { 
	
		System.out.println("phonebookController.editform2()");
		
		Map<String, Object> personMap = phonebookService.exeGetPersonOne2(no);
		System.out.println(personMap);
		
		model.addAttribute("personMap", personMap);
		
		
		return "editForm2";
	}
	
	
	
	
	/* 수정폼 */
	//  /editform?no=2
	@RequestMapping ( value="editform", method= { RequestMethod.GET, RequestMethod.POST } )
	public String editForm ( @RequestParam(value="no") int no , Model model) {
		
		System.out.println("phonebookController.editform()");
		
		PersonVo personVo = phonebookService.exeGetPersonOne(no);
		
		model.addAttribute("personVo", personVo);
		
		
		return "editForm";
		//return "/WEB-INF/views/editForm.jsp";
	}
	
	
	/* 삭제 */
	@RequestMapping ( value="delete", method= {RequestMethod.GET, RequestMethod.POST} ) 
	public String delete( @RequestParam(value="no") String no  ) {
		
		System.out.println("phonebookController.delete()");
		
		int c = phonebookService.exePersonDelete(Integer.parseInt(no));
		System.out.println(c);
		
		
		
		
		
		
		//System.out.println(no);
  
		
		//메소드를 이용해서 저장한다
		//int count = phonebookDao.deletePerson(Integer.parseInt(no));
		//System.out.println(count);		
		
		//리스트로 리다이렉트
		return "redirect:/list";
	}
	
	
	/* 등록폼 */
	@RequestMapping ( value="writeform", method={RequestMethod.GET, RequestMethod.POST}  )
	public String writeForm() {
		
		System.out.println("phonebookController.writeForm()");
		
		//return "/WEB-INF/views/writeForm.jsp";
		return "writeForm";
	}
	
	/* 등록 */
	//Vo로 받을떄
	@RequestMapping ( value="/write", method={RequestMethod.GET, RequestMethod.POST}  )
	public String write ( @ModelAttribute PersonVo personVo ) {
	
		int c = phonebookService.exeWritePerson(personVo);
		
		System.out.println("c:" + c);
		
		
		
	
		
		//리스트로 리다이렉트
		return "redirect:/list";
		
	}
	
	//파라미터 하나씩 받을때
	@RequestMapping ( value="/write2", method={RequestMethod.GET, RequestMethod.POST}  )
	public String write2 ( @RequestParam(value="name") String name,
						   @RequestParam(value="hp") String hp,
						   @RequestParam(value="company") String company ) {
		
		System.out.println("phonebookController.write2()");
		
		PersonVo personVo = new PersonVo(name, hp, company);
		System.out.println(personVo);
	
		
		return "redirect:/list";
		
	}
	
	@RequestMapping ( value="/list", method={RequestMethod.GET, RequestMethod.POST}  )
	public String list ( Model model ) {
		
		System.out.println("phonebookController.list()");
		
		List<PersonVo> personList = phonebookService.exeGetPersonList();
		
		model.addAttribute("personList", personList);
		
		
		
		return "list";
		
	}
	
	
	
	
	
	
	

}
