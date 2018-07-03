package com.bit.mailtest;

import java.util.Random;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MailController {
	
	private MailSender mailSender;
	
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	@RequestMapping("/mail.do")
	@ResponseBody
	public String mail(String emailAuth)
	{
		String sendNumber = "";
		Random r = new Random();
		int n = 0;
		
		while(n<1000)
		{
			n = r.nextInt(10000);
		}
		
		sendNumber = n + "";
		
		SimpleMailMessage mailMessage = new SimpleMailMessage();		
		mailMessage.setSubject("[회원가입안내]");
		mailMessage.setFrom("*******");
		mailMessage.setText(sendNumber);	
		mailMessage.setTo(emailAuth);
		System.out.println("email:"+emailAuth);
		try{
			mailSender.send(mailMessage);
		}catch(Exception e)
		{
			System.out.println(e);
		}
		System.out.println(sendNumber);
		return sendNumber;
	}
}
