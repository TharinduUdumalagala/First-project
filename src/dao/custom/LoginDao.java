package dao.custom;

import entity.User;

public interface LoginDao {
    public User checkLogin(String name,String password)throws Exception;

}
