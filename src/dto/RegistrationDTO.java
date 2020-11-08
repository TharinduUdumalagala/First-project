package dto;

import java.util.Date;
import java.util.List;

public class RegistrationDTO {
    private String date;
    private int studentId;
    private String fullName;
    private String address;
    private String dob;
    private String gender;
    private int parentId;
    private String parentName;
    private String phoneNo;
    private int gradeId;
    private List<Integer> subId;

    public RegistrationDTO() {
    }

    public RegistrationDTO(String date, int studentId, String fullName, String address, String dob, String gender, int parentId, String parentName, String phoneNo, int gradeId, List<Integer> subId) {
        this.date = date;
        this.studentId = studentId;
        this.fullName = fullName;
        this.address = address;
        this.dob = dob;
        this.gender = gender;
        this.parentId = parentId;
        this.parentName = parentName;
        this.phoneNo = phoneNo;
        this.gradeId = gradeId;
        this.subId = subId;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public int getGradeId() {
        return gradeId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }

    public List<Integer> getSubId() {
        return subId;
    }

    public void setSubId(List<Integer> subId) {
        this.subId = subId;
    }

    @Override
    public String toString() {
        return "RegistrationDTO{" +
                "date='" + date + '\'' +
                ", studentId=" + studentId +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", dob=" + dob +
                ", gender='" + gender + '\'' +
                ", parentId=" + parentId +
                ", parentName='" + parentName + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", gradeId=" + gradeId +
                ", subId=" + subId +
                '}';
    }
}
