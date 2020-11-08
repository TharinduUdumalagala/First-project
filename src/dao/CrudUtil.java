package dao;

import db.DBConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CrudUtil {
    public static <S> S execute(String sql,Object...args) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement(sql);
        for (int i = 0; i < args.length; i++){
            stm.setObject((i+1),args[i]);
        }
        if (sql.startsWith("SELECT")){
            return (S)stm.executeQuery();
        }
        return ((S) (Boolean) (stm.executeUpdate()>0));
    }
}
