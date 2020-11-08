package dao.custom;

import dao.CrudDao;
import entity.Grade;

import java.util.List;

public interface GradeDao{
    List<Grade> getAll() throws Exception;
    public  int getId(String gradeName)throws Exception;
    public int getNextId() throws Exception;
}
