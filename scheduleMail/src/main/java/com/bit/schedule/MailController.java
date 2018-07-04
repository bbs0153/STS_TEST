package com.bit.schedule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit.dao.MemberDao;
import com.bit.vo.MemberVo;

@Controller
public class MailController {

	private MailSender mailSender;

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	@Autowired
	private MemberDao dao;

	public void setDao(MemberDao dao) {
		this.dao = dao;
	}

	@Scheduled(cron = "0 57 12 * * ?")
	public void mail() {

		List<MemberVo> send = dao.listAll();

		SimpleMailMessage mailMessage = new SimpleMailMessage();

		for (int i = 0; i <= send.size(); i++) {
			mailMessage.setSubject("¾È³çÇÏ½Ê´Ï±î?");
			mailMessage.setFrom("email");
			mailMessage.setText(send.get(i).getName()+"°í°´´Ô »ç¶ûÇÕ´Ï´Ù");
			mailMessage.setTo(send.get(i).getEmail());
			System.out.println(send.get(i).getEmail());

			try {
				mailSender.send(mailMessage);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
	}
	
	
}
