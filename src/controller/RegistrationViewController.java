package controller;

import bo.BoFactory;
import bo.custom.*;
import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import dto.GradeDTO;
import dto.RegistrationDTO;
import dto.StudentDTO;
import dto.SubjectDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import view.tm.StudentTM;
import view.tm.SubjectTM;

import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Pattern;


public class RegistrationViewController implements Initializable {

    public JFXTextField txtStudentId;
    public JFXTextField txtFullName;
    public JFXTextField txtAddress;
    public JFXTextField txtParentId;
    public JFXTextField txtParentName;
    public JFXTextField txtPhoneNo1;
    public ComboBox cmbGrade;
    public Button btnRegister;
    public TableView<StudentTM> tblStudent;
    public TableColumn colStudentId;
    public TableColumn colFullName;
    public TableColumn colAddress;
    public TableColumn colDob;
    public TableColumn colGender;
    public TableColumn colOperate;
    public TableView tblSub;
    public AnchorPane root1;
    public Button btnUpdate;
    public JFXTextField txtSearch;
    public DatePicker dateDate;
    public ComboBox cmbSubject;
    public RadioButton rbtMale;
    public RadioButton rbtFemale;
    public TableColumn colSubId;
    public TableColumn colSubOperate;
    RegistrationBo bo;

    ObservableList<String> subjectList = FXCollections.observableArrayList();
    ObservableList<String> gradeList = FXCollections.observableArrayList();

    SubjectBo subjectBo = BoFactory.getInstance().getBo(BoFactory.BOType.SUBJECT);
    GradeBo gradeBo = BoFactory.getInstance().getBo(BoFactory.BOType.GRADE);
    ParentBo parentBo = BoFactory.getInstance().getBo(BoFactory.BOType.PARENT);
    StudentBo studentBo = BoFactory.getInstance().getBo(BoFactory.BOType.STUDENT);


    public void initialize(URL location, ResourceBundle resources) {

        try {
            bo = BoFactory.getInstance().getBo(BoFactory.BOType.REGISTRATION);

            colStudentId.setCellValueFactory(new PropertyValueFactory("studentId"));
            colFullName.setCellValueFactory(new PropertyValueFactory("fullName"));
            colAddress.setCellValueFactory(new PropertyValueFactory("address"));
            colDob.setCellValueFactory(new PropertyValueFactory("dob"));
            colGender.setCellValueFactory(new PropertyValueFactory("gender"));
            colOperate.setCellValueFactory(new PropertyValueFactory("btn"));
            colSubId.setCellValueFactory(new PropertyValueFactory("subjectName"));
            colSubOperate.setCellValueFactory(new PropertyValueFactory("btn"));


            loadAllStudent();

            tblStudent.getSelectionModel().selectedItemProperty().
                    addListener((observable, oldValue, newValue) -> {
                        setData(newValue);
                    });

            txtStudentId.setText(studentBo.getNextId() + "");
            txtParentId.setText(parentBo.getNextId() + "");


            ArrayList<SubjectDTO> all = null;
            all = subjectBo.getAll();
            for (SubjectDTO dto : all) {
                subjectList.add(dto.getSubName());
            }

            cmbSubject.setItems(subjectList);

            ArrayList<GradeDTO> all1 = null;
            all1 = gradeBo.getAll();
            for (GradeDTO dto : all1) {
                gradeList.add(dto.getGradeName());
            }

            cmbGrade.setItems(gradeList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setData(StudentTM tm) {
        txtStudentId.setText(String.valueOf(tm.getStudentId()));
        txtFullName.setText(tm.getFullName());
        txtAddress.setText(tm.getAddress());
        dateDate.setValue(LocalDate.parse(tm.getDob()));
        getGender();
    }

    private void loadAllStudent() {
        try {
            ObservableList<StudentTM> tmList = FXCollections.observableArrayList();
            tmList.clear();
            List<StudentDTO> allStudent = bo.getAll();

            if (allStudent != null) {
                for (StudentDTO dto : allStudent) {

                    Button btn = new Button("Delete");
                    StudentTM tm = new StudentTM(dto.getStudentId(), dto.getFullName(), dto.getAddress(), dto.getDob(), getGender(), btn);
                    tmList.add(tm);
                    btn.setOnAction((e) -> {
                        ButtonType ok = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
                        ButtonType no = new ButtonType("NO", ButtonBar.ButtonData.CANCEL_CLOSE);

                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure", ok, no);
                        Optional<ButtonType> result = alert.showAndWait();
                        if (result.orElse(no) == ok) {
                            try {
                                if (bo.delete(String.valueOf(tm.getStudentId()))) {
                                    new Alert(Alert.AlertType.CONFIRMATION, "Delete", ButtonType.OK).show();
                                    loadAllStudent();
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
                tblStudent.setItems(tmList);
                tblStudent.refresh();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void RegisterStudent(ActionEvent actionEvent) throws Exception {
        if (Pattern.compile("^(A-z){1}$").matcher(txtFullName.getText()).matches()) {
            if (Pattern.compile("^(A-z)[1-9]{1}$").matcher(txtAddress.getText()).matches()) {
                if (Pattern.compile("^(A-z){1}$").matcher(txtParentName.getText()).matches()) {
                    if (Pattern.compile("^[1-9]{1}$").matcher(txtPhoneNo1.getText()).matches()) {

                    }else {
                        txtPhoneNo1.setFocusColor(Paint.valueOf("red"));
                        txtPhoneNo1.requestFocus();
                    }
                }else {
                    txtParentName.setFocusColor(Paint.valueOf("red"));
                    txtParentName.requestFocus();
                }
            }else {
                txtAddress.setFocusColor(Paint.valueOf("red"));
                txtAddress.requestFocus();
            }
        }else {
            txtFullName.setFocusColor(Paint.valueOf("red"));
            txtFullName.requestFocus();
        }

            int gradeId = gradeBo.getId(cmbGrade.getValue().toString());

            ObservableList<SubjectTM> items = tblSub.getItems();
            List<Integer> selectedSubject = new ArrayList<>();
            for (SubjectTM subjectTM : items) {
                int id = subjectBo.getId(subjectTM.getSubjectName());
                selectedSubject.add(id);
            }

            boolean isSaved = bo.Save(new RegistrationDTO(
                    LocalDate.now().toString(),
                    Integer.parseInt(txtStudentId.getText()),
                    txtFullName.getText(),
                    txtAddress.getText(),
                    dateDate.getValue().toString(),
                    getGender(),
                    Integer.parseInt(txtParentId.getText()),
                    txtParentName.getText(),
                    txtPhoneNo1.getText(),
                    gradeId,
                    selectedSubject));

            if (isSaved) {
                new Alert(Alert.AlertType.INFORMATION, "Registration Successful", ButtonType.OK).show();
                loadAllStudent();
                Clear();
            } else {
                new Alert(Alert.AlertType.INFORMATION, "Registration Failed", ButtonType.OK).show();
            }

        }

        public void UpdateStudent (ActionEvent actionEvent) throws Exception {
            int gradeId = gradeBo.getId(cmbGrade.getValue().toString());
            ObservableList<SubjectTM> items = tblSub.getItems();
            List<Integer> selectedSubject = new ArrayList<>();
            for (SubjectTM subjectTM : items) {
                int id = subjectBo.getId(subjectTM.getSubjectName());
                selectedSubject.add(id);
            }
            boolean iaUpdate = false;
            bo.Update(new RegistrationDTO(LocalDate.now().toString(),
                    Integer.parseInt(txtStudentId.getText()),
                    txtFullName.getText(),
                    txtAddress.getText(),
                    dateDate.getValue().toString(),
                    getGender(),
                    Integer.parseInt(txtParentId.getText()),
                    txtParentName.getText(),
                    txtPhoneNo1.getText(),
                    gradeId,
                    selectedSubject));

            if (iaUpdate) {
                new Alert(Alert.AlertType.INFORMATION, "Update Successful", ButtonType.OK).show();
                Clear();
            } else {
                new Alert(Alert.AlertType.INFORMATION, "Update Failed", ButtonType.OK).show();
            }
        }

        public void GetDataStudent (ActionEvent actionEvent){
            try {
                RegistrationDTO dto = null;

                dto = bo.getRegistration(txtSearch.getText());

                if (dto != null) {
                    txtStudentId.setText(String.valueOf(dto.getStudentId()));
                    txtFullName.setText(dto.getFullName());
                    txtAddress.setText(dto.getAddress());
                    dateDate.setValue(LocalDate.parse(dto.getDob()));
                    getGender();
                    txtParentId.setText(String.valueOf(dto.getParentId()));
                    txtParentName.setText(dto.getParentName());
                    txtPhoneNo1.setText(dto.getPhoneNo());
                    cmbGrade.setValue(dto.getGradeId());
                    cmbSubject.setValue(String.valueOf(dto.getSubId()));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            Clear();
        }

        public String getGender () {
            if (rbtMale.isSelected()) {
                return "Male";
            } else if (rbtFemale.isSelected()) {
                return "Female";
            }
            return null;
        }

        private void Clear () {
            try {
                txtStudentId.setText("");
                txtFullName.setText("");
                txtAddress.setText("");
                dateDate.setValue(null);
                txtParentId.setText("");
                txtParentName.setText("");
                txtPhoneNo1.setText("");
                txtStudentId.setText(studentBo.getNextId() + "");
                txtParentId.setText(parentBo.getNextId() + "");
                tblSub.getItems().clear();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        ObservableList<SubjectTM> subList = FXCollections.observableArrayList();

        public void addSubject (ActionEvent actionEvent){

            String s = cmbSubject.getValue().toString();
            SubjectTM subjectTM = new SubjectTM();
            Button btn = new Button("Delete");
            subjectTM.setSubjectName(s);
            subjectTM.setBtn(btn);
            subList.add(subjectTM);
            btn.setOnAction((e) -> {

                ButtonType ok = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
                ButtonType no = new ButtonType("NO", ButtonBar.ButtonData.CANCEL_CLOSE);

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure", ok, no);

                Optional<ButtonType> result = alert.showAndWait();
                if (result.orElse(no) == ok) {
                    String subjectName = subjectTM.getSubjectName();

//                    tblSub.getItems().remove(focusedIndex);
//                    Object o = tblSub.getItems().get(selectedItems);
                    System.out.println(subjectName);
                }
            });
            tblSub.setItems(subList);
        }

    public void Report(ActionEvent actionEvent) {
        try {
            InputStream is=this.getClass().getResourceAsStream("/reports/StudentDetail.jasper");
            JasperPrint jp= JasperFillManager.fillReport(is,null, DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jp,false);
        } catch (JRException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
