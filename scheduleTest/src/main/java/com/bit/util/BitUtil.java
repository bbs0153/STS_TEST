package com.bit.util;

import org.springframework.scheduling.annotation.Scheduled;

public class BitUtil {
	
	@Scheduled(cron="0 30 12 * * ?")
	//@Scheduled(fixedRate=10000)
	public void pro() {
		System.out.println("æ»≥Á«œººø‰");
	}
}
