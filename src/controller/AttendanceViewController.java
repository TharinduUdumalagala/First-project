package controller;

import bo.BoFactory;
import bo.custom.AttendanceBo;
import bo.custom.GradeBo;
import bo.custom.StudentBo;
import bo.custom.SubjectBo;
import com.jfoenix.controls.JFXTextField;
import dto.AttendanceDTO;
import dto.GradeDTO;
import dto.StudentDTO;
import dto.SubjectDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import view.tm.AttendanceTM;
import view.tm.StudentTM;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class AttendanceViewController implements Initializable {
    public TableView<AttendanceTM> tblAttendance;
    public TableColumn colOperate;
    public ComboBox<String> cmbGrade;
    public ComboBox<String> cmbSubject;
    public DatePicker dateDate;
    public TableColumn colStudentId;
    public TableColumn colStudentName;
    public JFXTextField txtStudentId;
    public TableColumn colAddress;
    public TableColumn colDOB;
    public TableColumn colGender;
    public JFXTextField txtName;

    private ObservableList<String> subjectList = FXCollections.observableArrayList();
    private ObservableList<String> gradeList = FXCollections.observableArrayList();
    private ObservableList<AttendanceTM> dataList = FXCollections.observableArrayList();
    private TableView<AttendanceTM> tableView = new TableView<AttendanceTM>();
    SubjectBo subjectBo = BoFactory.getInstance().getBo(BoFactory.BOType.SUBJECT);
    GradeBo gradeBo = BoFactory.getInstance().getBo(BoFactory.BOType.GRADE);
    StudentBo studentBo = BoFactory.getInstance().getBo(BoFactory.BOType.STUDENT);
    AttendanceBo attendanceBo = BoFactory.getInstance().getBo(BoFactory.BOType.ATTENDANCE);

    public void initialize(URL location, ResourceBundle resources) {
        try {
            colStudentId.setCellValueFactory(new PropertyValueFactory("studentId"));
            colStudentName.setCellValueFactory(new PropertyValueFactory("fullName"));
            colAddress.setCellValueFactory(new PropertyValueFactory("address"));
            colDOB.setCellValueFactory(new PropertyValueFactory("dob"));
            colGender.setCellValueFactory(new PropertyValueFactory("gender"));
            colOperate.setCellValueFactory(new PropertyValueFactory("btn"));

            loadAllStudent();


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

    private void loadAllStudent() {
        try{
        ObservableList<AttendanceTM> tmList = FXCollections.observableArrayList();
        tmList.clear();
        List<StudentDTO> allStudent = studentBo.getAll();

        if (allStudent != null) {
            for (StudentDTO dto : allStudent) {

                Button btn = new Button("Attend ");
                AttendanceTM attendanceTM = new AttendanceTM(dto.getStudentId(), dto.getFullName(), dto.getAddress(), dto.getDob(), dto.getGender(), btn);
                dataList.addAll(attendanceTM);
                tmList.add(attendanceTM);
                btn.setOnAction((e) -> {
                    ButtonType ok = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
                    ButtonType no = new ButtonType("NO", ButtonBar.ButtonData.CANCEL_CLOSE);

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure Attend", ok, no);
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.orElse(no) == ok) {
                        LocalDate date = dateDate.getValue();
                        String grade = cmbGrade.getValue();
                        String subject = cmbSubject.getValue();
                        int studentId = attendanceTM.getStudentId();
                        AttendanceDTO attendanceDTO = new AttendanceDTO(studentId, date.toString(), grade, subject);
                        try {
                            if (attendanceBo.attend(attendanceDTO)){
                                new Alert(Alert.AlertType.CONFIRMATION, "Attend", ButtonType.OK).show();
                                loadAllStudent();
                            }
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    }
                });
            }
            tblAttendance.setItems(tmList);
            tblAttendance.refresh();
        }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void sort(KeyEvent keyEvent) {
        dataList.addAll();
        FilteredList<AttendanceTM> filteredData = new FilteredList<>(dataList, b -> true);

        txtName.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(attendanceTM -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if (attendanceTM.getFullName().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
                    return true;
                } else if (attendanceTM.getStudentId()+"".toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                }
                else
                    return false;
            });
        });
        SortedList<AttendanceTM> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tblAttendance.comparatorProperty());
        tblAttendance.setItems(sortedData);
    }
}





