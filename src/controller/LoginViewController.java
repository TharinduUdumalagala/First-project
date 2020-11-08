package controller;

import bo.BoFactory;
import bo.custom.LoginBo;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import dto.LoginDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Base64;

public class LoginViewController {
    public Button btnLogin;
    public JFXTextField txtUserName;
    public JFXPasswordField pwdPassword;

    LoginBo loginBo = BoFactory.getInstance().getBo(BoFactory.BOType.LOGIN);

    public void OnLoginAction(ActionEvent actionEvent) throws IOException {
        try {
            String userName = txtUserName.getText().trim();
            String password = new String(Base64.getEncoder().encode(pwdPassword.getText().getBytes()));

            if (userName.length() > 0 && password.length() > 0) {
                LoginDTO login = loginBo.login(userName, password);
                if (login != null) {

                    URL resource = this.getClass().getResource("/view/MainView.fxml");
                    Parent load = FXMLLoader.load(resource);
                    Scene scene = new Scene(load);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.show();
                } else {
                    new Alert(Alert.AlertType.WARNING, "Try Again !!!!",
                            ButtonType.OK, ButtonType.NO).show();
                }
            } else {
                new Alert(Alert.AlertType.WARNING, "Empty !!!!",
                        ButtonType.OK, ButtonType.NO).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
