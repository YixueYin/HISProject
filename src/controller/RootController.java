package controller;

import entityClass.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RootController {
    //药房发药界面
    @FXML
    private TextField txtCaseNumberFY;
    @FXML
    private Button deliverOK;
    @FXML
    private Button searchForPatient;
    @FXML
    private Label hint1;
    //患者缴费界面
    @FXML
    private TextField txtCaseNumberJF;
    @FXML
    private TextField txtTotalCost;
    @FXML
    private Button payOK;
    @FXML
    private Button searchForTotalCost;
    @FXML
    private Button searchForPatient2;
    @FXML
    private Label hint2;
    //患者退费界面
    @FXML
    private TextField txtCaseNumberTF;
    @FXML
    private TextField txtPay;
    @FXML
    private Button returnPayOK;
    @FXML
    private Button searchForAmountDue;
    @FXML
    private Button searchForPatient3;
    @FXML
    private Label hint3;
    //患者退号界面
    @FXML
    private TextField txtCaseNumberTH;
    @FXML
    private Button returnCaseNumberOK;
    @FXML
    private Button searchForPatient4;
    @FXML
    private Label hint4;

    //药房发药
    //患者输入病历号后 通过病历号查询当前患者的处方是否处于已开立状态 发药 并给出提示
    public void pressSearchForPatient(ActionEvent actionEvent) {
        String patientCaseNumber = txtCaseNumberFY.getText();
        //通过病历号去查找挂号记录
        Registration r = Container.getRegistrationByCaseNumber(patientCaseNumber);
        if (r != null) {
            hint1.setText("查找成功！");
        } else {
            hint1.setText("没有挂号记录！");
        }
    }

    public void pressDeliverOK(ActionEvent actionEvent) {
        String patientCaseNumber = txtCaseNumberFY.getText();
        Registration r = Container.getRegistrationByCaseNumber(patientCaseNumber);
        for (Prescription p : r.getPrescriptionList()) {
            if (!p.isTemporary() && p.isTaken()) {
                p.setDeliver(true);
                hint1.setText("发药成功！");
            } else {
                hint1.setText("请先至医生处开药");
            }
        }
    }

    //患者缴费
    //Todo 患者输入病历号后 通过病历号查询到该患者是否已开药
    public void pressSearchForPatient2(ActionEvent actionEvent) {
        double totalCost=0;
        String patientCaseNumber = txtCaseNumberJF.getText();
        //通过病历号去查找挂号记录
        Registration r = Container.getRegistrationByCaseNumber(patientCaseNumber);
        if (!(r == null)) {
            hint2.setText("查找成功！");
        } else {
            hint2.setText("没有挂号记录！");
        }
    }

    //按下查询费用按钮，当前须交费用 显示在textField上
    public void pressSearchForTotalCost(ActionEvent actionEvent){
        double totalCost=0;
        String patientCaseNumber = txtCaseNumberJF.getText();
        Registration r = Container.getRegistrationByCaseNumber(patientCaseNumber);
        //显示应缴费用(计算一波药费),并显示在textField上
        for (Prescription p : r.getPrescriptionList()) {
            Map<String,Integer> drugWithNumber=p.getDrugWithNumber();
            Iterator iter=drugWithNumber.entrySet().iterator();
            //遍历得到hashmap中的药品名称和药品数量
            while (iter.hasNext()){
                Map.Entry entry=(Map.Entry) iter.next();
                Object key=entry.getKey();
                Object val=entry.getValue();
                for(Drug d:Data.cerateDrugList()){
                    if(key.equals(d.getName())){
                        totalCost=totalCost+Integer.parseInt(d.getValue())*Integer.parseInt(String.valueOf(val));
                    }
                }
            }
        }
        System.out.println(totalCost);
        txtTotalCost.setText(String.valueOf(totalCost));
        Data.writeRegistrationData();
    }

    //按下缴费按钮后 缴费成功 清零
    public void pressPayOK(ActionEvent actionEvent){
        String patientCaseNumber = txtCaseNumberJF.getText();
        Registration r = Container.getRegistrationByCaseNumber(patientCaseNumber);
        r.setTotalCost(0);
        txtTotalCost.setText(String.valueOf(0));
        hint2.setText("缴费成功！");
        Data.writeRegistrationData();
    }


    //患者退费
    //Todo 患者输入病历号后 通过病历号查询该患者是否已处于被诊断状态
    // 若已诊断 则跳出提示信息 不能退费
    // 若未诊断 则退费
    public void pressSearchForPatient3(ActionEvent actionEvent){
        String patientCaseNumber=txtCaseNumberTF.getText();
        //通过病历号查询当前患者是否存在
        Registration r = Container.getRegistrationByCaseNumber(patientCaseNumber);
        if(r!=null){
            hint3.setText("查找成功！");
        }else{
            hint3.setText("没有挂号记录！");
        }

    }
    public void pressSearchForAmountDue(ActionEvent actionEvent){
        String patientCaseNumber=txtCaseNumberTF.getText();
        Registration r = Container.getRegistrationByCaseNumber(patientCaseNumber);
        if(r.getPatient().isDiagnosed()){
            hint3.setText("该患者已经被诊断，不能退费！");
        }else{
            //显示应退费用
            double ghCost=r.getPatient().getAmountDue();
            txtPay.setText(String.valueOf(ghCost));
        }
    }

    public void pressReturnPayOK(ActionEvent actionEvent){
        String patientCaseNumber=txtCaseNumberTF.getText();
        Registration r = Container.getRegistrationByCaseNumber(patientCaseNumber);
        //退费成功，将费用清零
        r.getPatient().setAmountDue(0);
        hint3.setText("退费成功！");
        Data.writeRegistrationData();
    }

    //患者退号
    //Todo 患者输入病历号后 通过病历号查询该患者是否已被诊断
    // 若已被诊断 则跳出提示信息 不能退号
    // 若未诊断 则退号 删除所有挂号记录
    public void pressSearchForPatient4(ActionEvent actionEvent){
        String patientCaseNumber = txtCaseNumberTH.getText();
        //通过病历号去查找挂号记录
        Registration r = Container.getRegistrationByCaseNumber(patientCaseNumber);
        if (r != null) {
            hint4.setText("查找成功！");
        } else {
            hint4.setText("没有挂号记录！");
        }
    }

    public void pressReturnCaseNumberOK(ActionEvent actionEvent){
        String patientCaseNumber=txtCaseNumberTH.getText();
        Registration r = Container.getRegistrationByCaseNumber(patientCaseNumber);
        if (r.getPatient().isDiagnosed()) {
            hint4.setText("该患者已经被诊断，不能退号！");
        }else{
            Data.getRegistrations().remove(r);
            Data.writeRegistrationData();
            hint4.setText("退号成功！");
        }
    }
}


