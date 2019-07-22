package entityClass;

import java.util.Date;
import java.util.HashMap;

public class Patient {
    //姓名（必填）
    private String name;

    //性别（必填）
    private String gender;

    //家庭住址（选填）
    private String address;

    //结算类别（必填）
    private String typesOfClosingAccounts;

    //挂号级别（必填）
    private String registrationLevel;

    //挂号科室（必填）
    private String registeredDepartments;

    //看诊医生（必填）
    private String doctor;

    //年龄（必填）
    private int age;

    //出生日期
    private Date birthday;

    //身份证号（选填）
    private String idNumber;

    //病历号（自动生成）（必填）
    private int caseNumber;

    //病历本（如要单独收费1元）
    private boolean medicalRecordbooklet;

    //应收金额（由系统根据挂号的级别及看诊医生，是否要病历本，自动算出）
    private double amountDue;

    //是否挂号
    private boolean isRegistered;

    //是否付费
    private boolean isPaid;

    //新建一个Hashmao用来通过病历号访问病人
    protected HashMap<Integer, Patient> map=new HashMap<>();

    //通过病历号去查找一个病人
    public Patient getPatientByCaseNumber(int caseNumber){
        return map.get(caseNumber);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTypesOfClosingAccounts() {
        return typesOfClosingAccounts;
    }

    public void setTypesOfClosingAccounts(String typesOfClosingAccounts) {
        this.typesOfClosingAccounts = typesOfClosingAccounts;
    }

    public String getRegistrationLevel() {
        return registrationLevel;
    }

    public void setRegistrationLevel(String registrationLevel) {
        this.registrationLevel = registrationLevel;
    }

    public String getRegisteredDepartments() {
        return registeredDepartments;
    }

    public void setRegisteredDepartments(String registeredDepartments) {
        this.registeredDepartments = registeredDepartments;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public int getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(int caseNumber) {
        this.caseNumber = caseNumber;
    }

    public boolean isMedicalRecordbooklet() {
        return medicalRecordbooklet;
    }

    public void setMedicalRecordbooklet(boolean medicalRecordbooklet) {
        this.medicalRecordbooklet = medicalRecordbooklet;
    }

    public double getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(double amountDue) {
        this.amountDue = amountDue;
    }

}