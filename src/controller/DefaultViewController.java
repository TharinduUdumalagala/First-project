package controller;

import bo.BoFactory;
import bo.custom.StudentBo;
import bo.custom.SubjectBo;
import bo.custom.TeacherBo;
import javafx.scene.control.Label;

public class DefaultViewController {
    public Label lblStudentCount;
    public Label lblTeacherCount;
    public Label lblSubjectCount;

    TeacherBo teacherBo = BoFactory.getInstance().getBo(BoFactory.BOType.TEACHER);
    SubjectBo subjectBo = BoFactory.getInstance().getBo(BoFactory.BOType.SUBJECT);
    StudentBo studentBo = BoFactory.getInstance().getBo(BoFactory.BOType.STUDENT);

    public void initialize() {
        try {
            lblTeacherCount.setText(String.valueOf(teacherBo.getCount()));
            lblSubjectCount.setText(String.valueOf(subjectBo.getCount()));
            lblStudentCount.setText(String.valueOf(studentBo.getCount()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
