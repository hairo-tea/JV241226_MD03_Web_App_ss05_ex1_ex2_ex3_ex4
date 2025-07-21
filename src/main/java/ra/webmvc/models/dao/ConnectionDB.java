package ra.webmvc.models.dao;

import org.springframework.stereotype.Component;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class ConnectionDB {
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/studentmanagement_db";
    private final String USER = "root";
    private final String PASS = "123456@";
    
    public Connection openConnection() {
        try{
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL,USER,PASS);
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
        return null;
    }
    public void closeConnection(Connection con, CallableStatement cs) {
        if(con != null){
            try{
                con.close();
            } catch (Exception e) {
              throw new RuntimeException();
            }
        }
        if(cs != null){
            try{
                cs.close();
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }
    }
}
