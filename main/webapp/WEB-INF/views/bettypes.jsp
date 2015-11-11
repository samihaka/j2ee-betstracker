<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="texts" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title><texts:message code="betTypes.title"/></title>
		<link rel="stylesheet" type="text/css" href="resources/styles/bets_tracker.css">
	</head>

	<body>
		<%@ include file="includes/header.jsp" %>

		<h2><texts:message code="betTypes.title"></texts:message></h2>

		<c:forEach var="betType" items="${betTypes}">
			<p>${betType.name}, ${betType.requiresBetTarget}</p>
		</c:forEach>		
	</body>
</html>
