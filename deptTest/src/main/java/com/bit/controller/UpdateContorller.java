package com.bit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bit.dao.DeptDAO;
import com.bit.vo.DeptVO;

@Controller
public class UpdateContorller {

	@Autowired
	private DeptDAO dao;

	public void setDao(DeptDAO dao) {
		this.dao = dao;
	}

	@RequestMapping(value = "/updateDept.do", method = RequestMethod.GET)
	public ModelAndView updateForm(int dno) {

		ModelAndView mav = new ModelAndView();
		mav.addObject("d", dao.getDept(dno));
		return mav;

	}
	@RequestMapping(value = "/updateDept.do", method = RequestMethod.POST)
	public ModelAndView updateSubmit(DeptVO d) {

		int re = dao.update(d);
		ModelAndView mav = new ModelAndView("redirect:/listDept.do");

		if (re < 1) {
			mav.addObject("msg", "수정에 실패했습니다");
			mav.setViewName("error");
		}
		return mav;
	}
}
