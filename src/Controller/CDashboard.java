package Controller;
import Model.MDashboard;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;


public class CDashboard {
    public DefaultTableModel getBookData(){
        MDashboard Dash = new MDashboard();       
        return (DefaultTableModel) Dash.getBookData();
    
    }
}
