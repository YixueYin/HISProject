package controller;

import entityClass.Container;
import entityClass.Drug;
import entityClass.Patient;
import entityClass.Prescription;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.*;

import static entityClass.Data.cerateDrugList;

public class DoctorController implements Initializable {
    @FXML
    private Pane pane;
    @FXML
    private Label title;
    //增方
    @FXML
    private Button addPrescription;
    //删方
    @FXML
    private Button deletePrescription;
    //开立
    @FXML
    private Button openPrescription;
    //作废
    @FXML
    private Button cancellation;
    //增药
    @FXML
    private Button addDrug;
    @FXML
    private TextField txtAddName;
    @FXML
    private TextField txtAddNumber;
    //门诊医生侧边栏
    @FXML
    private MenuButton sideMenu;
    //未诊患者
    @FXML
    private TableView<Patient> notYetPatient;
    @FXML
    private TableColumn<Patient,String> notYetName;
    @FXML
    private TableColumn<Patient,String> notYetAge;
    @FXML
    //接诊按钮
    private Button reception;
    @FXML
    private Label hint;
    //已诊患者列表
    @FXML
    private TableView alreadyPatient;
    @FXML
    private TableColumn<Patient,String> alreadyName;
    @FXML
    private TableColumn<Patient,String> alreadyAge;
    private ObservableList<Patient> alreadyPatientList = FXCollections.observableArrayList(Container.hashMapValueToList());
    //门诊处方列表
    @FXML
    private TableView outpatientPrescription;
    //手动传入List
    private ObservableList<Prescription> outpatientPrescriptionList=FXCollections.observableArrayList(AddPrescriptionController.PrescriptionList);
    @FXML
    private TableColumn<Prescription, String> prescriptionName;
    @FXML
    //处方状态（默认为暂存）
    private TableColumn<Prescription, String> prescriptionState;
    //药品列表
    @FXML
    private TableView<Drug> drugDetail;

    private ObservableList<Drug> data = FXCollections.observableArrayList(cerateDrugList());
    @FXML
    private TableColumn<Drug, String> drugName;
    @FXML
    //药品规格
    private TableColumn<Drug, String> drugSpecification;
    @FXML
    //包装单位
    private TableColumn<Drug, String> drugUnit;
    @FXML
    private TableColumn<Drug, String> usage;
    @FXML
    private TableColumn<Drug, String> dosage;
    @FXML
    private TableColumn<Drug, String> value;

    //药品选择
    @FXML
    private TableView<Drug> choiceDrug;

    private ObservableList<Drug> choiceDrugList = FXCollections.observableArrayList();

    @FXML
    private TableColumn<Drug, String> choiceDrugName;

    @FXML
    private TableColumn<Drug, String> choiceDrugNumber;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //初始化已诊患者栏
        alreadyName.setCellValueFactory(new PropertyValueFactory<Patient,String>("name"));
        alreadyAge.setCellValueFactory(new PropertyValueFactory<Patient,String>("age"));

        alreadyPatient.setItems(alreadyPatientList);
        alreadyPatient.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
                if (alreadyPatient.getSelectionModel().getSelectedItem() != null) {
                    TableView.TableViewSelectionModel selectionModel = alreadyPatient.getSelectionModel();
                    ObservableList selectedCells = selectionModel.getSelectedCells();
                    TablePosition tablePosition = (TablePosition) selectedCells.get(0);
                    Object val = tablePosition.getTableColumn().getCellData(newValue);
                    /* val即为选中的此行的第一列内容 患者的name */
                    //改变此患者的状态为已接诊
                    for(int i=0;i<alreadyPatientList.size();i++){
                        if(alreadyPatientList.get(i).getName().equals(val)){
                            alreadyPatientList.get(i).setDiagnosed(true);
                        }
                    }
                }
            }
        });
        //初始化药品栏
        drugName.setCellValueFactory(new PropertyValueFactory<Drug, String>("name"));
        drugSpecification.setCellValueFactory(new PropertyValueFactory<Drug, String>("specification"));
        drugUnit.setCellValueFactory(new PropertyValueFactory<Drug, String>("drugUnit"));
        usage.setCellValueFactory(new PropertyValueFactory<Drug, String>("usage"));
        dosage.setCellValueFactory(new PropertyValueFactory<Drug, String>("dosage"));
        value.setCellValueFactory(new PropertyValueFactory<Drug, String>("value"));

        drugDetail.setItems(data);

        //初始化药品选择栏
        choiceDrugName.setCellValueFactory(new PropertyValueFactory<Drug,String>("name"));
        choiceDrugNumber.setCellValueFactory(new PropertyValueFactory<Drug,String>("number"));
        choiceDrug.setItems(choiceDrugList);

        //绑定处方列表
        prescriptionName.setCellValueFactory(new PropertyValueFactory<>("name"));
        prescriptionState.setCellValueFactory(new PropertyValueFactory<>("isTemporary"));
        outpatientPrescription.setItems(outpatientPrescriptionList);
    }


    //手动添加处方（未完成）
    public void pressAddPrescription(ActionEvent event)
    {
        if(event.getSource()==addPrescription)
        {
            Stage stage = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/view/addPrescription.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene = new Scene(root);
            scene.getStylesheets().add(DoctorController.class.getResource("/source/addPrescription.css").toExternalForm());
            stage.setTitle("增方");
            stage.setScene(scene);
            stage.show();
        }
    }

    //手动增药（未完成）
    public void addMedicine(ActionEvent event) {
        if(event.getSource()==addDrug)
        {
            choiceDrugList.add(new Drug(txtAddName.getText(),txtAddNumber.getText()));
            txtAddName.clear();
            txtAddNumber.clear();
        }
    }

    //手动接诊患者
    public void pressReceptionButton(ActionEvent event){
        if(event.getSource()==reception)
        {
            //按下按钮，接诊患者，才能为患者开处方
            //给出接诊成功提示

            hint.setText("接诊成功!");

        }
    }

}
