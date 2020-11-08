package view.tm;

import javafx.scene.control.Button;

public class TeacherTM {
    private int teacherId;
    private String teacherName;
    private String phoneNo;
    private int subject;
    private int grade;
    private Button btn;

    public TeacherTM() {
    }

    public TeacherTM(int teacherId, String teacherName, String phoneNo, int subject, int grade, Button btn) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.phoneNo = phoneNo;
        this.subject = subject;
        this.grade = grade;
        this.btn = btn;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public int getSubject() {
        return subject;
    }

    public void setSubject(int subject) {
        this.subject = subject;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }

    @Override
    public String toString() {
        return "TeacherTM{" +
                "teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", subject=" + subject +
                ", grade=" + grade +
                ", btn=" + btn +
                '}';
    }
}
