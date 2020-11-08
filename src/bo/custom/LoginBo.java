package bo.custom;

import dto.LoginDTO;

public interface LoginBo {
    public LoginDTO login(String name, String password)throws Exception;
}
