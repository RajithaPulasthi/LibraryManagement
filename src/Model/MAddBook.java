package Model;
import java.sql.*;
import javax.swing.*;

public class MAddBook {
    public void addNewBook(int Book_ID, String Book_Name, String Auther, int Published_Year, String Genre){
        try{
            Statement st=MDbConnector.getDbConnection().createStatement();
            int row_count=st.executeUpdate("Insert into bookdetails values('"+Book_ID+"','"+Book_Name+"','"+Auther+"','"+Published_Year+"','"+Genre+"')");
            if(row_count>0){
               JOptionPane.showMessageDialog(null, "successfully submitted", "Info", JOptionPane.INFORMATION_MESSAGE);
           }
            else{
                JOptionPane.showMessageDialog(null, "Try again", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void addNewBook(int Book_ID, String Book_Name, String Auther, java.util.Date Published_Year, String Genre) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
