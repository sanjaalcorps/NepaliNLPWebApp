<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.icodejava.research.nlp.database.WordsUnreferencedDB"%>
<%@ page import="com.icodejava.research.nlp.domain.Word"%>
<%@ page import="com.icodejava.research.nlp.utils.DevanagariUnicodeToRomanEnglish"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Word Romanization - Nepali NLP</title>
<link href="../css/jquery-ui.css" rel="stylesheet">
<link href="../css/bootstrap.css" rel="stylesheet">
<link href="../css/nlpweb.css" rel="stylesheet">
<style>
body {
	width:450px;
	font-family: "Trebuchet MS", sans-serif;
	margin: 50px;
}

</style>
</head>
<body>

<div class="parent_400">
<%
if("successful".equalsIgnoreCase(request.getParameter("result"))) {
%>
	<div class="ui-widget">
		<div class="ui-state-highlight ui-corner-all" style="margin-top: 20px; padding: 0 .7em;">
			<p><span class="ui-icon ui-icon-info" style="float: left; margin-right: .3em;"></span>
			Previous words have been updated. Total Count: <%=request.getParameter("count")%> Submit more below.</p>
		</div>
	</div>
	<br>
<%}%>

<form action="/NepaliNLPWeb/ValidateRomanizationServlet" method="post">

	<input type="submit" value="Submit">
		<%
			List<Word> words = WordsUnreferencedDB.selectRecordsNotMarkedAsCompoundRandom(150);
			for (Word word : words) {
		%>
		
		<fieldset>
			<legend><%=word.getWord()%> - Romanized: + <%=DevanagariUnicodeToRomanEnglish.convertWord(word.getWord())%> </legend>
			<div id="controlgroup_<%=word.getId()%>" class="class1">
			
				<label for="word_romanized_<%=word.getId()%>">Correct</label>
				<input type="checkbox" name="word_romanized_<%=word.getId()%>" id="word_romanized_<%=word.getId()%>">
				
				<select name="word_classification_<%=word.getId()%>">
					<option value=""></option>
				    <option value="location">Location</option>
				    <option value="Person">Person</option>
				    <option value="Fistname">Firstname</option>
				    <option value="Surname">Surname</option>
				    <option value="English">English</option>
				    <option value="Politics">Politics</option>
				    <option value="Sports">Sports</option>
				    <option value="Root">Root</option>
				    <option value="Derived">Derived</option>
				    <option value="Dirty">Dirty</option>
				    <option value="Delete">Delete</option>
				</select>
				
			</div>
		</fieldset>
		<%
			}
		%>
		<br/>
		<input type="submit" value="Submit">
		
	</form>
	</div>
	<script src="../js/jquery.js"></script>
	<script src="../js/jquery-ui.js"></script>
	<script src="../js/bootstrap.js"></script>
		<script>
		$("[id*=controlgroup]").controlgroup();
	</script>
</body>
</html>