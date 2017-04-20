<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.icodejava.research.nlp.database.SentencesUnreferencedDB"%>
<%@ page import="com.icodejava.research.nlp.domain.Sentence"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Sentence Validity Checker - Nepali NLP</title>
<link href="../css/jquery-ui.css" rel="stylesheet">
<link href="../css/bootstrap.css" rel="stylesheet">
<style>
body {
	width:400px;
	font-family: "Trebuchet MS", sans-serif;
	margin: 50px;
}
div.class1 {
    width:350px;
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
			Previous Sentences have been updated. Total Count: <%=request.getParameter("count")%> Submit more below.</p>
		</div>
	</div>
	<br>
<%}%>

<form action="/NepaliNLPWeb/SentencesServlet" method="post">

	<input type="submit" value="Submit">
		<%
		    int count = 50;
			int minWords = 5;
			int maxWords = 20;
			List<Sentence> sentences = SentencesUnreferencedDB.selectUnverifiedSentencesRandom(count, minWords, maxWords);
			for (Sentence sentence : sentences) {
		%>
				<fieldset>
					<legend><%=sentence.getValue()%></legend>
					<div id="controlgroup_<%=sentence.getId()%>" class="class1">
					
						<label for="sentence_valid_<%=sentence.getId()%>">Valid</label>
						<input type="checkbox" name="sentence_valid_<%=sentence.getId()%>" id="sentence_valid_<%=sentence.getId()%>">
						
						<label for="sentence_invalid_<%=sentence.getId()%>">Invalid</label>
						<input type="checkbox" name="sentence_invalid_<%=sentence.getId()%>" id="sentence_invalid_<%=sentence.getId()%>">
						
						<label for="sentence_delete_<%=sentence.getId()%>">Delete</label>
						<input type="checkbox" name="sentence_delete_<%=sentence.getId()%>" id="sentence_delete_<%=sentence.getId()%>">
						
					</div>
			
				</fieldset>
		<%
			}
		%>
		<br/>
		<input type="submit" value="Submit">
		
	</form>
	<script src="../js/jquery.js"></script>
	<script src="../js/jquery-ui.js"></script>
	<script src="../js/bootstrap.js"></script>
		<script>
		$("[id*=controlgroup]").controlgroup();
	</script>
</body>
</html>