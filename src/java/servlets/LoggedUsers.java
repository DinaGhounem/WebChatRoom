/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dto.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static servlets.RegisteredUsers.registeredUsers;

/**
 *
 * @author Dina PC
 */
public class LoggedUsers extends HttpServlet {

    
    protected void goChat(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher rd = request.getRequestDispatcher("ChatPage.jsp");
            rd.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = request.getParameter("uname");
        String password = request.getParameter("password");
        
        for(int i=0;i<RegisteredUsers.registeredUsers.size();i++)
        {
            User user = RegisteredUsers.registeredUsers.get(i);
            if(user.getUserName()== userName && user.getPassword()== password)
            {
                user.setStatus(1);
                break;
            }
        }
        goChat(request, response);
    }
}
