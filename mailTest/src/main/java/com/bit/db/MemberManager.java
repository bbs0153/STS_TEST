package com.bit.db;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bit.vo.MemberVo;

public class MemberManager {
	private static SqlSessionFactory factory;
	static
	{
		try {
			Reader reader = 
					Resources.getResourceAsReader("com/bit/db/mybatisConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	
	public static int insert(MemberVo m)
	{
		int re = -1;
		SqlSession session= factory.openSession();
		re = session.insert("member.insert", m);
		session.commit();
		session.close();
		return re;
	}
	
	public static List<MemberVo> listAll()
	{
		SqlSession session = factory.openSession();
		List<MemberVo> list =session.selectList("member.selectAll");
		session.close();
		return list;
	}
	
}

















