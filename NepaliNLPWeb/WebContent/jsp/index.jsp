<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="com.icodejava.research.nlp.database.WordsUnreferencedDB"%>
<%@ page import="com.icodejava.research.nlp.domain.Word"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Select Root Words</h1>

<form action="/NepaliNLPWeb/RandomWordsServlet" method="post">

  <input type="submit" value="Submit">


<%
List<Word> words = WordsUnreferencedDB.selectRandomRecords(100);
for(Word word: words) {
%>
<br><%=word.getWord()%> <input type="checkbox" name="WORD_<%=word.getId()%>"> 
<%	
}
%>
</form>

</body>
</html>