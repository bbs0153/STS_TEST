package com.bit.member;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bit.dao.MemberDAO;

@Controller
@RequestMapping("/login.do")
public class MemberLoginController {

	@Autowired
	private MemberDAO dao;

	public void setDao(MemberDAO dao) {
		this.dao = dao;
	}

	@RequestMapping(method = RequestMethod.GET)
	public void form() {

	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView submit(String id, String pwd, HttpSession session) {
		
		ModelAndView mav = new ModelAndView("login");
		Map map = new HashMap();
		map.put("id", id);
		map.put("pwd", pwd);
		
		boolean r = dao.isMember(map);
		
		if(r) {
			session.setAttribute("id", id);
			mav.setViewName("redirect:/listBoard.do");
		}
		
		return mav;
	}
}
