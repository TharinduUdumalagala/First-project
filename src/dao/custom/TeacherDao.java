package dao.custom;

import dao.CrudDao;
import entity.Teacher;

public interface TeacherDao extends CrudDao<Teacher,String> {
    public int getCount()throws Exception;
    public int getNextId() throws Exception;
}
