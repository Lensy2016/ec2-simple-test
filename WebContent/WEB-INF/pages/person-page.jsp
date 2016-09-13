<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Person page</title>
</head>
<body>
<h1>Person page</h1>
<p>This is Person page</p>

<c:if test="${sessionData.sessionBased}">
<c:set var="destination" scope="request" value="session-process-person.html" />
<p><strong>Processed By:</strong> <c:out value="${sessionData.hosts}"/></p>
</c:if>

<c:if test="${! sessionData.sessionBased}">
<c:set var="destination" scope="request" value="process-person.html" />
</c:if>

<form:form method="POST" modelAttribute="person" action="${destination}">
<table>
    <tr>
        <td><form:label path="firstName">Name:</form:label></td>
        <td><form:input path="firstName" /></td>
    </tr>
    <tr>
        <td><form:label path="age">Age:</form:label></td>
        <td><form:input path="age" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Submit"/>
        </td>
        <td></td>
        <td></td>
    </tr>
</table>  
</form:form>
<p><a href="${pageContext.request.contextPath}/">Return to start</a></p>
Generated on <strong><c:out value="${hostname}" /></strong>
Session: <c:out value="${pageContext.session.id}"/>
</body>
</html>