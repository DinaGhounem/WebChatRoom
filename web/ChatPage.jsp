<%-- 
    Document   : ChatPage
    Created on : Feb 21, 2018, 1:49:03 PM
    Author     : Dina PC
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<Link rel=stylesheet href="css/style2.css" type="text/css">
<html>
    <script  src="lib/jquery-1.4.4.min.js"></script>
    <script>
        function getUsers() {
            $.ajax({
                url: 'DisplayUsersServlet',
                type: 'POST',
                contentType: 'application/json',
                dataType: 'json',
                success: function (val) {
                    var users = val;
                    $("#displayUsers tr").remove();
                    for (var i = 0; i < val.length; i++) {
                        $('#displayUsers').append('<tr><td>' + users[i].userName + '</td><td>' + users[i].status + '</td > </tr>');
                    }
                }
            });
        }
        function refresh() {
            $.ajax({
                url: 'ChatRoomServlet',
                type: 'POST',
                contentType: 'application/json',
                dataType: 'json',
                success: function (val) {
                    var messages = val;
                    $("#myMessage").value = " ";
                    $("#displayMessages tr").remove();
                    for (var i = 0; i < val.length; i++) {
                        $('#displayMessages').append('<tr><td>' + messages[i].senderName + '</td><td>' + messages[i].messageContent + '</td > </tr>');
                    }


                }
            });
        }

        $("document").ready(function ()
        {
            $("#sendBtn").click(function () {
                var myMessage = $("#myMessage").val();
                var jsonData = {"myMessage": myMessage};
                $.ajax({url: 'ChatRoomServlet',
                    type: 'GET', //servlet request type
                    contentType: 'application/json', //For input type
                    data: jsonData, //input data
                    dataType: 'json', //For output type
                    success: function (data)
                    {
                        $("myMessage").append(" ");

                    }
                });
            });
        });
    </script>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body onload="setInterval('refresh()', 2000), setInterval('getUsers()', 2000)">
    <center>
        <form method="post" action="LogoutServlet">
            <input type="submit" value="Logout" id="logoutBtn">
        </form>
        <table border="1">
            <tr>
                <th>USER</th>
                <th>STATUS</ths>
            <tbody id="displayUsers"></TBODY>
            </tr>
        </table>
        <table>
            <tr>
                <td>
                    <LABEL>Message :</LABEL> <input type="text" value="" name="myMessage" id="myMessage"/>
                    <br>
                    <input type="button" value="Send" id="sendBtn"/>
                    <br><br><br><br>
                    <div>
                        <TABLE border="1">
                            <TR>
                                <th>NAME</th>
                                <TH>MESSAGE</TH>
                            <tbody id="displayMessages"></TBODY>
                            </TR>
                        </TABLE>
                    </div>
                </td>
            </tr>
        </table>
    </CENTER>
</body>
</html>
