package Model;

import Model.MDbConnector;
import java.sql.*;

import javax.swing.JOptionPane;

public class MRegisterMember {
//    public void registerMember(String name,String address,String email,String phone){
//        try{
//            
//            Statement st=MDbConnector.getDbConnection().createStatement();
//            int row_count=st.executeUpdate("Insert into member values('"+name+"','"+address+"','"+email+"','"+phone+"')");
//            if(row_count>0){
//               JOptionPane.showMessageDialog(null, "successfully submitted", "Info", JOptionPane.INFORMATION_MESSAGE);
//           }
//            else{
//                JOptionPane.showMessageDialog(null, "Try again", "Error", JOptionPane.ERROR_MESSAGE);
//            }
//        }
//        catch(SQLException e){
//            System.out.println(e.getMessage());
//        }
    
    public void registerMember(String name, String address, String email, String phone) {
        String sql = "INSERT INTO member (name, address, email, phone_number) VALUES (?, ?, ?, ?)";
        
        try (
             PreparedStatement pstmt = MDbConnector.getDbConnection().prepareStatement(sql)) {
            
            pstmt.setString(1, name);
            pstmt.setString(2, address);
            pstmt.setString(3, email);
            pstmt.setString(4, phone);
            
            int row_count = pstmt.executeUpdate();
            if (row_count > 0) {
                JOptionPane.showMessageDialog(null, "Successfully submitted", "Info", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Try again", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
  } 

