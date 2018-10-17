<%-- 
    Document   : login
    Created on : Oct 11, 2018, 12:30:14 PM
    Author     : 601354
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="login"%>

<%-- any content can be specified here e.g.: --%>
<form action="login" method="post">
    Username:<input type="text" name="user" value=""><br>
    Password:<input type="text" name="pass" value=""><br><br>
    <input type="submit" value="login"><br>
    <input type="checkbox" name="rem" value="">Remember Me
</form>