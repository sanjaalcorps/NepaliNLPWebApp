<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.icodejava.research.nlp.services.WordsUnreferencedService"%>
<%@ page import="com.icodejava.research.nlp.domain.Word"%>

<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge"> -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>NLP - Names Validate and Classify</title>
<link href="../css/jquery-ui.css" rel="stylesheet">
<link href="../css/bootstrap.css" rel="stylesheet">
<style>
body {
	width:400px;
	font-family: "Trebuchet MS", sans-serif;
	margin: 50px;
}
div.class1 {
    width:300px;
    margin: 10px;
    border: 3px solid #73AD21;
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

	<form action="/NepaliNLPWeb/NamesValidationClassificationServlet" method="post">

		<%
			List<Word> words = WordsUnreferencedService.selectUnverifiedNames(50);
			int count = 1;
			for (Word word : words) {
		%>
		
		<fieldset>
			<legend><%= count++ + " - " + word.getWord()%></legend>
			<div id="controlgroup_<%=word.getId()%>" class="class1">
			
				<label for="word_person_<%=word.getId()%>">Person</label> 
				<input type="checkbox" name="word_person_<%=word.getId()%>" id="word_person_<%=word.getId()%>" checked="checked">
				<label for="word_firstname_<%=word.getId()%>">Firstname</label> 
				<input type="checkbox" name="word_firstName_<%=word.getId()%>" id="word_firstname_<%=word.getId()%>" checked="checked">
				<label for="word_surname_<%=word.getId()%>">Surname</label> 
				<input type="checkbox" name="word_surname_<%=word.getId()%>" id="word_surname_<%=word.getId()%>">
				<label for="word_skip_<%=word.getId()%>">Skip</label> 
				<input type="checkbox" name="word_skip_<%=word.getId()%>" id="word_skip_<%=word.getId()%>">
				

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