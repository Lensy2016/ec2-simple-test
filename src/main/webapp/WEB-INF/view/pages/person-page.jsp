<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


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
