package bo.custom.impl;

import bo.custom.TeacherBo;
import dao.DaoFactory;
import dao.custom.TeacherDao;
import db.DBConnection;
import dto.TeacherDTO;
import entity.Teacher;

import java.util.ArrayList;
import java.util.List;

public class TeacherBOImpl implements TeacherBo {

    private TeacherDao teacherDao  = DaoFactory.getInstance().getDao(DaoFactory.DAOType.TEACHER);

    @Override
    public boolean Save(TeacherDTO teacherDTO) throws Exception {
        return teacherDao.save(new Teacher(teacherDTO.getTeacherId(),
                teacherDTO.getTeacherName(),
                teacherDTO.getPhoneNo(),
                teacherDTO.getSubId(),
                teacherDTO.getGradeId()));
    }

    @Override
    public boolean Update(TeacherDTO teacherDTO) throws Exception {
        return teacherDao.update(new Teacher(teacherDTO.getTeacherId(),
                teacherDTO.getTeacherName(),
                teacherDTO.getPhoneNo(),
                teacherDTO.getSubId(),
                teacherDTO.getGradeId()));
    }

    @Override
    public boolean delete(String TeacherId) throws Exception {
        return teacherDao.delete(TeacherId);
    }

    @Override
    public TeacherDTO getTeacher(String TeacherId) throws Exception {
        Teacher teacher = teacherDao.get(TeacherId);
        return new TeacherDTO(teacher.getTeacherId(),
                teacher.getTeacherName(),
                teacher.getPhoneNo(),
                teacher.getSubId(),
                teacher.getGradeId());
    }

    @Override
    public ArrayList<TeacherDTO> getAll() throws Exception {
        List<Teacher> sList = teacherDao.getAll();
        ArrayList<TeacherDTO> dtoList = new ArrayList();
        for (Teacher teacher : sList){
            dtoList.add(new TeacherDTO(teacher.getTeacherId(),
                    teacher.getTeacherName(),
                    teacher.getPhoneNo(),
                    teacher.getSubId(),
                    teacher.getGradeId()));
        }
        return dtoList;
    }

    @Override
    public int getCount() throws Exception {
        return teacherDao.getCount();
    }

    @Override
    public int getNextId() throws Exception {
        return teacherDao.getNextId();
    }

}
