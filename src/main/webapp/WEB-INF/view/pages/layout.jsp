<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>
<html>
    <head>
        <title>
            EC2 Simple WebApp - <c:out value="${title}" />
        </title>
        <link rel="stylesheet" type="text/css" href="${staticResourcesUrl}/content/css/layout.css" />
    </head>
    <body>
        <header>
            <h1>
                <a href="/">
                    EC2 Simple WebApp
                </a>
            </h1>
            <h2>
                <c:out value="${title}" />
            </h2>
        </header>
        <main>
            <tiles:insertAttribute name="content" />
        </main>
        <footer>
            <p>
                Generated on <strong><c:out value="${hostname}" /></strong>
            </p>
            <p>
                Session: <strong> <c:out value="${pageContext.session.id}"/> </strong>
            </p>
            <p>
                <a href="/home">
                    Back to Home
                </a>
            </p>
        </footer>
    </body>
</html>
