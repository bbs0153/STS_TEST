package com.bit.mongoTestSTS;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;

@Controller
public class DBController {
	
	@RequestMapping(value="/listMongoMember.do", produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String listMember() {

		ArrayList<DBObject> list = new ArrayList<DBObject>();
		String str = "";
		
		try {
			
			Mongo mongo = new Mongo();
			DB db = mongo.getDB("bit");
			DBCollection col = db.getCollection("member");
			DBCursor cursor = col.find();

			while (cursor.hasNext()) {

				list.add(cursor.next());
			}

			ObjectMapper mapper = new ObjectMapper();
			
			str = mapper.writeValueAsString(list);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		return str;
	}
	
		

	@RequestMapping("listDataBase.do")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();

		try {

			Mongo mongo = new Mongo();
			List<String> list = mongo.getDatabaseNames();
			mav.addObject("list", list);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return mav;
	}

}
