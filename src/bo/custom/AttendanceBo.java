package bo.custom;

import dto.AttendanceDTO;
import dto.StudentDTO;

import java.util.ArrayList;
import java.util.List;

public interface AttendanceBo {
    public boolean attend(AttendanceDTO attendanceDTO)throws Exception;

}
