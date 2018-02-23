<%-- 
    Document   : RegistrationForm
    Created on : Feb 21, 2018, 1:48:30 PM
    Author     : Dina PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<Link rel=stylesheet href="css/style2.css" type="text/css">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign Up Page</title>
    </head>
    <body>
        <center>
            <form mehtod= "post" action="RegisteredUsers" class="formStyle">
                <h1>Registration Form</h1>
                <div id="status"></div>
                <Label>Enter Your Username: </label><input type="text" value="" name="uname" id="uname">
                <br>
                <Label>Enter Your Password: </label><input type="password" value="" name="password" id="password">
                <br>
                <Label>Enter Your E-Mail:     </label><input type="email" value="" name="email" id="email">
                <br>
                <input type="submit" value="SignUp">
            </form>
        </center>
    </body>
</html>
