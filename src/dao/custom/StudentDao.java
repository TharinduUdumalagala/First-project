package dao.custom;

import dao.CrudDao;
import dto.StudentDTO;
import entity.Student;

import java.util.List;

public interface StudentDao extends CrudDao<Student, Integer> {
    public int getNextId() throws Exception;
    public int getCount()throws Exception;
    public int getParentId(int student_Id) throws Exception;
    public List<Student> checkStudent() throws Exception;
}
