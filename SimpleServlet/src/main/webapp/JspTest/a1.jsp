<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>


<html>

<head></head>
<body>

    <%!
        int i = 100;
        int sum(int a1,int a2) {
            return a1+a2;
        }
    %>
    <%=i + 100%><!--200-->
    <%=sum(1,2)%><!--3-->

</body>
</html>