package dao.custom;

import dao.CrudDao;
import entity.Attendance;
import entity.StudentDetails;

public interface AttendanceDao extends CrudDao<Attendance, String> {
    public boolean attend(Attendance attendance)throws Exception;
}
