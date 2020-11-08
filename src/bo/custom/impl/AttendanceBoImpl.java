package bo.custom.impl;

import bo.custom.AttendanceBo;
import dao.DaoFactory;
import dao.custom.AttendanceDao;
import dao.custom.StudentDetailsDao;
import dao.custom.SubjectDao;
import dto.AttendanceDTO;
import dto.StudentDTO;
import dto.SubjectDTO;
import entity.Attendance;
import entity.Student;
import entity.StudentDetails;
import entity.Subject;
import view.tm.SubjectTM;

import java.util.ArrayList;
import java.util.List;

public class  AttendanceBoImpl implements AttendanceBo {

    private AttendanceDao attendanceDao = DaoFactory.getInstance().getDao(DaoFactory.DAOType.ATTENDANCE);
    private StudentDetailsDao studentDetailsDao = DaoFactory.getInstance().getDao(DaoFactory.DAOType.STUDENTDETAILS);
    private SubjectDao subjectDao = DaoFactory.getInstance().getDao(DaoFactory.DAOType.SUBJECT);

    @Override
    public boolean attend(AttendanceDTO attendanceDTO) throws Exception {

        int id = subjectDao.getId(attendanceDTO.getSubject());
        StudentDetails studentDetails = new StudentDetails();
        studentDetails.setStudentId(attendanceDTO.getStudentId());
        studentDetails.setSubId(id);
        StudentDetails studentDetail = studentDetailsDao.getStudentId(studentDetails);
        if (studentDetail != null){
            Attendance attendance = new Attendance(
                    0,
                    attendanceDTO.getDate(),
                    "Attend",
                    studentDetail.getStudentDetailsId()
            );
            return attendanceDao.attend(attendance);
        }
        return false;
    }
}

