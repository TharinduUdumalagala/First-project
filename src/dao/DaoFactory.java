package dao;

import dao.custom.impl.*;

public class    DaoFactory {
    private static DaoFactory daoFactory;

    private  DaoFactory(){
    }

    public static DaoFactory getInstance(){
        return (daoFactory == null) ? (daoFactory = new DaoFactory()) :(daoFactory);
    }

    public enum DAOType{
         SUBJECT,TEACHER,ATTENDANCE,QUERY,STUDENTDETAILS,GRADE,STUDENT,PARENT,LOGIN
    }

    public <S> S getDao(DAOType type){
        switch (type){
            case SUBJECT:
                return (S) new SubjectDaoImpl();
            case TEACHER:
                return (S) new TeacherDaoImpl();
            case ATTENDANCE:
                return (S) new AttendanceDaoImpl();
            case QUERY:
                return (S) new QueryDaoImpl();
            case STUDENTDETAILS:
                return (S) new StuedntDetailsDaoIml();
            case GRADE:
                return (S) new GradeDaoImpl();
            case STUDENT:
                return (S) new StudentDaoImpl();
            case PARENT:
                return (S) new ParentDaoImpl();
            case LOGIN:
                return (S) new LoginDaoImpl();
            default:
                return null;

        }
    }
}
