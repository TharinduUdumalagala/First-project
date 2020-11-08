package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
   private static DBConnection dbConnection;

   private Connection connection;

   private DBConnection() throws ClassNotFoundException, SQLException {
       Class.forName("com.mysql.jdbc.Driver");
       connection = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","990226");
   }

   public static DBConnection getInstance() throws SQLException, ClassNotFoundException {
       if(dbConnection == null){
           return new DBConnection();
       }else {
           return dbConnection;
       }
   }

   public Connection getConnection(){
       return connection;
   }
}
