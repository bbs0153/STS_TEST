package com.bit.db;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bit.vo.DeptJsonVO;

public class DeptJsonManager {

	public static SqlSessionFactory factory;

	static {

		try {
			Reader reader = Resources.getResourceAsReader("com/bit/db/mybatisConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

	public static List<DeptJsonVO> listAll() {

		List<DeptJsonVO> list = null;
		SqlSession session = factory.openSession();
		list = session.selectList("deptJson.selectAll");
		session.close();
		return list;

	}

}
