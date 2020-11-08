package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.StudentDao;
import entity.Student;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public boolean save(Student student) throws Exception {
        return CrudUtil.execute("INSERT INTO Student VALUES(?,?,?,?,?,?,?,?)",
                student.getDate(),
                student.getStudentId(),
                student.getStudentName(),
                student.getAddress(),
                student.getDob(),
                student.getGender(),
                student.getGradeId(),
                student.getParentId());

    }

    @Override
    public boolean update(Student student) throws Exception {
        return CrudUtil.execute("UPDATE Student SET Student_Name=?,Address=?,DOB=?,Gender=?,Grade_Id,Parent_Id WHERE Student_Id=?",
                student.getDate(),
                student.getStudentId(),
                student.getStudentName(),
                student.getAddress(),
                student.getDob(),
                student.getGender(),
                student.getGradeId(),
                student.getParentId());

    }
    @Override
    public boolean delete(Integer Student_Id) throws Exception {
        return CrudUtil.execute("DELETE FROM Student WHERE Student_Id=?", Student_Id.intValue());
    }

    @Override
    public Student get(Integer Student_Id) throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Student WHERE Student_Id= ?", Student_Id.intValue());
        if (resultSet.next()) {
            return new Student(
                    resultSet.getString(1),
                    resultSet.getInt(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getInt(7),
                    resultSet.getInt(8));
        } else {
            return null;
        }
    }

    @Override
    public List<Student> getAll() throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM Student");
        ArrayList<Student> StudentList = new ArrayList<>();
        while (resultSet.next()) {
            StudentList.add(
                    new Student(
                            resultSet.getString(1),
                            resultSet.getInt(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getInt(7),
                            resultSet.getInt(8)));
        }
        return StudentList;
    }

    @Override
    public int getNextId() throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT Student_Id FROM student ORDER BY Student_Id DESC LIMIT 1");
        int id = 1;
        if (resultSet.next()) {
            id = resultSet.getInt(1);
            id++;
            return id;
        }
        return id;
    }

    @Override
    public int getCount() throws Exception {
        int count = 0;
        ResultSet resultSet = CrudUtil.execute("SELECT COUNT(Student_Id) from student");
        if (resultSet.next()) {
            count = resultSet.getInt(1);
        }
        return count;
    }


    @Override
    public int getParentId(int student_Id) throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT Parent_Id FROM student WHERE Student_Id=?",student_Id);
        if (resultSet.next()){
            int parentID = resultSet.getInt(1);
            return parentID;
        }
        return 0;
    }

    @Override
    public List<Student> checkStudent() throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM student WHERE Parent_Id");
        ArrayList<Student> studentList = new ArrayList<>();
        while (resultSet.next()){
            studentList.add(new Student(
                    resultSet.getString(1),
                    resultSet.getInt(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getInt(7),
                    resultSet.getInt(8)));
        }
        return studentList;
    }
}
