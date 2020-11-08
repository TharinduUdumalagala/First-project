package bo.custom;

import dto.TeacherDTO;

import java.util.ArrayList;

public interface TeacherBo {
    public boolean Save(TeacherDTO teacherDTO)throws Exception;
    public  boolean Update(TeacherDTO teacherDTO)throws Exception;
    public boolean delete(String teacherId) throws Exception;
    public TeacherDTO getTeacher(String teacherId)throws Exception;
    public ArrayList<TeacherDTO> getAll()throws Exception;
    public  int getCount() throws Exception;
    public int getNextId() throws Exception;


}
