<%-- 
    Document   : LoginForm
    Created on : Feb 21, 2018, 1:48:46 PM
    Author     : Dina PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<Link rel=stylesheet href="css/style2.css" type="text/css">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <center>
            <form method="post" action="LoggedUsers" class="formStyle">
                <h1>Login Form</h1>
                <Label> Username:</label><input type="text" value="" name="uname">
                <br>
                <Label> Password:</label><input type="password" value="" name="password">
                <br>
                <input type="submit" value="Login">
            </form>
            <br><br><br>
            <a href="RegistrationForm.jsp">For First Time .. Please Sign Up!!</a>
        </center>
    </body>
</html>
