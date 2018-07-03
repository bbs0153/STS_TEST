package com.bit.goodsJson;

import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

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
	public ModelAndView submit(GoodsVO g, HttpServletRequest request) {
		g.setFname("");
		ModelAndView mav = new ModelAndView("redirect:/start.do");
		String path = request.getRealPath("resources/upload");

		MultipartFile upload = g.getUploadFile();
		String fname = upload.getOriginalFilename();

		if (fname != null && !fname.equals("")) {
			try {
				g.setFname(fname);
				byte[] data = upload.getBytes();
				FileOutputStream fos = new FileOutputStream(path + "/" + fname);
				fos.write(data);
				fos.close();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}

		int re = dao.insert(g);

		String msg = "회원등록에 성공하였습니다.";
		if (re < 1) {
			msg = "회원등록에 실패하였습니다.";
		}

		request.getSession().setAttribute("msg", msg);

		return mav;

	}

}
