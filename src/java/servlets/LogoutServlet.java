/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dto.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dina PC
 */
public class LogoutServlet extends HttpServlet {

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String uname = (String) request.getSession().getAttribute("uname");
       for(int i=0;i<RegisteredUsers.registeredUsers.size();i++)
        {
            User user = RegisteredUsers.registeredUsers.get(i);
            if(user.getUserName()== uname)
            {
                RegisteredUsers.registeredUsers.get(i).setStatus(0);
                break;
            }
        }
       response.sendRedirect("LoginForm.jsp");
        
    }

}
