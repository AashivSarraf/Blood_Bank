
package com.bloodbank.controller;

import com.bloodbank.dao.DataDao;
import com.bloodbank.dto.Data;
import com.bloodbank.dto.User;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "add",urlPatterns = {"/users/add"})
public class AddGroupServlet extends HttpServlet{
    
    private DataDao dataDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        dataDao=new DataDao();
        super.init(config); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        HttpSession session=req.getSession();
        User user=(User) session.getAttribute("user");
        
        int userid=user.getUserid();
        
        String userName=req.getParameter("userName");
        String email=req.getParameter("email");
        String phone=req.getParameter("phone");
        String location=req.getParameter("location");
        String bloodGroup=req.getParameter("group");
        
        Data data=new Data(userName,email,phone,location,bloodGroup,userid);
        boolean status=dataDao.save(data);
        
        String url=req.getContextPath()+"/users/addgroup.jsp?reg="+status;
        resp.sendRedirect(url);
        
    }
    
    
}
