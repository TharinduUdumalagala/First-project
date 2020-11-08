package bo.custom.impl;

import bo.custom.StudentBo;
import dao.DaoFactory;
import dao.custom.StudentDao;
import dto.StudentDTO;
import entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentBoImpl implements StudentBo {

    StudentDao studentDao = DaoFactory.getInstance().getDao(DaoFactory.DAOType.STUDENT);

    @Override
    public int getNextId() throws Exception {
        return studentDao.getNextId();
    }

    @Override
    public int getCount() throws Exception {
        return studentDao.getCount();
    }

    @Override
    public List<StudentDTO> getAll() {
        try {
            List<Student> sList = null;

            sList = studentDao.getAll();

            ArrayList<StudentDTO> dtoList = new ArrayList();
            for (Student s : sList) {
                dtoList.add(new StudentDTO(s.getDate(),
                        s.getStudentId(),
                        s.getStudentName(),
                        s.getAddress(),
                        s.getDob(),
                        s.getGender()));

            }
            return dtoList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
