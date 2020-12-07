<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>


<html>

<head></head>
<body>

<%
    pageContext.setAttribute("username", "Lisa");
%>
<%=pageContext.getAttribute("username")%>

</body>
</html>