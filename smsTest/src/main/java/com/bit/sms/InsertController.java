package com.bit.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bit.dao.MemberDAO;
import com.bit.vo.MemberVO;

@Controller
@RequestMapping("/insertMember.do")
public class InsertController {
	@Autowired
	private MemberDAO dao;

	public void setDao(MemberDAO dao) {
		this.dao = dao;
	}

	@RequestMapping(method = RequestMethod.GET)
	public void form() {

	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView submit(MemberVO m) {
		int re = dao.insert(m);
		ModelAndView mav = new ModelAndView("login");
		
		String msg = "��� ����";
		
		if(re<0) {
			msg = "��� ����";
		}
		
		mav.addObject("msg",msg);
		
		return mav;
		
	}

}
