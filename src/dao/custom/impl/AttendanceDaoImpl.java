package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.AttendanceDao;
import entity.Attendance;
import entity.StudentDetails;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AttendanceDaoImpl implements AttendanceDao {

    @Override
    public boolean save(Attendance attendance) throws Exception {
        return false;
    }

    @Override
    public boolean update(Attendance attendance) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public Attendance get(String s) throws Exception {
        return null;
    }

    @Override
    public List<Attendance> getAll() throws Exception {
        return null;
    }

    @Override
    public boolean attend(Attendance attendance) throws Exception {
        return CrudUtil.execute("INSERT INTO attendance VALUES(?,?,?,?)",
                attendance.getAttendanceId(),
                attendance.getDate(),
                attendance.getAttend(),
                attendance.getStudentDetailsId());
    }
}
