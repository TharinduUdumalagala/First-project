package dao.custom;

import dao.CrudDao;
import entity.StudentDetails;

public interface StudentDetailsDao extends CrudDao<StudentDetails,String> {
    public StudentDetails getStudentId(StudentDetails studentDetails)throws Exception;

}
