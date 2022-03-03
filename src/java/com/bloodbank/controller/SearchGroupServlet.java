
package com.bloodbank.controller;

import com.bloodbank.dao.DBConnection;
import com.bloodbank.dto.Data;
import com.google.gson.Gson;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "search",urlPatterns = {"/users/search"})
public class SearchGroupServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        try( Connection cnn=DBConnection.getConnection()) {
            ArrayList<Data> list=new ArrayList<>();
            String txt=req.getParameter("txt");
            String query="select * from data where bloodgroup LIKE '%"+txt+"%' order by user_name";
            System.out.println(query);
            Statement stm=cnn.createStatement();
            ResultSet rs=stm.executeQuery(query);
            while(rs.next()){
                String userName=rs.getString("user_name");
                String email=rs.getString("email");
                String phone=rs.getString("phone");
                String location=rs.getString("location");
                String bloodGroup=rs.getString("bloodgroup");
                
                Data data=new Data(userName,email,phone,location,bloodGroup);
                
                list.add(data);
            }
            Gson gson=new Gson();
            String str=gson.toJson(list);
            resp.getWriter().write(str);
            
        } catch(Exception ex){
            System.out.println("SearchGroupServlet:"+ex.getMessage());
            ex.printStackTrace();
        }
    }
    
}
