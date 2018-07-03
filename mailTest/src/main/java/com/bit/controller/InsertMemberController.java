package com.bit.controller;


import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.swing.plaf.multi.MultiToolTipUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bit.dao.MemberDao;
import com.bit.vo.MemberVo;


@Controller
@RequestMapping("/insertMember.do")
public class InsertMemberController {

	
	@Autowired
	private MemberDao dao;
		
	public void setDao(MemberDao dao) {
		this.dao = dao;
	}

	@RequestMapping(method=RequestMethod.GET)
	public void form()
	{	
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView submit(MemberVo m)
	{
		
		ModelAndView mav = new ModelAndView("insertMemberOk");
		
		int re = dao.insert(m);
		String msg = "회원가입에 성공하였습니다.";
		if(re < 1)
		{
			msg = "회원가입에 실패하였습니다.";
		}
		
		mav.addObject("msg", msg);
		
		return mav;
	}
}









