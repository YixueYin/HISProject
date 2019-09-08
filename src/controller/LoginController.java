package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class LoginController implements Initializable {
    @FXML
    private Label label;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void Login(ActionEvent event) {
        //打开管理员界面

        if (username.getText().equals("root") && password.getText().equals("root")) {
            Stage stage = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("../view/Root.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene = new Scene(root);
            scene.getStylesheets().add(RootController.class.getResource("/source/root.css").toExternalForm());
            stage.setTitle("Root");
            stage.setScene(scene);
            stage.show();
            stage.setMaximized(true);
            label.setText("Login Success");


        } else if (username.getText().equals("ghy") && password.getText().equals("ghy123")) {
            //打开挂号员界面
            Stage stage = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("../view/Ghy.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene = new Scene(root);
            scene.getStylesheets().add(GhyController.class.getResource("../source/Ghy.css").toExternalForm());
            stage.setTitle("Ghy");
            stage.setScene(scene);
            stage.show();
            stage.setMaximized(true);
            label.setText("Login Success");

        } else if ((username.getText().equals("bianque") && password.getText().equals("bianque123"))||(username.getText().equals("wrj")&&password.getText().equals("wrj123"))||(username.getText().equals("xfs")&&password.getText().equals("xfs123"))) {
            //打开医生界面
            Stage stage = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/view/Doctor.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene = new Scene(root);
            scene.getStylesheets().add(DoctorController.class.getResource("/source/doctor.css").toExternalForm());
            stage.setTitle("Doctor");
            stage.setScene(scene);
            stage.show();
            stage.setMaximized(true);
            label.setText("Login Success");

        } else {
            label.setText("Login Failed");
        }
    }


}
