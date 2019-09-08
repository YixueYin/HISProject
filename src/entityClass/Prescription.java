package entityClass;

import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;
import java.util.HashMap;

public class Prescription {
    private ArrayList<HashMap<Drug,Integer>> drugWithNumber=new ArrayList<>();
    private ArrayList<Drug> drugs=new ArrayList<>();

    public Prescription(String name,boolean isTemporary){
        this.name=new SimpleStringProperty(name);
        this.isTemporary=true;
    }
    //暂存
    private boolean isTemporary;
    //支付
    private boolean isPaid;
    //开立
    private boolean isTaken;
    //处方名称
    private SimpleStringProperty name;
    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }



    public boolean isTemporary() {
        return isTemporary;
    }

    public void setTemporary(boolean temporary) {
        isTemporary = temporary;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public boolean isTaken() {
        return isTaken;
    }

    public void setTaken(boolean taken) {
        isTaken = taken;
    }

    //给处方增药
    public void addDrugToPrescription(Drug drug,int number){
        HashMap<Drug,Integer> map=new HashMap<>();
        map.put(drug,number);
        drugWithNumber.add(map);
        drugs.add(drug);
    }

    public void getNumberOfDrug(){
        for(Drug drug:drugs){
            for(HashMap<Drug,Integer> map:drugWithNumber){
                drug.setNumber(map.get(drug));
            }
        }
    }

    public void removeDrug(Drug drug)
    {
        drugWithNumber.remove(drug);
        drugs.remove(drug);
    }

}
