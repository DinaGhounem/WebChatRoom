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
import javax.servlet.http.HttpSession;
import static servlets.RegisteredUsers.registeredUsers;

/**
 *
 * @author Dina PC
 */
public class LoggedUsers extends HttpServlet {

    HttpSession session;    
    protected void goChat(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher rd = request.getRequestDispatcher("ChatPage.jsp");
            rd.forward(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (session == null)
            response.sendRedirect("LoginForm.jsp");
        else
        {
            String loggedIn = (String) session.getAttribute("loggedIn");
            if (!loggedIn.equals("true"))
                response.sendRedirect("LoginForm.jsp");
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = request.getParameter("uname");
        String password = request.getParameter("password");
        
        session = request.getSession(true);
        session.setAttribute("loggedIn", new String("true"));
        session.setAttribute("uname",userName);
        
        for(int i=0;i<RegisteredUsers.registeredUsers.size();i++)
        {
            User user = RegisteredUsers.registeredUsers.get(i);
            if(user.getUserName().equals(userName) && user.getPassword().equals(password))
            {
                user.setStatus(1);
                break;
            }
        }
        goChat(request, response);
    }
}
