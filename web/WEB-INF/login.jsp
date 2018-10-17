<%-- 
    Document   : login
    Created on : Sep 27, 2018, 12:08:09 PM
    Author     : 601354
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="sait" %>
<%@ taglib prefix="sait2" uri="/WEB-INF/tlds/sait" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Week6Lab_loginCustomTag</title>
    </head>
    <body>
        <sait2:Debug>
            Remote Host: ${pageContext.request.remoteHost}<br />
            Session ID: ${pageContext.session.id}
        </sait2:Debug>

        <h1>Remember Me Login Page</h1>
        <sait:login/>
        <div>
            ${message}
        </div>
    </body>
</html>
