package Model;

import java.sql.*;
import javax.swing.table.DefaultTableModel;
import Model.MDbConnector;
import javax.swing.table.TableModel;


public class MDashboard {
    
public DefaultTableModel getBookData(){
            ResultSet rst = null;
            DefaultTableModel model = new DefaultTableModel();
try {
            int columnIndex;
            Statement st = MDbConnector.getDbConnection().createStatement();
            
            rst = st.executeQuery("Select Book_ID,Book_Name,Author,Availability From books");

            
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
