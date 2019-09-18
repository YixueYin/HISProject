package entityClass;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.HashMap;

public class Prescription {
    public HashMap<String, Integer> getDrugWithNumber() {
        return drugWithNumber;
    }

    private HashMap<String,Integer> drugWithNumber=new HashMap<>();

    public Prescription(String name,boolean isTemporary){
        this.name=new SimpleStringProperty(name);
        if(isTemporary)
        {
            this.isTemporarySP=new SimpleStringProperty("暂存");
        }
    }
    //暂存
    private boolean isTemporary;
    //支付
    private boolean isPaid;
    //开立
    private boolean isTaken;
    //取药
    private boolean isDeliver;

    public boolean isDeliver() {
        return isDeliver;
    }

    public void setDeliver(boolean deliver) {
        isDeliver = deliver;
    }

    public String getIsTemporarySP() {
        return isTemporarySP.get();
    }

    public StringProperty isTemporarySPProperty() {
        return isTemporarySP;
    }

    public void setIsTemporarySP(String isTemporarySP) {
        this.isTemporarySP.set(isTemporarySP);
    }

    private StringProperty isTemporarySP=new SimpleStringProperty();

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

}
