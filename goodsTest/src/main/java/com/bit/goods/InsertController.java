package com.bit.goods;

import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bit.dao.GoodsDAO;
import com.bit.vo.GoodsVO;

@Controller
public class InsertController {
	@Autowired
	private GoodsDAO dao;

	public void setDao(GoodsDAO dao) {
		this.dao = dao;
	}

	@RequestMapping(value = "/insertGoods.do", method = RequestMethod.GET)
	public void form() {

	}

	@RequestMapping(value = "/insertGoods.do", method = RequestMethod.POST)
	public ModelAndView submit(GoodsVO g, HttpServletRequest request, HttpSession session) {

		String path = request.getRealPath("resources/upload");
		System.out.println(path);
		MultipartFile multi = g.getMultipartFile();
		if (multi != null) {
			try {

				String fname = multi.getOriginalFilename();
				byte data[] = multi.getBytes();
				g.setFname(fname);

				FileOutputStream fos = new FileOutputStream(path + "/" + fname);
				fos.write(data);
				fos.close();

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}

		}
		int re = dao.insert(g);
		ModelAndView mav = new ModelAndView("redirect:/listGoods.do");
		if (re < 1) {
			session.setAttribute("msg", "상품등록 실패");
			//mav.addObject("msg", "등록실패");
		}else {
			session.setAttribute("msg", "상품등록 성공");
			//mav.addObject("msg", "등록성공");
		}
		return mav;
	}

}
