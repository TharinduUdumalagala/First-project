package dao.custom;

import dao.CrudDao;
import entity.Subject;

public interface SubjectDao extends CrudDao<Subject,String> {
    public int getCount() throws Exception;
    public int getId(String subName) throws Exception;
    public int getNextId() throws Exception;

}

