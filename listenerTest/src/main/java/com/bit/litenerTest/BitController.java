package com.bit.litenerTest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BitController {
	
	@RequestMapping("/a.do")
	public void a() {
		System.out.println("a �Դϴ�.");
	}
	@RequestMapping("/b.do")
	public void b() {
		System.out.println("b �Դϴ�.");
	}
	@RequestMapping("/c.do")
	public void c() {
		System.out.println("c �Դϴ�.");
	}

}
