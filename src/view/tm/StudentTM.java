package view.tm;

import javafx.scene.control.Button;

public class StudentTM {
    private int studentId;
    private String fullName;
    private String address;
    private String dob;
    private String gender;
    private Button btn;

    public StudentTM() {
    }

    public StudentTM(int studentId, String fullName, String address, String dob, String gender, Button btn) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.address = address;
        this.dob = dob;
        this.gender = gender;
        this.btn = btn;
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

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }

    @Override
    public String toString() {
        return "StudentTM{" +
                "studentId=" + studentId +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", dob='" + dob + '\'' +
                ", gender='" + gender + '\'' +
                ", btn=" + btn +
                '}';
    }
}
