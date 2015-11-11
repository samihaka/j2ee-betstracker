<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="texts" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title><texts:message code="sports.title"/></title>
		<link rel="stylesheet" type="text/css" href="resources/styles/bets_tracker.css">
	</head>

	<body>
		<%@ include file="includes/header.jsp" %>

		<h2><texts:message code="sports.title"></texts:message></h2>
		<%@ include file="includes/messages.jsp" %>
		
		<a href="#"><texts:message code="sports.add"/></a>
		<form:form modelAttribute="newSport" id="newSportForm">
			<label for="name"><texts:message code="label.name"/>: </label>
			<form:input id="name" path="name"/>
			<input type="submit" name="add_sport" value="<texts:message code="buttons.add"/>"/>
		</form:form>
		
		<a href="#"><texts:message code="events.add"/></a>
		<form:form modelAttribute="newEvent" id="newEventForm">
			<label for="sport"><texts:message code="label.sport"/>: </label>
			<form:select path="sportId" id="sportOptions">
				<form:options items="${sports}" itemValue="id" itemLabel="name"/>
			</form:select>
			
			<label for="name"><texts:message code="label.name"/>: </label>
			<form:input id="name" path="name"/>
			<input type="submit" id="addNewEvent" name="add_event" value="<texts:message code="buttons.add"/>"/>
		</form:form>
		
		<c:forEach var="sport" items="${sports}">
			<h2>${sport.name}</h2>
	
			<h3>Bet types:</h3>
			<c:forEach var="betType" items="${sport.betTypes}">
				<p>${betType.name}</p>
			</c:forEach>		
				
			<a href="#"><texts:message code="sports.bettype.add"/></a>
			<form:form modelAttribute="newSportBetType" id="newSportBetTypeForm">
				<label for="name"><texts:message code="label.name"/>: </label>
				<form:input path="sportName" id="sportName" value="${sport.name}"/>
				
				<label for="sportBetType"><texts:message code="label.bettype"/>: </label>
				<form:select path="betTypeId" id="betTypeOptions">
					<form:options items="${betTypeHelper.getMissingBetTypes(sport, messages)}" itemValue="id" itemLabel="name"/>
				</form:select>
				
				<input type="submit" name="add_sport_bettype" value="<texts:message code="buttons.add"/>"/>
			</form:form>	
		
			<h3>Events:</h3>
			<c:forEach var="event" items="${sport.events}">
				<p>${event.name}</p>
			</c:forEach>
		</c:forEach>
	</body>
	
	<!-- Vendor scripts -->
	<script type="text/javascript" src="resources/js/jquery-2.1.4.js"></script>
	
	<script>
		$.noConflict();
		
		jQuery(document).ready(function(){
			var sportOptions = jQuery("#sportOptions option");
		
			sportOptions.each(function(){
				var option = jQuery(this);
				if(option.html() == sessionStorage.getItem("previousSportSelection")){
					option.attr("selected", true);
				}
			});
		
			jQuery("#addNewEvent").click(function(){
				var selectedSport = jQuery("#sportOptions :selected").html();
				
				sessionStorage.setItem("previousSportSelection", selectedSport);
				jQuery("#newEventForm").submit();				
			})
		});
	</script>
</html>