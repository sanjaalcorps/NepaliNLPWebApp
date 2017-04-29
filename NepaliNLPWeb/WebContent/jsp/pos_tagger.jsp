<%@page import="com.icodejava.research.nlp.domain.NepaliPartsOfSpeech"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.icodejava.research.nlp.services.WordsUnreferencedService"%>
<%@ page import="com.icodejava.research.nlp.domain.Word"%>
<%@ page import="com.icodejava.research.nlp.database.WordsUnreferencedDB"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Parts of Speech Tagger</title>
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
    background: #add8e6 
}
div.right {
	width:350x;
	align:right;
}
</style>
</head>
<body>
Parts of Speech Tagger <br/>
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


	<fieldset>
		<legend>Tagging Guide</legend>
		<div class="ui-state-highlight ui-corner-all" style="margin-top: 20px; padding: 0 .7em;font-size:0.6em;">

			<%
				for (NepaliPartsOfSpeech npos : NepaliPartsOfSpeech.values()) {
			%>
			<label><%=npos.getTag()%>=<%=npos.name()%> </label>
			<%
				}
			%>
		</div>
	</fieldset>


	<form action="/NepaliNLPWeb/POSTaggerServlet" method="post">
		<%
			List<Word> words = new ArrayList<Word>();
			words = WordsUnreferencedService.selectRootWordPOSNotExtracted(25);
			for (Word word : words) {
		%>
		
			<fieldset>
				<legend><%=word.getWord()%></legend>
				<div id="controlgroup_pos%>" class="class1">
		
		<%
				for (NepaliPartsOfSpeech npos : NepaliPartsOfSpeech.values()) {
		%>
					<label for="word_pos_<%=npos.getTag()%>"><%=npos.getTag()%></label> 
					<input type="radio" name="word_pos_<%=word.getId()%>" id="word_pos_<%=word.getId()%>" value="<%=npos.getTag()%>">
			<%
				}
			%>
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