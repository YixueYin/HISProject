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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class LoginController implements Initializable {
    @FXML
    private Label label;

    @FXML
    private Label title;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Pane pane;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }


    public void Login(ActionEvent event){
        //打开管理员界面
        if(username.getText().equals("root")&&password.getText().equals("root"))
        {
            Stage stage=new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/sample/Root.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene=new Scene(root);
            scene.getStylesheets().add(LoginController.class.getResource("/source/root.css").toExternalForm());
            stage.setTitle("Root");
            stage.setScene(scene);
            stage.show();
            stage.setMaximized(true);
            label.setText("Login Success");


        }else if(username.getText().equals("ghy")&&password.getText().equals("ghy123"))
        {
            //打开挂号员界面
            Stage stage=new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/sample/Ghy.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene=new Scene(root);
            stage.setTitle("Ghy");
            stage.setScene(scene);
            stage.show();
            stage.setMaximized(true);
            label.setText("Login Success");

        }else if(username.getText().equals("bianque")&&password.getText().equals("bianque123"))
        {
            //打开医生界面
            Stage stage=new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/sample/Doctor.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene=new Scene(root);
            stage.setTitle("Doctor");
            stage.setScene(scene);
            stage.show();
            stage.setMaximized(true);
            label.setText("Login Success");
        }else {
            label.setText("Login Failed");
        }
    }


}
