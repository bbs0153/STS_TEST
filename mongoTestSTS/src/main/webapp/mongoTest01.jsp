<%@page import="com.mongodb.DBCursor"%>
<%@page import="com.mongodb.DBCollection"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="com.mongodb.DB"%>
<%@page import="java.util.List"%>
<%@page import="com.mongodb.Mongo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
try {
	
	Mongo mong = new Mongo();
	List<String> list = mong.getDatabaseNames();
	
	for(String dbname : list) {
		
		out.println(dbname + "<br>");
		DB db = mong.getDB(dbname);
		Set<String> set = db.getCollectionNames();
		
		Iterator iter = set.iterator();
		
		while(iter.hasNext()) {
			
			String cname = (String)iter.next();
			out.println(cname+"<br>");
			DBCollection collection = db.getCollection(cname);
			DBCursor cursor = collection.find();
			
			while(cursor.hasNext()) {
				out.println(cursor.next());
			}
			
			cursor.close();
			out.println("<br>");
			
		}
		
		out.println("<hr>");
		
	}
	mong.close();
	
} catch (Exception e) {
	// TODO: handle exception
	System.out.println(e.getMessage());
}

%>

</body>
</html>