package entityClass;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;

public class Drug implements Serializable {

    private static int val;
    private int cost;
    //名称
    private SimpleStringProperty name=new SimpleStringProperty();
    //规格
    private SimpleStringProperty specification=new SimpleStringProperty();
    //用法
    private SimpleStringProperty usage=new SimpleStringProperty();
    //包装单位
    private SimpleStringProperty drugUnit=new SimpleStringProperty();
    //用量
    private SimpleStringProperty dosage=new SimpleStringProperty();
    //数量
    private SimpleStringProperty number=new SimpleStringProperty();
    //单价
    private SimpleStringProperty value=new SimpleStringProperty();


    public Drug(String name, String specification, String drugUnit, String usage, String dosage, String value)
    {
        this.name=new SimpleStringProperty(name);
        this.specification= new SimpleStringProperty(specification);
        this.drugUnit=new SimpleStringProperty(drugUnit);
        this.usage=new SimpleStringProperty(usage);
        this.dosage=new SimpleStringProperty(dosage);
        this.value=new SimpleStringProperty(value);
    }

    public Drug(String name,String number)
    {
        this.name=new SimpleStringProperty(name);
        this.number=new SimpleStringProperty(number);
    }

    public static int getVal() {
        return val;
    }

    public static void setVal(int val) {
        Drug.val = val;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getSpecification() {
        return specification.get();
    }

    public StringProperty specificationProperty() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification.set(specification);
    }

    public String getUsage() {
        return usage.get();
    }

    public StringProperty usageProperty() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage.set(usage);
    }


    public String getNumber() {
        return number.get();
    }

    public StringProperty numberProperty() {
        return number;
    }

    public void setNumber(int number) {
        this.number.set(String.valueOf(number));
    }

    public String getValue() {
        return value.get();
    }

    public StringProperty valueProperty() {
        return value;
    }

    public void setValue(String value) {
        this.value.set(value);
    }

    public String getDrugUnit() {
        return drugUnit.get();
    }

    public StringProperty drugUnitProperty() {
        return drugUnit;
    }

    public void setDrugUnit(String drugUnit) {
        this.drugUnit.set(drugUnit);
    }

    public String getDosage() {
        return dosage.get();
    }

    public StringProperty dosageProperty() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage.set(dosage);
    }

    public void setNumber(String number) {
        this.number.set(number);
    }


}
