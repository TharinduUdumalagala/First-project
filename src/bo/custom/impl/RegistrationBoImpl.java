package bo.custom.impl;

import bo.custom.RegistrationBo;
import dao.DaoFactory;
import dao.custom.ParentDao;
import dao.custom.StudentDetailsDao;
import dao.custom.StudentDao;
import db.DBConnection;
import dto.RegistrationDTO;

import dto.StudentDTO;
import entity.Parent;
import entity.Student;
import entity.StudentDetails;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class RegistrationBoImpl implements RegistrationBo {

    private StudentDetailsDao studentDetailsDao = DaoFactory.getInstance().getDao(DaoFactory.DAOType.STUDENTDETAILS);
    private ParentDao parentDao = DaoFactory.getInstance().getDao(DaoFactory.DAOType.PARENT);
    private StudentDao studentDao = DaoFactory.getInstance().getDao(DaoFactory.DAOType.STUDENT);
    private Connection connection = null;

    @Override
    public boolean Save(RegistrationDTO registrationDTO) throws Exception {

        connection = DBConnection.getInstance().getConnection();

        try {
            connection.setAutoCommit(false);
            Parent parent = new Parent(registrationDTO.getParentId(),
                    registrationDTO.getParentName(),
                    registrationDTO.getPhoneNo());
            boolean save = parentDao.save(parent);

            if (save) {
                Student student = new Student(registrationDTO.getDate(),
                        registrationDTO.getStudentId(),
                        registrationDTO.getFullName(),
                        registrationDTO.getAddress(),
                        registrationDTO.getDob(),
                        registrationDTO.getGender(),
                        registrationDTO.getGradeId(),
                        registrationDTO.getParentId());
                boolean saveStudent = studentDao.save(student);

                if (saveStudent) {
                    for (int subId : registrationDTO.getSubId()) {
                        StudentDetails studentDetails = new StudentDetails(
                                0,
                                registrationDTO.getStudentId(),
                                subId
                        );
                        boolean saveSubject = studentDetailsDao.save(studentDetails);
                    }
                    if (saveStudent) {
                        connection.commit();
                        return true;
                    }
                }
            } else {
                connection.rollback();
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        connection.setAutoCommit(true);
        return true;
    }

    @Override
    public boolean Update(RegistrationDTO registrationDTO) throws Exception {

        Connection connection = DBConnection.getInstance().getConnection();

        try {
            connection.setAutoCommit(false);
            Parent parent = new Parent(registrationDTO.getParentId(),
                    registrationDTO.getParentName(),
                    registrationDTO.getPhoneNo());
            boolean update = parentDao.update(parent);

            if (update) {
                Student student = new Student(registrationDTO.getDate(),
                        registrationDTO.getStudentId(),
                        registrationDTO.getFullName(),
                        registrationDTO.getAddress(),
                        registrationDTO.getDob(),
                        registrationDTO.getGender(),
                        registrationDTO.getParentId(),
                        registrationDTO.getGradeId());
                boolean updateStudent = studentDao.update(student);

                if (updateStudent) {
                    for (int subId : registrationDTO.getSubId()) {
                        StudentDetails studentDetails = new StudentDetails(
                                0,
                                registrationDTO.getStudentId(),
                                subId
                        );
                        boolean updateSubject = studentDetailsDao.update(studentDetails);
                    }
                    if (updateStudent) {
                        connection.commit();
                        return true;
                    }
                }
            } else {
                connection.rollback();
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        connection.setAutoCommit(true);
        return true;
    }

    @Override
    public boolean delete(String studentId) throws Exception {

        Connection connection = DBConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);
            int parentId = studentDao.getParentId(Integer.parseInt(studentId));
            if (parentId != 0){
                List<Student> students = studentDao.checkStudent();
                if (students.size() == 1){
                    parentDao.delete(parentId+"");
                }
                boolean deleteStudent = studentDao.delete(Integer.valueOf(studentId));
                if (deleteStudent){
                    boolean deleteStudentDetails = studentDetailsDao.delete(studentId);
                    if (deleteStudentDetails){
                        connection.commit();
                        return true;
                    }
                }else {
                    connection.rollback();
                    return false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            connection.setAutoCommit(true);
            return true;
        }
    }

    @Override
    public RegistrationDTO getRegistration(String studentId) throws Exception {
        StudentDetails studentDetails = studentDetailsDao.get(studentId);
        return new RegistrationDTO();
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
