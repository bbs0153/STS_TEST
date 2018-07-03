package com.bit.goods;

import java.io.File;
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
public class UpdateController {
	@Autowired
	private GoodsDAO dao;

	public void setDao(GoodsDAO dao) {
		this.dao = dao;
	}

	@RequestMapping(value = "/updateGoods.do", method = RequestMethod.GET)
	public ModelAndView form(int no) {

		ModelAndView mav = new ModelAndView();
		mav.addObject("g", dao.getGoods(no));
		return mav;
	}

	@RequestMapping(value = "/updateGoods.do", method = RequestMethod.POST)
	public ModelAndView submit(GoodsVO g, HttpServletRequest request,HttpSession session ) {

		String path = request.getRealPath("resources/upload");
		String oldFname = g.getFname();
		System.out.println(path);
		MultipartFile multi = g.getMultipartFile();

		try {
			if (multi.getBytes().length != 0) {

				String fname = multi.getOriginalFilename();
				if (!oldFname.equals(fname) && oldFname != null && !oldFname.equals("")) {
					File file = new File(path + "/" + oldFname);
					file.delete();
				}

				byte data[] = multi.getBytes();
				g.setFname(fname);

				FileOutputStream fos = new FileOutputStream(path + "/" + fname);
				fos.write(data);
				fos.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		int re = dao.update(g);

		ModelAndView mav = new ModelAndView("redirect:/listGoods.do");

		if (re < 1) {
			session.setAttribute("msg", "상품수정 실패");
			//mav.addObject("msg", "수정 실패");
			//mav.setViewName("error");
		}else {
			session.setAttribute("msg", "상품수정 성공");
			//mav.addObject("msg","수정 성공");
		}
			

		return mav;
	}
}
