<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Person Result page</title>
</head>
<body>
<h1>Person Result page</h1>

<c:if test="${!empty sessionData.processedBy}">
<p>Student's name is ${sessionData.firstName} ${sessionData.lastName}. The age is ${sessionData.age} and shoe size is ${sessionData.shoeSize}.</p>
<p>
        <strong>
            Processed By:
        </strong>
         <c:out value="${sessionData.processedBy}" />
    </p>
</c:if>

<c:if test="${empty sessionData.processedBy}">
<p>Student's name is ${pers.firstName} ${pers.lastName}. The age is ${pers.age} and shoe size is ${pers.shoeSize}.</p>
</c:if>

<p><a href="${pageContext.request.contextPath}/">Return to start</a></p>
Generated on <strong><c:out value="${hostname}" /></strong>

</body>
</html>