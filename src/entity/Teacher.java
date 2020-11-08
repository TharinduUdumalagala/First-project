package entity;

public class Teacher implements SuperEntity {
    private int teacherId;
    private String teacherName;
    private String phoneNo;
    private int subId;
    private int gradeId;

    public Teacher() {
    }

    public Teacher(int teacherId, String teacherName, String phoneNo, int subId, int gradeId) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.phoneNo = phoneNo;
        this.subId = subId;
        this.gradeId = gradeId;
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

    public int getSubId() {
        return subId;
    }

    public void setSubId(int subId) {
        this.subId = subId;
    }

    public int getGradeId() {
        return gradeId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", subId=" + subId +
                ", gradeId=" + gradeId +
                '}';
    }
}
