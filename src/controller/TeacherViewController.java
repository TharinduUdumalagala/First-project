package controller;

import bo.BoFactory;
import bo.custom.GradeBo;
import bo.custom.SubjectBo;
import bo.custom.TeacherBo;
import com.jfoenix.controls.JFXTextField;
import dto.GradeDTO;
import dto.SubjectDTO;
import dto.TeacherDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Paint;
import view.tm.TeacherTM;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.concurrent.Callable;
import java.util.regex.Pattern;

public class TeacherViewController implements Initializable {
    public JFXTextField txtTeacherId;
    public JFXTextField txtTeacherName;
    public JFXTextField txtPhoneNo;
    public ComboBox cmbGrade;
    public Button btnSave;
    public TableView<TeacherTM> tblTeacher;
    public TableColumn colTeacherId;
    public TableColumn colTeacherName;
    public TableColumn colPhoneNo;
    public TableColumn colSubject;
    public TableColumn colGrade;
    public Button btnClear;
    public JFXTextField txtSearch;
    public TableColumn colOperate;
    public ComboBox<String> cmbSubject;
    TeacherBo bo;

    ObservableList<String> subjectList = FXCollections.observableArrayList();
    ObservableList<String> gradeList = FXCollections.observableArrayList();
    SubjectBo subjectBo = BoFactory.getInstance().getBo(BoFactory.BOType.SUBJECT);
    GradeBo gradeBo = BoFactory.getInstance().getBo(BoFactory.BOType.GRADE);

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            bo = BoFactory.getInstance().getBo(BoFactory.BOType.TEACHER);

            colTeacherId.setCellValueFactory(new PropertyValueFactory("teacherId"));
            colTeacherName.setCellValueFactory(new PropertyValueFactory("teacherName"));
            colPhoneNo.setCellValueFactory(new PropertyValueFactory("phoneNo"));
            colSubject.setCellValueFactory(new PropertyValueFactory("subject"));
            colGrade.setCellValueFactory(new PropertyValueFactory("grade"));
            colOperate.setCellValueFactory(new PropertyValueFactory("btn"));

            loadAllTeacher();

            tblTeacher.getSelectionModel().selectedItemProperty().
                    addListener(((observable, oldValue, newValue) -> {
                        setData(newValue);
                    }));

            int nextId = bo.getNextId();
            txtTeacherId.setText(nextId + "");

            ArrayList<SubjectDTO> all = subjectBo.getAll();
            for (SubjectDTO dto : all) {
                subjectList.add(dto.getSubName());
            }
            cmbSubject.setItems(subjectList);

            ArrayList<GradeDTO> all1 = gradeBo.getAll();
            for (GradeDTO dto : all1) {
                gradeList.add(dto.getGradeName());
            }
            cmbGrade.setItems(gradeList);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setData(TeacherTM tm) {
        txtTeacherId.setText(String.valueOf(tm.getTeacherId()));
        txtTeacherName.setText(tm.getTeacherName());
        txtPhoneNo.setText(tm.getPhoneNo());
        cmbSubject.setValue(String.valueOf(tm.getSubject()));
        cmbGrade.setValue(tm.getGrade() + "");
    }

    private void loadAllTeacher() {
        ObservableList<TeacherTM> tmList = FXCollections.observableArrayList();
        tmList.clear();
        List<TeacherDTO> allTeacher = null;

        try {
            allTeacher = bo.getAll();

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (allTeacher != null) {
            for (TeacherDTO dto : allTeacher) {

                Button btn = new Button("Delete");
                TeacherTM tm = new TeacherTM(dto.getTeacherId(), dto.getTeacherName(), dto.getPhoneNo(), Integer.parseInt(String.valueOf(dto.getSubId())), Integer.parseInt(String.valueOf(dto.getGradeId())), btn);
                tmList.add(tm);
                btn.setOnAction((e) -> {
                    ButtonType ok = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
                    ButtonType no = new ButtonType("NO", ButtonBar.ButtonData.CANCEL_CLOSE);

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure", ok, no);
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.orElse(no) == ok) {
                        try {
                            if (bo.delete(String.valueOf(tm.getTeacherId()))) {
                                new Alert(Alert.AlertType.CONFIRMATION, "Delete", ButtonType.OK).show();
                                loadAllTeacher();
                                txtTeacherId.setText(bo.getNextId() + "");
                                return;
                            } else {
                                new Alert(Alert.AlertType.WARNING, "Try Again", ButtonType.OK).show();
                            }
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    }
                });

            }
            tblTeacher.setItems(tmList);
            tblTeacher.refresh();
        }
    }

    public void SaveTeacher(ActionEvent actionEvent) throws Exception {
        if (Pattern.compile("^(A-z){1}$").matcher(txtTeacherName.getText()).matches()) {
            if (Pattern.compile("^(1-9){1}$").matcher(txtPhoneNo.getText()).matches()) {
            }else {
                txtTeacherName.setFocusColor(Paint.valueOf("red"));
                txtTeacherName.requestFocus();
            }
        }else {
            txtPhoneNo.setFocusColor(Paint.valueOf("red"));
            txtPhoneNo.requestFocus();
        }
        int subId = subjectBo.getId(cmbSubject.getValue());
        int gradeId = gradeBo.getId(cmbGrade.getValue().toString());

        boolean isSaved = bo.Save(
                new TeacherDTO(Integer.parseInt(txtTeacherId.getText()),
                        txtTeacherName.getText(),
                        txtPhoneNo.getText(),
                        subId,
                        gradeId)
        );
        if (isSaved) {

            new Alert(Alert.AlertType.INFORMATION, "Added Successful", ButtonType.OK).show();
            Clear();
            loadAllTeacher();
            txtTeacherId.setText(bo.getNextId() + "");
        } else {
            new Alert(Alert.AlertType.INFORMATION, "Added Failed", ButtonType.OK).show();
        }
    }

    public void UpdateTeacher(ActionEvent actionEvent) throws Exception {
        boolean isUpdate = bo.Update(
                new TeacherDTO(Integer.parseInt(txtTeacherId.getText()),
                        txtTeacherName.getText(),
                        txtPhoneNo.getText(),
                        Integer.parseInt(cmbSubject.getValue().toString()),
                        Integer.parseInt(cmbGrade.getValue().toString())));

        if (isUpdate) {

            loadAllTeacher();
            new Alert(Alert.AlertType.CONFIRMATION, "Update Successfully", ButtonType.OK).show();
            Clear();
            loadAllTeacher();
        } else {
            new Alert(Alert.AlertType.CONFIRMATION, "Update Fail", ButtonType.OK).show();
        }
    }

    public void GetDataTeacher(ActionEvent actionEvent) {
        TeacherDTO dto = null;
        try {

            dto = bo.getTeacher(txtSearch.getText());

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (dto != null) {
            txtTeacherId.setText(String.valueOf(dto.getTeacherId()));
            txtTeacherName.setText(dto.getTeacherName());
            txtPhoneNo.setText(dto.getPhoneNo());
            cmbSubject.setValue(String.valueOf(dto.getSubId()));
            cmbGrade.setValue(dto.getGradeId());
        }
        Clear();
    }

    private void Clear() {
        txtTeacherId.setText("");
        txtTeacherName.setText("");
        txtPhoneNo.setText("");
        cmbGrade.getSelectionModel().clearSelection();
        cmbGrade.getItems().clear();
        cmbSubject.getSelectionModel().clearSelection();
        cmbSubject.getItems().clear();
    }
}
