package com.bit.dao;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Repository;

import com.bit.db.BoardManager;
import com.bit.vo.BoardVO;

@Repository
public class BoardDAO {

	public List<BoardVO> listAll() {
		return BoardManager.listAll();
	}

	public int insert(BoardVO b, HttpServletRequest request) {
		return BoardManager.insert(b,request);
	}

	public BoardVO getBoard(int no) {
		return BoardManager.getBoard(no);
	}

	public int update(BoardVO b) {
		return BoardManager.update(b);
	}

	public int delete(int no) {
		return BoardManager.delete(no);
	}
	
	public int updateHit(int no) {
		return BoardManager.updateHit(no);
	}
}
