/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import com.google.gson.Gson;
import dto.Message;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dina PC
 */
public class ChatRoomServlet extends HttpServlet {

    static ArrayList<Message> messages = new ArrayList();
    static int count=0;
    HttpSession session;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       
        String sender = (String)  request.getSession().getAttribute("uname"); //request.getParameter("MyName");
        String messageBody = request.getParameter("myMessage");
        if(!messageBody.equals(""))
        {
            count++;
            Message msg = new Message(sender, messageBody,count);
            messages.add(msg); 
            System.out.println("sender:"+sender);
            System.out.println("message:"+messageBody);
        }      
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Gson gson= new Gson();
        PrintWriter out = response.getWriter();
        out.println(gson.toJson(messages));
    }

}
