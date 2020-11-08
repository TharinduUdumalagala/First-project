package dao.custom;

import dao.CrudDao;
import entity.Parent;

public interface ParentDao extends CrudDao<Parent, String> {
    public int getNextId() throws Exception;
}
