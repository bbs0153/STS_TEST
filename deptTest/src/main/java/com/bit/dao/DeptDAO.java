package com.bit.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bit.db.DeptManager;
import com.bit.vo.DeptVO;

@Repository
public class DeptDAO {

	public List<DeptVO> listAll() {
		return DeptManager.listAll();
	}
	
	public int insert(DeptVO d) {
		return DeptManager.insert(d);
	}
	
	public DeptVO getDept(int dno) {
		return DeptManager.getDept(dno);
	}
	
	public int update(DeptVO d) {
		return DeptManager.update(d);
	}
	
	public int delete(int dno) {
		return DeptManager.delete(dno);
	}
}
