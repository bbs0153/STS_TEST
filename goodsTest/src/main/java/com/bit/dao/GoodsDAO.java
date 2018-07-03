package com.bit.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bit.db.GoodsManager;
import com.bit.vo.GoodsVO;

@Repository
public class GoodsDAO {

	public List<GoodsVO> listAll(Map map) {
		return GoodsManager.listAll(map);
	}

	public GoodsVO getGoods(int no) {
		return GoodsManager.getGoods(no);
	}

	public int insert(GoodsVO g) {
		return GoodsManager.insert(g);
	}

	public int update(GoodsVO g) {
		return GoodsManager.update(g);
	}

	public int delete(int no) {
		return GoodsManager.delete(no);
	}

}
