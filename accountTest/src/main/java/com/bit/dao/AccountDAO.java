package com.bit.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bit.db.AccountManager;

@Repository
public class AccountDAO {
	
	public int transfer(Map map) {
		return AccountManager.tansfer(map);
	}

}
