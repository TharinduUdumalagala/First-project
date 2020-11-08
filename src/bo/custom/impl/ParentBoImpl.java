package bo.custom.impl;

import bo.custom.ParentBo;
import dao.DaoFactory;
import dao.custom.ParentDao;

public class ParentBoImpl implements ParentBo {

    ParentDao parentDao = DaoFactory.getInstance().getDao(DaoFactory.DAOType.PARENT);

    @Override
    public int getNextId() throws Exception {
        return parentDao.getNextId();
    }
}
