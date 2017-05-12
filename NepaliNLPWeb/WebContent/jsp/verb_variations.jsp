<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Form Variations of Verb</title>
<link href="../css/jquery-ui.css" rel="stylesheet">
<link href="../css/bootstrap.css" rel="stylesheet">
<link href="../css/nlpweb.css" rel="stylesheet">

</head>
<body>
	<%
		List<String> resultAffirmative = null;
		if (request.getSession().getAttribute("VerbVariationsResultAffirmative") != null) {
			resultAffirmative = (List<String>) request.getSession().getAttribute("VerbVariationsResultAffirmative");
		}
		
		List<String> resultNegative = null;
		if (request.getSession().getAttribute("VerbVariationsResultNegative") != null) {
			resultNegative = (List<String>) request.getSession().getAttribute("VerbVariationsResultNegative");
		}
		
		String queryVerb = (String)request.getSession().getAttribute("verb");
		if(queryVerb == null) {
			queryVerb = "";
		}
		
	%>
	<div class="parent">
		<h1 align="center">Verb Variations - Nepali NLP Web</h1>
		<br/>
		<!-- WEBSITE INPUT -->
		<div class="class1">
			<form name="submitForm" action="/NepaliNLPWeb/VerbVariationServlet" method="post">
				Enter Verb ending in नु (e.g. ल्याउनु) <input type="text" size="70" maxlength="500" name="verb" id="verb" value='<%=queryVerb%>'><button class="ui-button ui-widget ui-corner-all">Submit</button>
			</form>
		</div>
	
			<!-- VERB VARIATIONS - AFFIRMATIVE -->
			<div class="ui-state-highlight ui-corner-all" style="margin-top: 20px; padding: 0 .7em;">
				<br />VERB VARIATIONS - AFFIRMATIVE<br />
				<%
					if (resultAffirmative != null) {
						int count = 0;
						for (String verb : resultAffirmative) {
						String buttonClass = count%2==0?"button2":"button3";
					%>
					<button class="button <%=buttonClass%>"><%=verb%></button>
				<%
					count++;
					} //for loop
					} //if
				%>
	
			</div>
			
			<!-- VERB VARIATIONS - NEGATIVE -->
			<div class="ui-state-highlight ui-corner-all" style="margin-top: 20px; padding: 0 .7em;">
				<br />VERB VARIATIONS - NEGATIVE<br />
				<%
					if (resultNegative != null) {
						int count = 0;
						for (String verb : resultNegative) {
						String buttonClass = count%2==0?"button6":"button7";
					%>
					<button class="button <%=buttonClass%>"><%=verb%></button>
				<%
					count++;
					} //for loop
					} //if
				%>
			</div>
			<br/>
</div>
</body>

	<script src="../js/jquery.js"></script>
	<script src="../js/jquery-ui.js"></script>
	<script src="../js/bootstrap.js"></script>
	<script>
		$("[id*=controlgroup]").controlgroup();
	</script>
</html>