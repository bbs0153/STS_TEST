package com.bit.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bit.db.DeptJsonManager;
import com.bit.vo.DeptJsonVO;

@Repository
public class DeptJsonDAO {

	public List<DeptJsonVO> listAll() {
		return DeptJsonManager.listAll();
	}

}
