package controller;
//新增处方的单独跳出页面
import entityClass.Prescription;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class AddPrescriptionController {

    @FXML
    private Label tip;

    @FXML
    private Label hit;

    @FXML
    private TextField txtAddPrescription;

    @FXML
    private Button confirm;

    static List<Prescription> PrescriptionList=new ArrayList<>();


    public void pressConfirm(ActionEvent e){
        if(e.getSource()==confirm)
        {
            //没有输入处方名，默认处方名称为"新增处方"
            if(txtAddPrescription.getText()==null){
                Prescription prescription=new Prescription("新增处方",true);
                PrescriptionList.add(prescription);
            }
            else{
                String name=txtAddPrescription.getText();
                Prescription prescription=new Prescription(name,true);
                PrescriptionList.add(prescription);
            }
        }
        hit.setText("增方成功!");
    }

}
