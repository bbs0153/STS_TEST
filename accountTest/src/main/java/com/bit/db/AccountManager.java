package com.bit.db;

import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class AccountManager {

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

	public static int tansfer(Map map) {

		int re = -1;

		SqlSession session = factory.openSession();

		int withdraw = session.update("account.withdraw", map);
		int deposit = session.update("account.deposit", map);
		int balance = session.selectOne("account.balance",map.get("from"));
		
		
		
	if(balance >= 0)	{
		
		if (withdraw == 1 && deposit == 1) {
			session.commit();
			re = 1;
		}else {
			session.rollback();
		}
	}
		session.close();
	
		return re;
	}

}
