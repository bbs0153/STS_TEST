package com.bit.goods;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bit.dao.GoodsDAO;

@Controller
public class GoodsController {
	@Autowired
	private GoodsDAO dao;

	public void setDao(GoodsDAO dao) {
		this.dao = dao;
	}

	@RequestMapping("/listGoods.do")
	public ModelAndView listAll(String keyword,String keyField) {
		Map map = new HashMap();
		map.put("keyword", keyword);
		map.put("keyField", keyField);
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", dao.listAll(map));
		return mav;
	}

	@RequestMapping("/detailGoods.do")
	public ModelAndView getGoods(int no) {

		ModelAndView mav = new ModelAndView();
		mav.addObject("g", dao.getGoods(no));
		return mav;
	}

	@RequestMapping("/deleteGoods.do")
	public ModelAndView delete(int no, HttpServletRequest request, HttpSession session) {

		String path = request.getRealPath("resources/upload");
		String fname = dao.getGoods(no).getFname();

		int re = dao.delete(no);

		ModelAndView mav = new ModelAndView("redirect:/listGoods.do");

		if (re < 1) {
			session.setAttribute("msg", "상품삭제 실패");
			//mav.addObject("msg", "삭제 실패");
			//mav.setViewName("error");
		} else {
			session.setAttribute("msg", "상품삭제 성공");
			File file = new File(path + "/" + fname);
			file.delete();
			mav.setViewName("redirect:/listGoods.do");
		}
		return mav;
	}

}
