package controller;

import bo.BoFactory;
import bo.custom.SubjectBo;
import com.jfoenix.controls.JFXTextField;
import dto.SubjectDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Paint;
import view.tm.SubjectTM;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Pattern;


public class SubjectViewController implements Initializable {
    public JFXTextField txtSubjectId;
    public JFXTextField txtSubjectName;
    public TableView<SubjectTM> tblSubject;
    public TableColumn colSubjectId;
    public TableColumn colSubjectName;
    public TableColumn colOperate;
    public Button btnSave;
    public TableColumn colSubjectDiscription;
    public JFXTextField txtSubjectDiscription;
    public Button btnupdate;
    public JFXTextField txtSeach;
    SubjectBo bo;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            bo = BoFactory.getInstance().getBo(BoFactory.BOType.SUBJECT);

            colSubjectId.setCellValueFactory(new PropertyValueFactory("subjectId"));
            colSubjectName.setCellValueFactory(new PropertyValueFactory("subjectName"));
            colSubjectDiscription.setCellValueFactory(new PropertyValueFactory("subjectDiscription"));
            colOperate.setCellValueFactory(new PropertyValueFactory("btn"));


            loadAllSubject();


            tblSubject.getSelectionModel().selectedItemProperty().
                    addListener((observable, oldValue, newValue) -> {
                        setData(newValue);
                    });

            int nextId = bo.getNextId();
            txtSubjectId.setText(nextId + "");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void setData(SubjectTM tm) {
        txtSubjectId.setText(String.valueOf(tm.getSubjectId()));
        txtSubjectName.setText(tm.getSubjectName());
        txtSubjectDiscription.setText(tm.getSubjectDiscription() + "");
    }

    private void loadAllSubject() throws Exception {
        ObservableList<SubjectTM> tmList = FXCollections.observableArrayList();
        tmList.clear();
        List<SubjectDTO> allSubject = bo.getAll();
        if (allSubject != null) {
            for (SubjectDTO dto : allSubject) {

                Button btn = new Button("Delete");
                SubjectTM tm = new SubjectTM(dto.getSubId(), dto.getSubName(), dto.getSubDiscription(), btn);
                tmList.add(tm);
                btn.setOnAction((e) -> {

                    ButtonType ok = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                    ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure", ok, no);
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.orElse(no) == ok) {
                        try {
                            if (bo.delete(String.valueOf(tm.getSubjectId()))) {
                                new Alert(Alert.AlertType.CONFIRMATION, "Delete", ButtonType.OK).show();
                                loadAllSubject();
                                txtSubjectId.setText(bo.getNextId() + "");
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
            tblSubject.setItems(tmList);
            tblSubject.refresh();

        }
    }

    public void SaveSubject(ActionEvent actionEvent) throws Exception {
        if (Pattern.compile("^(A-z){1}$").matcher(txtSubjectName.getText()).matches()) {
            if (Pattern.compile("^(A-z){1}$").matcher(txtSubjectDiscription.getText()).matches()) {
            } else {
                txtSubjectDiscription.setFocusColor(Paint.valueOf("red"));
                txtSubjectDiscription.requestFocus();
            }
        } else {
            txtSubjectName.setFocusColor(Paint.valueOf("red"));
            txtSubjectName.requestFocus();
        }

    boolean isSaved = bo.Save(
            new SubjectDTO(Integer.parseInt(txtSubjectId.getText()),
                    txtSubjectName.getText(),
                    txtSubjectDiscription.getText()));
        if(isSaved)

    {
        new Alert(Alert.AlertType.INFORMATION, "Added Successful", ButtonType.OK).show();
        Clear();
        loadAllSubject();
        txtSubjectId.setText(bo.getNextId() + "");
    }
        else

    {
        new Alert(Alert.AlertType.INFORMATION, "Added Failed", ButtonType.OK).show();
    }

}

    public void updateSubject(ActionEvent actionEvent) throws Exception {
        try {
            boolean isUpdated = bo.Update(
                    new SubjectDTO(Integer.parseInt(txtSubjectId.getText()),
                            txtSubjectName.getText(),
                            txtSubjectDiscription.getText()));
            if (isUpdated) {

                loadAllSubject();
                new Alert(Alert.AlertType.CONFIRMATION, "Update Successfully", ButtonType.OK).show();
                Clear();
                loadAllSubject();
            } else {
                new Alert(Alert.AlertType.CONFIRMATION, "Update Fail", ButtonType.OK).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void GetDataSubject(ActionEvent actionEvent) throws Exception {
        SubjectDTO dto = bo.getSubject(txtSeach.getText());
        if (dto != null) {
            txtSubjectId.setText(String.valueOf(dto.getSubId()));
            txtSubjectId.setText(String.valueOf(dto.getSubId()));
            txtSubjectName.setText(dto.getSubName());
            txtSubjectDiscription.setText(dto.getSubDiscription());
        }
        Clear();
    }

    private void Clear() {
        txtSubjectId.setText("");
        txtSubjectName.setText("");
        txtSubjectDiscription.setText("");
    }
}
