/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Dina PC
 */
public class CheckSignup implements Filter{
    @Override
    public void init(FilterConfig fc) throws ServletException {
       
    }

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
       String userName = sr.getParameter("uname");
        String password = sr.getParameter("password");
        String email = sr.getParameter("email");
        
        if(userName.isEmpty() || password.isEmpty() || email.isEmpty())
        {
            RequestDispatcher rd = sr.getRequestDispatcher("RegistrationForm.jsp");
            rd.include(sr, sr1);
        }
        else
        {
            fc.doFilter(sr, sr1);
        }
    }

    @Override
    public void destroy() {
       
    }
}
