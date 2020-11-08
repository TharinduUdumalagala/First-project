package dto;

public class AttendanceDTO {
    private int studentId;
    private String date;
    private String grade;
    private String subject;

    public AttendanceDTO() {
    }

    public AttendanceDTO(int studentId, String date, String grade, String subject) {
        this.studentId = studentId;
        this.date = date;
        this.grade = grade;
        this.subject = subject;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "AttendanceDTO{" +
                "studentId=" + studentId +
                ", date='" + date + '\'' +
                ", grade='" + grade + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
