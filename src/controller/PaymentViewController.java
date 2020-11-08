package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;

public class PaymentViewController {
    public JFXTextField txtStudentId;
    public JFXTextField txtStudentName;
    public ComboBox cmbGrade;
    public ComboBox txtSubject;
    public ComboBox txtMonth;
    public JFXTextField txtFee;
    public Button btnSetPayment;
    public Button btnClear;
    public TableView tblPayment;
    public TableColumn colDate;
    public TableColumn colStudentId;
    public TableColumn colStudentName;
    public TableColumn colGrade;
    public TableColumn colSubject;
    public TableColumn colMonth;
    public TableColumn colFee;
    public TableColumn colOperate;
}
