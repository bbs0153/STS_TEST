package com.bit.controller;

import java.io.FileOutputStream;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bit.dao.BoardDAO;
import com.bit.vo.BoardVO;

@Controller
public class InsertController {

	@Autowired
	private BoardDAO dao;

	public void setDao(BoardDAO dao) {
		this.dao = dao;
	}

	@RequestMapping(value = "/insertBoard.do", method = RequestMethod.GET)
	public ModelAndView form(@RequestParam(value = "no", defaultValue = "0") int no) {

		ModelAndView mav = new ModelAndView();
		String title = "새글작성";
		if (no != 0) {
			title = "답글작성";
			mav.addObject("ptitle", "답글)" + dao.getBoard(no).getTitle());
		}
		mav.addObject("no", no);
		mav.addObject("title", title);
		return mav;

	}

	@RequestMapping(value = "/insertBoard.do", method = RequestMethod.POST)
	public ModelAndView submit(BoardVO b, HttpServletRequest request) {

		// 파일 업로드의 처리
		String path = request.getRealPath("resources/upload");
		System.out.println("path:"+path);
		MultipartFile uploadFile = b.getUploadFile();
		if (uploadFile != null) {
			try {

				String fname = uploadFile.getOriginalFilename();
				byte data[] = uploadFile.getBytes();
				b.setFname(fname);
				b.setFsize(data.length);
				
				FileOutputStream fos = new FileOutputStream(path + "/" + fname);
				fos.write(data);
				fos.close();
			
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}

		int re = dao.insert(b, request);
		ModelAndView mav = new ModelAndView("redirect:/listBoard.do");
		if (re < 1) {
			mav.addObject("msg", "등록실패");
			mav.setViewName("error");
		}

		return mav;
	}

}
