package com.bit.filterTest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BitController {
	
	@RequestMapping("member/c.do")
	public void c() {
	}
	@RequestMapping("member/d.do")
	public void d() {
	}
	
	
	
	@RequestMapping("manager/e.do")
	public void e() {
	}
	@RequestMapping("manager/f.do")
	public void f() {
	}
	
	
	
	@RequestMapping("/a.do")
	public void a() {
		System.out.println("a.do ø‰√ªµ ");
	}
	@RequestMapping("/b.do")
	public void b() {
		System.out.println("b.do ø‰√ªµ ");
	}

}
