
//REMAINING(OTP,EMAIL)

package com.bloodbank.controller;

import com.bloodbank.dao.UserDao;
import com.bloodbank.dto.User;
import com.bloodbank.service.EmailService;
import java.io.IOException;
import java.util.Random;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "register",urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet{
    
    private UserDao userDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        userDao=new UserDao();
        super.init(config); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        EmailService mail=new EmailService();
        
        String userName=req.getParameter("userName");
        String email=req.getParameter("email");
        String password=req.getParameter("password");
        
        User user=new User();
        user.setUserName(userName);
        user.setEmail(email);
        user.setPassword(password);
        
        boolean status=userDao.save(user);
        
        if(status)
        {
            Random r = new Random(System.currentTimeMillis());
            int otp =  10000 + r.nextInt(20000);
            
            mail.sendVerifyMail(userName, email, otp);
            userDao.updateOTP(email,otp);
        }
        
        String url="register.jsp?reg="+status;
        resp.sendRedirect(url);
        
    }
    
    
}
