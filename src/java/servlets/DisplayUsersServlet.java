/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static servlets.ChatRoomServlet.messages;

/**
 *
 * @author Dina PC
 */
public class DisplayUsersServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Gson gson= new Gson();
        PrintWriter out = response.getWriter();
        out.println(gson.toJson(RegisteredUsers.registeredUsers));
    }
}
