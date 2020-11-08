package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.LoginDao;
import entity.User;

import java.sql.ResultSet;

public class LoginDaoImpl implements LoginDao{

    @Override
    public User checkLogin(String name,String password) throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM  user WHERE Name=? AND Password=?",name,password);
        if (resultSet.next()) {
            return new User(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3));
        }
        return null;
    }

}

