package com.bit.gss;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bit.dao.GoodsDAO;
import com.bit.vo.GoodsVO;

@Controller
public class GoodsController {

	@Autowired
	private GoodsDAO dao;

	public void setDao(GoodsDAO dao) {
		this.dao = dao;
	}
	
	@RequestMapping("/listGoods.do")
	public ModelAndView list(String searchField,String keyword,String sortField,HttpSession session)
	{	
		
		System.out.println("searchField:"+searchField);

		
		if( keyword == null   &&  session.getAttribute("keyword")!=null)
		{
			keyword = (String)session.getAttribute("keyword");
		}
		
		if( searchField == null   &&  session.getAttribute("searchField")!=null)
		{
			searchField = (String)session.getAttribute("searchField");
		}
				
		Map map = new HashMap();
		map.put("keyword", keyword);
		map.put("searchField", searchField);
		map.put("sortField", sortField);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", dao.listAll(map));
		
		session.setAttribute("keyword", keyword);
		session.setAttribute("searchField", searchField);
		return mav;
	}
}
