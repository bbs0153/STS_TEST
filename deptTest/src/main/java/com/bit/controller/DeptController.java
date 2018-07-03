package com.bit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bit.dao.DeptDAO;
import com.bit.vo.DeptVO;

@Controller
public class DeptController {

	@Autowired
	private DeptDAO dao;

	public void setDao(DeptDAO dao) {
		this.dao = dao;
	}

	@RequestMapping("/listDept.do")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView("listDept");
		mav.addObject("list", dao.listAll());
		return mav;
	}

	@RequestMapping("/detailDept.do")
	public ModelAndView detail(int dno) {
		ModelAndView mav = new ModelAndView("detailDept");
		mav.addObject("d",dao.getDept(dno));
		return mav;
	}

	@RequestMapping("/deleteDept.do")
	public ModelAndView delete(int dno) {
		ModelAndView mav = new ModelAndView("redirect:/listDept.do");

		int re = dao.delete(dno);
		if (re < 1) {
			mav.addObject("msg", "삭제에 실패했습니다.");
			mav.setViewName("error");
		}
		return mav;

	}

}
