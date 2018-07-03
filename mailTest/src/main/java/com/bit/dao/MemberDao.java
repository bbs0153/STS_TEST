package com.bit.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bit.db.MemberManager;
import com.bit.vo.MemberVo;


@Repository
public class MemberDao {
	
	public int insert(MemberVo m)
	{
		return MemberManager.insert(m);				
	}
	
}













