package com.bit.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bit.dao.BoardDAO;
import com.bit.vo.BoardVO;

@Controller
public class UpdateController {

	@Autowired
	private BoardDAO dao;

	public void setDao(BoardDAO dao) {
		this.dao = dao;
	}

	@RequestMapping(value = "/updateBoard.do", method = RequestMethod.GET)
	public ModelAndView from(int no) {

		ModelAndView mav = new ModelAndView();
		mav.addObject("b", dao.getBoard(no));
		return mav;

	}

	@RequestMapping(value = "/updateBoard.do", method = RequestMethod.POST)
	public ModelAndView submit(BoardVO b, HttpServletRequest request) {

		int re = dao.update(b);
		ModelAndView mav = new ModelAndView("redirect:/listBoard.do");
		b.setIp(request.getRemoteAddr());

		if (re < 1) {
			mav.addObject("msg", "등록실패");
			mav.setViewName("error");
		}

		return mav;
	}

}
