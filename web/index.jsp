<%-- 
    Document   : index
    Created on : Mar 28, 2012, 12:22:10 AM
    Author     : shamik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="login" method="post" >
        <input type="text" name="loginid" />
        <input type="text" name="pass" />
        <input type="submit" />
        </form>
        <% if(request.getParameter("message")!=null){
        %> <%=request.getParameter("message") %><%

        }
        %>
    </body>
</html>
