import java.sql.*;
import javax.swing.table.DefaultTableModel;
import Model.MDbConnector;
import javax.swing.table.TableModel;


package Model;
ResultSet rst;
public ResultSet getBookData(){
try {
            int columnIndex;
            Statement st = MDbConnector.getDbConnection().createStatement();
            
            rst = st.executeQuery("Select * From customer");

            DefaultTableModel model = new DefaultTableModel();
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
            TableModel rowData = null;
            
            tbl_books.setModel(model);
            
            st.close();
            con.close();
            
            
        } catch (SQLException exe) {
            System.out.println("Exception " + exe.getMessage());
        }
    }
public class MDashboard {
    
}
