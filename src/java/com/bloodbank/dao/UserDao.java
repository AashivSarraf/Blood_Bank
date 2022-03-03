
package com.bloodbank.dao;

import com.bloodbank.dto.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDao implements BaseDao<User>{

    @Override
    public boolean save(User ob) {
        try(Connection cnn=DBConnection.getConnection()) {
            String query="insert into user(user_name,email,password) value(?,?,?)";
            PreparedStatement ps=cnn.prepareStatement(query);
            ps.setString(1, ob.getUserName());
            ps.setString(2, ob.getEmail());
            ps.setString(3, ob.getPassword());
            
            int i=ps.executeUpdate();
            if(i>0) return true;
            else return false;
                    
        } catch(Exception ex){
            System.out.println("UserDao, save:"+ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(User ob) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> list() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public User getUser(String email, String password) {
        try(Connection cnn=DBConnection.getConnection()) {
            String query="select userid,user_name,email,isverify from user where email=? and password=?";
            PreparedStatement ps=cnn.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                int userid=rs.getInt("userid");
                String userName=rs.getString("user_name");
                String useremail=rs.getString("email");
                boolean verifyStatus=rs.getBoolean("isverify");
                
                User user=new User(userid,userName,email);
                user.setVerifyStatus(verifyStatus);
                return user;
            }else{
                return null;
            }
        } catch(Exception ex){
            System.out.println("UserDao, gerUser:"+ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }

    public void updateOTP(String email, int otp) {
        try(Connection cnn=DBConnection.getConnection()) {
            String query="update user set otp=? where email=?";
            PreparedStatement ps=cnn.prepareStatement(query);
            ps.setInt(1, otp);
            ps.setString(2, email);
            int i=ps.executeUpdate();
        } catch (Exception ex){
            System.out.println("UserDao, updateOTP:"+ex.getMessage());
            ex.printStackTrace();
        }
    }


    public boolean verifyUser(String email, String otp) {
        try(Connection cnn=DBConnection.getConnection()) {
            String query="update user set isverify='1' where email=? and otp=?";
            PreparedStatement ps=cnn.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, otp);
            int i=ps.executeUpdate();
            if(i>0) return true;
            else return false;
        } catch (Exception ex){
            System.out.println("UserDao, verifyUser:"+ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }
    
}
