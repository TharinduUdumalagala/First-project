package bo.custom.impl;

import bo.custom.LoginBo;
import dao.DaoFactory;
import dao.custom.LoginDao;
import dto.LoginDTO;
import entity.User;

public class LoginBoImpl implements LoginBo {

    LoginDao loginDao = DaoFactory.getInstance().getDao(DaoFactory.DAOType.LOGIN);

    @Override
    public LoginDTO login(String name, String password) throws Exception {
        User user = loginDao.checkLogin(name, password);
        if (user != null){
            return new LoginDTO(user.getUserId(),
                    user.getName(),
                    user.getPassword());
        }
        return null;
    }
}
