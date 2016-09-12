<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>
<html>
    <head>
        <title>
            <c:out value="${title}" />
        </title>
        <link rel="stylesheet" type="text/css" href="<spring:url value='/content/css/layout.css' />" />
    </head>
    <body>
        <header>
            <h1>
                Cluster Webapp Demo
            </h1>
        </header>
        <main>
            <tiles:insertAttribute name="content" />
        </main>
        <footer>
            Generated on <strong><c:out value="${hostname}" /></strong>
        </footer>
    </body>
</html>
