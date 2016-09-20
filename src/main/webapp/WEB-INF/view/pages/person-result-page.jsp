<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<c:if test="${sessionData.sessionBased}">
<p>Student's name is ${sessionData.firstName} ${sessionData.lastName}. The age is ${sessionData.age} and shoe size is ${sessionData.shoeSize}.</p>
<p><strong>Processed By:</strong> <c:out value="${sessionData.hosts}"/></p>
</c:if>

<c:if test="${! sessionData.sessionBased}">
<p>Student's name is ${pers.firstName} ${pers.lastName}. The age is ${pers.age} and shoe size is ${pers.shoeSize}.</p>
</c:if>
