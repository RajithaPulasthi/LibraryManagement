package Model;

import Model.MDbConnector;
import com.mysql.cj.xdevapi.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class MBookHistory {
    
    public String getBookName(int bookId) {
        String bookName = null;
        try {
            Statement st = (Statement) MDbConnector.getDbConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT Book_Name FROM books WHERE book_id = " + bookId);
            if (rs.next()) {
                bookName = rs.getString("name");
            }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return bookName;
    }
    public String getMemberName(int memberId) {
        String memberName = null;
        try {
            Statement st = (Statement) MDbConnector.getDbConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT name FROM members WHERE member_id = " + memberId);
            if (rs.next()) {
                memberName = rs.getString("name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return memberName;
    }
    
    public DefaultTableModel getData(){
            ResultSet rst = null;
            DefaultTableModel model = new DefaultTableModel();
            
            try {
            int columnIndex;
            java.sql.Statement st = MDbConnector.getDbConnection().createStatement();
            
            rst = st.executeQuery("SELECT b.name AS book_name, m.name AS member_name, bi.issued_date,bi.return_date FROM book_issue_return bi JOIN books b ON bi.book_id = b.book_id JOIN  members m ON bi.member_id = m.member_id;");

            
            com.mysql.cj.jdbc.result.ResultSetMetaData metaData = (com.mysql.cj.jdbc.result.ResultSetMetaData) rst.getMetaData();
            int columnCount = metaData.getColumnCount();

            for (columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                 model.addColumn(metaData.getColumnLabel(columnIndex));
            }

            while (rst.next()) {
            Object[] rowData = new Object[columnCount];
            for (int i = 0; i < columnCount; i++) {
            rowData[i] = rst.getObject(i + 1);
            }
                model.addRow(rowData);
            }            
            
        } catch (SQLException exe) {
            System.out.println("Exception " + exe.getMessage());
        }
        return model;
    }
}

