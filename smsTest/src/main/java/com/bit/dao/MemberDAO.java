package com.bit.dao;

import org.springframework.stereotype.Repository;

import com.bit.db.MemberManager;
import com.bit.vo.MemberVO;

@Repository
public class MemberDAO {

	public int insert(MemberVO m) {
		return MemberManager.insert(m);
	}
	
	public MemberVO login(String id, String pwd) {
		return MemberManager.login(id, pwd);
	}

}
