package entityClass;

import java.io.Serializable;
import java.time.LocalDate;

public class Patient implements Serializable {
    public Patient(){}

    //姓名（必填）
    private String name;
    //性别（必填）
    private String gender;
    //家庭住址（选填）
    private String address;

    //结算类别（必填）
    private String typesOfPaying;

    //挂号级别（必填）
    private String registrationLevel;

    //挂号科室（必填）
    private Department registeredDepartments;

    //看诊医生（必填）
    private Doctor doctor;

    //年龄（必填）
    private int age;
    //出生日期
    private LocalDate birthday;

    //身份证号（选填）
    private String idNumber;

    //病历号（自动生成）（必填）
    private String caseNumber;

    //病历本（如要单独收费1元）
    private boolean medicalRecordbooklet;

    //应收金额（由系统根据挂号的级别及看诊医生，是否要病历本，自动算出）
    private double amountDue;

    //是否挂号
    private boolean isRegistered;

    //是否付费
    private boolean isPaid;

    //是否被诊断
    private boolean isDiagnosed;

    public Patient(String name, String gender) {
        this.name = name;
        this.gender = gender;
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



    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }



    public boolean isDiagnosed() {
        return isDiagnosed;
    }

    public void setDiagnosed(boolean diagnosed) {
        isDiagnosed = diagnosed;
    }



    public boolean isRegistered() {
        if(isRegistered)
            return true;
        else
            return false;
    }

    public void setRegistered(boolean registered) {
        isRegistered = registered;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }


    public void setAddress(String address) {
        this.address = address;
    }


    public String getRegistrationLevel() {
        return registrationLevel;
    }

    public void setRegistrationLevel(String registrationLevel) {
        this.registrationLevel = registrationLevel;
    }


    public String getTypesOfPaying() {
        return typesOfPaying;
    }

    public void setTypesOfPaying(String typesOfPaying) {
        this.typesOfPaying = typesOfPaying;
    }
    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
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

    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
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

    public Department getRegisteredDepartments() {
        return registeredDepartments;
    }

    public void setRegisteredDepartments(Department registeredDepartments) {
        this.registeredDepartments = registeredDepartments;
    }

}