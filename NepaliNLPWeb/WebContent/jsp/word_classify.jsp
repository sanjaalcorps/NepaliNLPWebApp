<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.icodejava.research.nlp.database.WordsUnreferencedDB"%>
<%@ page import="com.icodejava.research.nlp.services.WordsUnreferencedService"%>
<%@ page import="com.icodejava.research.nlp.domain.Word"%>

<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge"> -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>NLP - Word Classify</title>
<link href="../css/jquery-ui.css" rel="stylesheet">
<link href="../css/bootstrap.css" rel="stylesheet">
<style>
body {
	width:350px;
	font-family: "Trebuchet MS", sans-serif;
	margin: 50px;
}
div.class1 {
    width:300px;
    margin: 10px;
    border: 3px solid #73AD21;
}
div.right {
	width:350x;
	align:right;
}

</style>
</head>
<body>


<%
if("successful".equalsIgnoreCase(request.getParameter("result"))) {
%>
	<div class="ui-widget">
		<div class="ui-state-highlight ui-corner-all" style="margin-top: 20px; padding: 0 .7em;">
			<p><span class="ui-icon ui-icon-info" style="float: left; margin-right: .3em;"></span>
			Previous words have been updated. Submit more below.</p>
		</div>
	</div>
	<br>
<%}%>

	<form action="/NepaliNLPWeb/WordsClassificationServlet" method="post">


		<%
			List<Word> words = new ArrayList<Word>();
			if(request.getSession().getAttribute("wordSearchResult") != null) {
				System.out.println("Found Search Results");
				words = (List<Word>) request.getSession().getAttribute("wordSearchResult");
			} else {
				words = WordsUnreferencedDB.selectRecordsNotMarkedAsCompoundRandom(100);
			}
			int count = 0;
			for (Word word : words) {
		%>
		
		<fieldset>
			<legend><%= count++ + " - " + word.getWord()%></legend>
			<div id="controlgroup_<%=word.getId()%>" class="class1">
			
				<label for="word_root_<%=word.getId()%>">Root</label>
				<input type="checkbox" name="word_root_<%=word.getId()%>" id="word_root_<%=word.getId()%>">
				<label for="word_derived_<%=word.getId()%>">Derived</label> 
				<input type="checkbox" name="word_derived_<%=word.getId()%>" id="word_derived_<%=word.getId()%>">
				<label for="word_person_<%=word.getId()%>">Person</label> 
				<input type="checkbox" name="word_person_<%=word.getId()%>" id="word_person_<%=word.getId()%>">
				<label for="word_firstname_<%=word.getId()%>">Firstname</label> 
				<input type="checkbox" name="word_firstName_<%=word.getId()%>" id="word_firstname_<%=word.getId()%>">
				<label for="word_surname_<%=word.getId()%>">Surname</label> 
				<input type="checkbox" name="word_surname_<%=word.getId()%>" id="word_surname_<%=word.getId()%>">
				<label for="word_location_<%=word.getId()%>">Location</label> 
				<input type="checkbox" name="word_location_<%=word.getId()%>" id="word_location_<%=word.getId()%>">
				<label for="word_english_<%=word.getId()%>">English</label> 
				<input type="checkbox" name="word_english_<%=word.getId()%>" id="word_english_<%=word.getId()%>">
				<label for="word_sports_<%=word.getId()%>">Sports</label> 
				<input type="checkbox" name="word_sports_<%=word.getId()%>" id="word_sports_<%=word.getId()%>">
				<label for="word_politics_<%=word.getId()%>">Politics</label> 
				<input type="checkbox" name="word_politics_<%=word.getId()%>" id="word_politics_<%=word.getId()%>">
				<label for="word_dirty_<%=word.getId()%>">Dirty</label> 
				<input type="checkbox" name="word_dirty_<%=word.getId()%>" id="word_dirty_<%=word.getId()%>">
			</div>
	
		</fieldset>


		<%
			}
		%>
		<br/>
		<input type="submit" value="Submit">
	</form>
	
	Go to <a href = "jsp/word_search.jsp">Word Search</a>

	<script src="../js/jquery.js"></script>
	<script src="../js/jquery-ui.js"></script>
	<script src="../js/bootstrap.js"></script>
	<script>
		$("[id*=controlgroup]").controlgroup();
	</script>
</body>
</html>