package Model;
import java.sql.*;

public class MDbConnector {
    private static Connection con;
    public static Connection getDbConnection(){
        try{
        String dbpath="jdbc:mysql://localhost/library";
        con = DriverManager.getConnection(dbpath,"root","RAji@115432");
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return con;
    }
}
