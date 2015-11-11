<c:if test="${messages.size() > 0}">
	<p>Messages</p>

	<c:forEach var="message" items="${messages}">
		<p><texts:message code="${message}"/></p>		
	</c:forEach>
</c:if>