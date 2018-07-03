package com.bit.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bit.dao.BoardDAO;

@Controller
public class BoardController {
	@Autowired
	private BoardDAO dao;

	public void setDao(BoardDAO dao) {
		this.dao = dao;
	}

	@RequestMapping("/listBoard.do")
	public ModelAndView listAll() {

		ModelAndView mav = new ModelAndView("listBoard");
		mav.addObject("list", dao.listAll());
		return mav;
	}

	@RequestMapping("/detailBoard.do")
	public ModelAndView getBoard(int no) {

		ModelAndView mav = new ModelAndView();
		dao.updateHit(no);
		mav.addObject("b", dao.getBoard(no));
		return mav;
	}

	@RequestMapping("/deleteBoard.do")
	public ModelAndView delete(int no) {

		int re = dao.delete(no);
		ModelAndView mav = new ModelAndView("redirect:/listBoard.do");

		if (re < 1) {
			mav.addObject("msg", "삭제 실패");
			mav.setViewName("error");
		}
		return mav;
	}

	@RequestMapping("/down.do")
	public ModelAndView dow(String fname, HttpServletRequest request) {

		String path = request.getRealPath("resources/upload");
		File file = new File(path + "/" + fname);
		ModelAndView mav = new ModelAndView("down", "df", file);
		return mav;

	}

}
