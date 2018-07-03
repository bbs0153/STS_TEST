package com.bit.json;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit.vo.DeptVO;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class DeptController {

	@RequestMapping(value="/test.do", produces="text/plain;charset=utf-8")
	@ResponseBody
	public String test() {

		DeptVO d = new DeptVO(100, "영업부", "신수동");
		String str = "";

		ObjectMapper mapper = new ObjectMapper();
		try {
			str = mapper.writeValueAsString(d);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		return str;

	}

}
