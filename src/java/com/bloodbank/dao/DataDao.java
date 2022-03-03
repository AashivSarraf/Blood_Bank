
package com.bloodbank.dao;

import com.bloodbank.dto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataDao implements BaseDao<Data>{
   
    @Override
    public boolean save(Data ob) {
        try(Connection cnn=DBConnection.getConnection()) {
            String query="insert into data(user_name,email,phone,location,bloodgroup,person) value(?,?,?,?,?,?)";
            PreparedStatement ps=cnn.prepareStatement(query);
            ps.setString(1, ob.getUserName());
            ps.setString(2, ob.getEmail());
            ps.setString(3, ob.getPhone());
            ps.setString(4, ob.getLocation());
            ps.setString(5, ob.getBloodGroup());
            ps.setInt(6, ob.getPerson());
            int i=ps.executeUpdate();
            if(i>0)
                return true;
            else
                return false;
        } 
        ///catch (ClassNotFoundException ex) {
//            Logger.getLogger(DataDao.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(DataDao.class.getName()).log(Level.SEVERE, null, ex);
//        }
            catch(Exception ex){
                System.out.println("DataDao, save:"+ex.getMessage());
                ex.printStackTrace();
                return false;
            }
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Data ob) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Data> list() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Data get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ArrayList<Data> listByName(String email){
        ArrayList<Data> list=new ArrayList<>();
        try(Connection cnn=DBConnection.getConnection()) {
//            String query="select * from data where email = '"+email+"'";
//            Statement stm=cnn.createStatement();
            String query="select * from data where email=?";
        
            PreparedStatement ps=cnn.prepareStatement(query);
            ps.setString(1, email);
            
//            ResultSet rs=stm.executeQuery(query);
            ResultSet rs=ps.executeQuery();
            System.out.println(query);
//            System.out.println(rs);
            while(rs.next()){
                String userName=rs.getString("user_name");
                String useremail=rs.getString("email");
                String phone=rs.getString("phone");
                String location=rs.getString("location");
                String bloodGroup=rs.getString("bloodgroup");
                Date uploadDate=rs.getDate("date");
                
                Data data=new Data(userName,email,phone,location,bloodGroup,uploadDate);
//                System.out.println(data);
                list.add(data);
                
            }
        } catch (Exception ex){
            System.out.println("DataDao, listByName:"+ex.getMessage());
            ex.printStackTrace();
        }
        System.out.println(list);
        return list;
    }
    
}
