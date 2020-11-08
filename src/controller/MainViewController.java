package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainViewController {
    public AnchorPane root;

    public void initialize() throws IOException {
        setUI("DefaultView.fxml");
    }

    public void OpenRegistrationView(MouseEvent mouseEvent) throws IOException {
        setUI("RegistrationView.fxml");
    }

    public void OpenTeacherView(MouseEvent mouseEvent) throws IOException {
        setUI("TeacherView.fxml");
    }

    public void OpenSubjectView(MouseEvent mouseEvent) throws IOException {
        setUI("SubjectView.fxml");
    }

    public void OpenAttendanceView(MouseEvent mouseEvent) throws IOException {
        setUI("AttendanceView.fxml");
    }

    public void OpenExamView(MouseEvent mouseEvent) throws IOException {
        setUI("ExamView.fxml");
    }

    public void OpenPaymentView(MouseEvent mouseEvent) throws IOException {
        setUI("PaymentView.fxml");
    }

    public void Home(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/View/MainView.fxml"))));
    }

    private void setUI(String location) throws IOException {
        this.root.getChildren().clear();
        this.root.getChildren().add(FXMLLoader.load(this.getClass().getResource("/view/"+location)));
    }


}
