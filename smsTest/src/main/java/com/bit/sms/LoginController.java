package com.bit.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bit.dao.MemberDAO;
import com.bit.vo.MemberVO;

@Controller
public class LoginController {

	@Autowired
	private MemberDAO dao;

	public void setDao(MemberDAO dao) {
		this.dao = dao;
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public void form() {
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public ModelAndView login(String id, String pwd) {
		MemberVO m = dao.login(id, pwd);

		ModelAndView mav = new ModelAndView();
		if (m != null) {

			mav.addObject("m", m);
			mav.setViewName("loginOk");

		} else {
			mav.setViewName("login");
		}
		return mav;
	}

}
