<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Person Result page</title>
</head>
<body>
<h1>Person Result page</h1>

<c:if test="${sessionData.sessionBased}">
<!-- Session Data Present -->
<p>Student's name is ${sessionData.firstName}. The age is ${sessionData.age}.</p>
<c:set var="destination" scope="request" value="session-finalize-person.html" />
<p><strong>Processed By:</strong> <c:out value="${sessionData.hosts}"/></p>
</c:if>

<c:if test="${! sessionData.sessionBased}">
<!-- Session Data Not Present -->
<p>Student's name is ${person.firstName}. The age is ${person.age}.</p>
<c:set var="destination" scope="request" value="finalize-person.html" />
</c:if>

<form:form method="POST" modelAttribute="person" action="${destination}">
  <form:hidden path="firstName" value="${person.firstName}"/>
  <form:hidden path="age" value="${person.age}"/>
  
<table>
    <tr>
        <td><form:label path="lastName">last name:</form:label></td>
        <td><form:input path="lastName" /></td>
    </tr>
    
    <tr>
        <td><form:label path="shoeSize">shoe size:</form:label></td>
        <td><form:input path="shoeSize" /></td>
    </tr>

    <tr>
        <td><form:label path="generateLoad">Generate Load?</form:label></td>
        <td><form:checkbox path="generateLoad" /></td>
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