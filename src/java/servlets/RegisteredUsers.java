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

/**
 *
 * @author Dina PC
 */
public class RegisteredUsers extends HttpServlet {

    public static ArrayList<User> registeredUsers = new ArrayList<>();
    
    protected void goChat(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher rd = request.getRequestDispatcher("ChatPage.jsp");
            rd.forward(request, response);
    }
    //post method to add new registered users
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               
        String userName = request.getParameter("uname");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        int status = 1;
        
        //adding the registered user in users arraylist
        User user = new User(userName, password, email, status);
        registeredUsers.add(user);
        
        goChat(request, response);
    }
 
}
