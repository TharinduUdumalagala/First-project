package entity;

public class Student implements SuperEntity{
    private String date;
    private int studentId;
    private String studentName;
    private String address;
    private String dob;
    private String gender;
    private int gradeId;
    private int parentId;

    public Student() {
    }

    public Student(String date, int studentId, String studentName, String address, String dob, String gender, int gradeId, int parentId) {
        this.date = date;
        this.studentId = studentId;
        this.studentName = studentName;
        this.address = address;
        this.dob = dob;
        this.gender = gender;
        this.gradeId = gradeId;
        this.parentId = parentId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getGradeId() {
        return gradeId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "date='" + date + '\'' +
                ", studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", address='" + address + '\'' +
                ", dob='" + dob + '\'' +
                ", gender='" + gender + '\'' +
                ", gradeId=" + gradeId +
                ", parentId=" + parentId +
                '}';
    }
}
