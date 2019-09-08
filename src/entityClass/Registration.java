package entityClass;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//挂号类
public class Registration implements Serializable {

    private Patient patient;
    private Doctor doctor;
    //处方列表
    private List<Prescription> prescriptionList=new ArrayList<>();
    //计算出所需缴的总费用
    private double totalCost;

    //add方法
    public void addPrescriptionToList(Prescription prescription){
        getPrescriptionList().add(prescription);
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }


    public List<Prescription> getPrescriptionList() {
        return prescriptionList;
    }

    public void setPrescriptionList(List<Prescription> prescriptionList) {
        this.prescriptionList = prescriptionList;
    }



}

