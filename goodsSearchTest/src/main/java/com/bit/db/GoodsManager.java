package com.bit.db;

import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bit.vo.GoodsVO;

public class GoodsManager {

	public static SqlSessionFactory factory;

	static {

		try {
			Reader reader = Resources.getResourceAsReader("com/bit/db/mybatisConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}

	public static List<GoodsVO> listAll(Map map) {
		List<GoodsVO> list = null;

		SqlSession session = factory.openSession();
		list = session.selectList("goods.selectAll",map);
		session.close();
		return list;
	}

}
