package entity;

public class StudentDetails implements SuperEntity {
    private int studentDetailsId;
    private int studentId;
    private int subId;

    public StudentDetails() {
    }

    public StudentDetails(int studentDetailsId, int studentId, int subId) {
        this.studentDetailsId = studentDetailsId;
        this.studentId = studentId;
        this.subId = subId;
    }

    public int getStudentDetailsId() {
        return studentDetailsId;
    }

    public void setStudentDetailsId(int studentDetailsId) {
        this.studentDetailsId = studentDetailsId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getSubId() {
        return subId;
    }

    public void setSubId(int subId) {
        this.subId = subId;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "studentDetailsId=" + studentDetailsId +
                ", studentId=" + studentId +
                ", subId=" + subId +
                '}';
    }
}


