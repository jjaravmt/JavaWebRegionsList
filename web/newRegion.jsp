<%--
  Created by IntelliJ IDEA.
  User: Administrador
  Date: 03/02/2018
  Time: 21:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>New Region</h1>
    <form action="regions" method="post">
        <fieldset>
            <input type="hidden" name="action" value="create"/>
            <jsp:include page="_region_fieldset.jsp"/>
        </fieldset>
    </form>
</body>
</html>
