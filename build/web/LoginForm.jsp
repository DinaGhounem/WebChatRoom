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
            <form method="post">
                <h1>Login Form</h1>
                <div id="status"/>
                <Label>Enter Your Name:</label><input type="text" value="" name="uname">
                <br>
                <Label>Enter Your Password:</label><input type="password" value="" name="password">
                <br>
                <input type="button" value="SignUp">
            </form>
            <br><br><br><br><br><br><br>
            <a href="RegistrationForm.jsp"> Please Signup</a>
        </center>
    </body>
</html>
