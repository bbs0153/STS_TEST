package com.bit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bit.dao.MemberDAO;
import com.bit.vo.MemberVO;

@Controller
public class InsertController {

	@Autowired
	private MemberDAO dao;

	public void setDao(MemberDAO dao) {
		this.dao = dao;
	}

	@RequestMapping(value = "/insertMember.do", method = RequestMethod.GET)
	public void insertForm() {

	}

	@RequestMapping(value = "/insertMember.do", method = RequestMethod.POST)
	public ModelAndView insertSubmit(MemberVO m) {

		int re = dao.insert(m);
		ModelAndView mav = new ModelAndView("redirect:/listMember.do");
		if (re < 1) {
			mav.addObject("msg", "등록에 실패 하였습니다");
			mav.setViewName("error");
		}

		return mav;
	}

}
