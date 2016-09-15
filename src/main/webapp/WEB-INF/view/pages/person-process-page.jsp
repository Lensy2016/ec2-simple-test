<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



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
