package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.StudentDetailsDao;
import entity.StudentDetails;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StuedntDetailsDaoIml implements StudentDetailsDao {


    @Override
    public StudentDetails getStudentId(StudentDetails studentDetails) throws Exception {
            ResultSet resultSet = CrudUtil.execute("SELECT * FROM registration WHERE Student_Id=? AND Sub_Id=?",
                    studentDetails.getStudentId(),
                    studentDetails.getSubId());
            if (resultSet.next()){
                return new StudentDetails(resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3));
            }else {
                return null;
            }
    }

    @Override
    public boolean save(StudentDetails studentDetails) throws Exception {
        return false;
    }

    @Override
    public boolean update(StudentDetails studentDetails) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return CrudUtil.execute("DELETE FROM registration WHERE Student_Id=?",s);
    }

    @Override
    public StudentDetails get(String s) throws Exception {
        return null;
    }

    @Override
    public List<StudentDetails> getAll() throws Exception {
        return null;
    }
}
