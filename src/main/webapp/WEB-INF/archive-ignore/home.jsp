<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<section>
    <h1>
        Welcome...
    </h1>
    <p>
        <strong>
            Session value:
        </strong>
    </p>
    <p>
        <c:out value="${sessionData.value}" />
    </p>
    <p>
        <strong>
            Processed By:
        </strong>
    </p>
    <p>
        <c:out value="${sessionData.processedBy}" />
    </p>
    <p>
        <strong>
            Update:
        </strong>
    </p>
    <p>
        <form method="post" action="<spring:url value='/process' />">
            <input type="text" name="value" value="<c:out value='${sessionData.value}' />" />
            <input type="submit" value="Update" />
        </form>
    </p>
</section>
