/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import dto.User;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import servlets.LoggedUsers;
import servlets.RegisteredUsers;

/**
 *
 * @author Dina PC
 */
public class CheckLogin  implements Filter{

    @Override
    public void init(FilterConfig fc) throws ServletException {
                                                                
    }

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
        
        
        String userName = sr.getParameter("uname");
        String password = sr.getParameter("password");
       
        LoggedUsers users = new LoggedUsers();
        
        for(int i=0;i<RegisteredUsers.registeredUsers.size();i++)
        {
            User user = RegisteredUsers.registeredUsers.get(i);
            if(user.getUserName().equals(userName) && user.getPassword().equals(password))
            {
                fc.doFilter(sr, sr1);
            }
            else
            {
                RequestDispatcher rd = sr.getRequestDispatcher("LoginForm.jsp");
                rd.include(sr, sr1);
            }
        }        
    }

    @Override
    public void destroy() {
      
    }
    
}
