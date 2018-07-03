package com.bit.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bit.db.MemberManager;
import com.bit.vo.MemberVO;

@Repository
public class MemberDAO {

	public List<MemberVO> listAll() {
		return MemberManager.listAll();
	}

	public int insert(MemberVO m) {
		return MemberManager.insert(m);
	}

}
