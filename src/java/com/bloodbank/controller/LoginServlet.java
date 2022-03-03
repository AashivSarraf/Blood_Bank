
package com.bloodbank.controller;

import com.bloodbank.dao.UserDao;
import com.bloodbank.dto.User;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "login",urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet{

    private UserDao userDao;
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        userDao=new UserDao();
        super.init(config); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String email=req.getParameter("email");
        String password=req.getParameter("password");
        
        User user=userDao.getUser(email,password);
        
        if(user==null){
            resp.sendRedirect("login.jsp?err=1");
        }else{
            
            if(user.isVerifyStatus()){
                HttpSession session=req.getSession();
                session.setAttribute("user", user);
            
                resp.sendRedirect("users/home.jsp");
            }
            else{
                resp.sendRedirect("verify.jsp");
            }
        }
        
    }
    
}
