package com.bit.db;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bit.vo.BoardVO;
import com.bit.vo.MemberVO;

public class BoardManager {

	private static SqlSessionFactory factory;

	static {

		try {

			Reader reader = Resources.getResourceAsReader("com/bit/db/mybatisConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}

	public static List<BoardVO> listAll(Map map) {

		List<BoardVO> list = null;

		SqlSession session = factory.openSession();
		list = session.selectList("board.selectAll",map);
		session.close();
		return list;

	}

	public static int insert(BoardVO b, HttpServletRequest request) {

		int re = -1;

		SqlSession session = factory.openSession(true);
		b.setIp(request.getRemoteAddr());

		int pno = b.getNo();

		int no = nextNo();
		b.setNo(no);

		int b_ref = no;
		int b_step = 0;
		int b_level = 0;

		if (pno != 0) {

			BoardVO p = getBoard(pno);
			b_ref = p.getB_ref();
			b_level = p.getB_level();
			b_step = p.getB_step();

			Map map = new HashMap();
			map.put("b_ref", b_ref);
			map.put("b_step", b_step);

			updateStep(map);

			b_level++;
			b_step++;
		}

		b.setB_ref(b_ref);
		b.setB_level(b_level);
		b.setB_step(b_step);

		re = session.insert("board.insert", b);
		session.close();
		return re;
	}

	private static int updateStep(Map map) {
		// TODO Auto-generated method stub
		int re = -1;
		SqlSession session = factory.openSession(true);
		session.update("board.updateStep", map);
		session.close();
		return re;
	}

	public static BoardVO getBoard(int no) {

		BoardVO b = null;
		Map map = new HashMap();
		map.put("no", no);
		SqlSession session = factory.openSession();
		b = session.selectOne("board.getBoard", map);
		return b;

	}

	public static int update(BoardVO b) {

		b.setFsize(0);
		int re = -1;
		SqlSession session = factory.openSession(true);
		re = session.update("board.update", b);
		return re;

	}

	public static int delete(int no) {

		int re = -1;
		Map map = new HashMap();
		map.put("no", no);
		SqlSession session = factory.openSession(true);
		re = session.delete("board.delete", map);
		return re;

	}

	public static int nextNo() {
		int no = 0;
		SqlSession session = factory.openSession();
		no = session.selectOne("board.nextNo");
		session.close();
		return no;
	}

	public static int updateHit(int no) {
		int re = 0;
		Map map = new HashMap();
		SqlSession session = factory.openSession(true);
		map.put("no", no);
		re = session.update("board.updateHit", map);
		session.close();
		return re;
	}
	
	public static List<BoardVO> myList(String id){
		
		List<BoardVO> list = null;
		
		Map map = new HashMap();
		SqlSession session = factory.openSession();
		map.put("id", id);
		list = session.selectList("board.myList",map);
		session.close();
		return list;
		
	}
}
