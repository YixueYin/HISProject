package controller;

import entityClass.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

import static entityClass.Data.readDepartment;
import static entityClass.Data.readDoctors;

public class GhyController implements Initializable {
    @FXML
    private Pane pane;

    @FXML
    private Button gh;

    @FXML
    private Button qk;

    @FXML
    private Button calculatePay;

    @FXML
    private Label title;

    @FXML
    private Label information;

    @FXML
    private Label caseNumber;

    @FXML
    private Label name;

    @FXML
    private Label gender;

    @FXML
    private Label age;

    @FXML
    private Label birthday;

    @FXML
    private Label idNumber;

    @FXML
    private Label address;
    //结算类别
    @FXML
    private Label typesOfpaying;
    //挂号科室
    @FXML
    private Label registeredDepartments;
    //挂号级别
    @FXML
    private Label registrationLevel;
    //看诊医生
    @FXML
    private Label doctor;
    //病历本
    @FXML
    private Label medicalRecordbooklet;
    //应收金额
    @FXML
    private Label moneyShouldBePaid;

    @FXML
    private Label TopTip;

    @FXML
    private TextField TextCaseNumber;

    @FXML
    private TextField TextName;

    @FXML
    private TextField TextGender;

    @FXML
    private TextField TextAge;

    //身份证号
    @FXML
    private TextField TextIdNumber;

    //家庭住址
    @FXML
    private TextField TextAddress;

    //应收金额
    @FXML
    private TextField TextMoneyShouldBePaid;

    @FXML
    private ChoiceBox<String> ChooseTypesOfpaying;

    ObservableList<String> list = FXCollections.observableArrayList("现金", "支付宝", "微信", "银行卡");

    @FXML
    private ChoiceBox ChooseRegisteredDepartments;

    ObservableList<Department> list1 = FXCollections.observableArrayList(Data.readDepartment());

    @FXML
    private ChoiceBox ChooseRegistrationLevel;

    ObservableList<String> list2 = FXCollections.observableArrayList("普通号", "专家号");

    @FXML
    private ChoiceBox ChooseDoctor;

    ObservableList<Doctor> list3 = FXCollections.observableArrayList(Data.readDoctors());

    @FXML
    private DatePicker PickBirthday;

    @FXML
    private CheckBox CheckMedicalRecordbooklet;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ChooseTypesOfpaying.setItems(list);
        ChooseRegisteredDepartments.setItems(list1);
        ChooseRegistrationLevel.setItems(list2);
        ChooseDoctor.setItems(list3);
        String caseNumber = PatientMaster.automaticallyFormCasNumber();
        TextCaseNumber.setText(caseNumber);

    }


    //患者挂号
    public void register() {
        //把病人的信息输入存储
        //完成挂号
        Registration r = new Registration();
        Patient p = new Patient();
        Doctor d = new Doctor();
        //病历号
        String caseNumber = PatientMaster.automaticallyFormCasNumber();
        p.setCaseNumber(caseNumber);
        p.setName(TextName.getText());
        p.setGender(TextGender.getText());
        p.setAge(Integer.parseInt(TextAge.getText()));
        p.setIdNumber(TextIdNumber.getText());
        p.setAddress(TextAddress.getText());
        //计算挂号时产生的费用
        p.setAmountDue(calculateTheMoneyRequired());
        p.setTypesOfPaying(ChooseTypesOfpaying.getValue());
        for(Department item:readDepartment())
        {
            if(ChooseRegisteredDepartments.equals(item.getName()))
            {
                p.setRegisteredDepartments(item);
            }
        }
        p.setRegistrationLevel(String.valueOf(ChooseRegistrationLevel.getValue()));
        for(Doctor item:readDoctors())
        {
            if(ChooseDoctor.equals(item.getName()))
            {
                p.setDoctor(item);
            }
        }

        p.setBirthday(PickBirthday.getValue());
        //未确定
        p.setMedicalRecordbooklet(CheckMedicalRecordbooklet.isSelected());
        d.setName(ChooseDoctor.getValue().toString());
        r.setPatient(p);
        r.setDoctor(d);
        //把患者的状态改为已挂号
        p.setRegistered(true);
        //把患者的挂号记录存进hashmap和文件里
        RegistrationMaster.addRegistration(r, p);
        Data.writeRegistrationData(r);
    }

    private double calculateTheMoneyRequired() {
        double moneyRequired=0;
        boolean booklet=CheckMedicalRecordbooklet.isSelected();
        if(booklet){
            moneyRequired++;
        }else {
            moneyRequired=0;
        }

        if(ChooseRegistrationLevel.getValue().equals("专家号"))
        {
            //挂专家号付30元
            moneyRequired=moneyRequired+30;
        }else if(ChooseRegistrationLevel.getValue().equals("普通号")){
            //挂普通号付20元
            moneyRequired=moneyRequired+20;
        }
        return moneyRequired;
    }

    //清空按钮
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == qk) {
            TextCaseNumber.clear();
            TextName.clear();
            TextGender.clear();
            TextAge.clear();
            TextIdNumber.clear();
            TextAddress.clear();
            TextMoneyShouldBePaid.clear();
            ChooseTypesOfpaying.getSelectionModel().clearSelection();
            ChooseRegisteredDepartments.getSelectionModel().clearSelection();
            ChooseRegistrationLevel.getSelectionModel().clearSelection();
            ChooseDoctor.getSelectionModel().clearSelection();
            PickBirthday.setValue(null);
            CheckMedicalRecordbooklet.setSelected(false);
        }
    }


    //挂号按钮
    public void actionRegister(ActionEvent e) {
        if (e.getSource() == gh) {
            if(TextCaseNumber!=null&&TextName!=null&&TextGender!=null&&TextAge!=null&&ChooseRegisteredDepartments.getValue()!=null&&ChooseRegistrationLevel.getValue()!=null&&ChooseDoctor.getValue()!=null&&ChooseTypesOfpaying.getValue()!=null){
                TopTip.setText("挂号成功！");
                register();
            }else if(TextCaseNumber==null||TextName==null||TextGender==null||TextAge==null||ChooseRegisteredDepartments.getValue()==null||ChooseRegistrationLevel.getValue()==null||ChooseDoctor.getValue()==null||ChooseTypesOfpaying.getValue()==null){
                TopTip.setText("必输数据不全！");
            }
        }
    }

    //根据科室选择医生
    public void chooseDocter(MouseEvent mouseEvent){
        String deps=ChooseRegisteredDepartments.getValue().toString();
        list3.clear();
        for(Doctor doctor:Data.readDoctors()){
            if(doctor.getDepartment().getName().equals(deps))
            {
                list3.add(doctor);
            }
        }
    }

    //显示所需费用
    public void actionCalculatePay(ActionEvent e){
        //这步其实不太对，应该调用当前病人。。。不过可以之后存进去
        calculateTheMoneyRequired();
        TextMoneyShouldBePaid.setText(String.valueOf(calculateTheMoneyRequired()));
    }

}
