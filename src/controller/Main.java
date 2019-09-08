package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/view/Login.fxml"));
        Scene scene = new Scene(root, 400, 300);
        scene.getStylesheets().add(LoginController.class.getResource("/source/login.css").toExternalForm());
        primaryStage.setTitle("Welcome");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
    }



    public static void main(String[] args) {

        //1.患者挂号

        //2.医生开药

        //3.患者缴费

        //4.患者退号

        //5.患者退费

        //6.药房发药

        launch(args);

    }
}
