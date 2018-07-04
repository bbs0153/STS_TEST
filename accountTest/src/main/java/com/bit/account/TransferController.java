package com.bit.account;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bit.dao.AccountDAO;

@Controller
@RequestMapping("/transfer.do")
public class TransferController {

	@Autowired
	private AccountDAO dao;

	public void setDao(AccountDAO dao) {
		this.dao = dao;
	}

	@RequestMapping(method = RequestMethod.GET)
	public void form() {

	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView submit(String from, String to, int amount) {

		ModelAndView mav = new ModelAndView();

		Map map = new HashMap();
		map.put("from", from);
		map.put("to", to);
		map.put("amount", amount);

		int re = dao.transfer(map);
		String msg = "������ü�� �����Ͽ����ϴ�";
		if (re < 1) {
			msg = "������ü�� �����Ͽ����ϴ�";
		}

		mav.addObject("msg", msg);

		return mav;
	}

}
