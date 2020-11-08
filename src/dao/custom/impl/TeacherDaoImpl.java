package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.TeacherDao;
import entity.Teacher;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TeacherDaoImpl implements TeacherDao {

    @Override
    public boolean save(Teacher teacher) throws Exception {
        Object execute = CrudUtil.execute("INSERT INTO teacher VALUES(?,?,?,?,?)",
                teacher.getTeacherId(),
                teacher.getTeacherName(),
                teacher.getPhoneNo(),
                teacher.getSubId(),
                teacher.getGradeId());
        return (boolean) execute;
    }

    @Override
    public boolean update(Teacher teacher) throws Exception {
        Object execute = CrudUtil.execute("UPDATE Teacher SET Teacher_Name=?,Phone_No=?,Sub_Id=?,Grade_Id=? WHERE Teacher_Id=?",
                teacher.getTeacherName(),
                teacher.getPhoneNo(),
                teacher.getSubId(),
                teacher.getGradeId(),
                teacher.getTeacherId());
        return (boolean) execute;
    }

    @Override
    public boolean delete(String teacherId) throws Exception {
        Object execute = CrudUtil.execute("DELETE FROM Teacher WHERE Teacher_Id=?", teacherId);
        return (boolean) execute;
    }

    @Override
    public Teacher get(String teacherId) throws Exception {
        ResultSet resultSet =CrudUtil.execute("SELECT * FROM Teacher WHERE id=?",teacherId);
        if (resultSet.next()){
            Teacher teacher = new Teacher(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4),
                    resultSet.getInt(5));
            return teacher;
        }
        return null;
    }

    @Override
    public List<Teacher> getAll() throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Teacher");
        ArrayList<Teacher> teacherList =new ArrayList<>();
        while (resultSet.next()){
            teacherList.add(
                    new Teacher(resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getInt(4),
                            resultSet.getInt(5)));
        }
        return teacherList;
    }

    @Override
    public int getCount() throws Exception {
        int count = 0;
        ResultSet resultSet = CrudUtil.execute("SELECT COUNT(Teacher_Id) from Teacher");
        if (resultSet.next()){
            count = resultSet.getInt(1);
        }
        return count;
    }

    @Override
    public int getNextId() throws Exception {
        ResultSet set = CrudUtil.execute("SELECT Teacher_Id FROM teacher ORDER BY Teacher_Id DESC LIMIT 1");
        int id = 1;
        if (set.next()) {
            id = set.getInt(1);
            id++;
            return id;
        }
        return id;

    }

}
