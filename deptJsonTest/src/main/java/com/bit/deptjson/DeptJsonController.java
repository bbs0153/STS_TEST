package com.bit.deptjson;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit.dao.DeptJsonDAO;
import com.bit.vo.DeptJsonVO;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class DeptJsonController {

	@Autowired
	private DeptJsonDAO dao;

	public void setDao(DeptJsonDAO dao) {
		this.dao = dao;
	}

	@RequestMapping(value = "/listDept.do", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String listAll() {

		List<DeptJsonVO> list = dao.listAll();
		
		String str = "";
		ObjectMapper mapper = new ObjectMapper();
		try {
			str = mapper.writeValueAsString(list);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return str;

	}

}
