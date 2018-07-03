package com.bit.db;

import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bit.vo.MemberVO;

public class MemberManager {

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

	public static int insert(MemberVO m) {

		int re = -1;

		SqlSession session = factory.openSession(true);
		re = session.insert("member.insert", m);
		session.close();
		return re;
	}

	public static MemberVO login(String id, String pwd) {

		MemberVO m = null;

		Map map = new HashMap();
		map.put("id", id);
		map.put("pwd", pwd);
		
		SqlSession session = factory.openSession();
		
		m = session.selectOne("member.login", map);
		session.close();

		return m;
	}

}
