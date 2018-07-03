package com.bit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bit.dao.DeptDAO;
import com.bit.vo.DeptVO;

@Controller
public class InsertController {

	@Autowired
	private DeptDAO dao;

	public void setDao(DeptDAO dao) {
		this.dao = dao;
	}

	@RequestMapping(value = "/insertDept.do", method = RequestMethod.GET)
	public void insertForm() {

	}

	@RequestMapping(value = "/insertDept.do", method = RequestMethod.POST)
	public ModelAndView insertSubmit(DeptVO d) {

		int re = dao.insert(d);
		ModelAndView mav = new ModelAndView("redirect:/listDept.do");

		if (re < 1) {
			mav.addObject("msg", "등록에 실패 하였습니다");
			mav.setViewName("error");
		}
		return mav;
	}
}
