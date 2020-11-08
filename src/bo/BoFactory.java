package bo;

import bo.custom.impl.*;
import dto.AttendanceDTO;

public class BoFactory{
    private static BoFactory boFactory;

    private BoFactory(){
    }

    public static BoFactory getInstance(){
        return (boFactory == null) ? (boFactory = new BoFactory()) : (boFactory);
    }

    public enum BOType{
        SUBJECT,TEACHER,ATTENDANCE,REGISTRATION,GRADE,STUDENT,PARENT,LOGIN
    }

    public <S> S getBo(BOType type){
        switch (type){
            case SUBJECT:
                return (S) new SubjectBoImpl();
            case TEACHER:
                return (S) new TeacherBOImpl();
            case ATTENDANCE:
                return (S) new AttendanceBoImpl();
            case REGISTRATION:
                return (S) new RegistrationBoImpl();
            case GRADE:
                return (S) new GradeBoImpl();
            case STUDENT:
                return (S) new StudentBoImpl();
            case PARENT:
                return (S) new ParentBoImpl();
            case LOGIN:
                return (S) new LoginBoImpl();
            default:
                return null;
        }
    }
}
