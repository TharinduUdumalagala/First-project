package view.tm;


import javafx.scene.control.Button;

public class SubjectTM {
    private int subjectId;
    private String subjectName;
    private String subjectDiscription;
    private Button btn;

    public SubjectTM() {
    }

    public SubjectTM(int subjectId, String subjectName, String subjectDiscription, Button btn) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.subjectDiscription = subjectDiscription;
        this.btn = btn;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectDiscription() {
        return subjectDiscription;
    }

    public void setSubjectDiscription(String subjectDiscription) {
        this.subjectDiscription = subjectDiscription;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }

    @Override
    public String toString() {
        return "SubjectTM{" +
                "subjectId=" + subjectId +
                ", subjectName='" + subjectName + '\'' +
                ", subjectDiscription='" + subjectDiscription + '\'' +
                ", btn=" + btn +
                '}';
    }
}
