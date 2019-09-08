package entityClass;

public class RegistrationMaster {

    //把对象存进HashMap
    public static void addRegistration(Registration r,Patient p){
        Container.stringRegistrationHashMap.put(p.getCaseNumber(),r);
        //把病人状态变为挂好号
        p.setRegistered(true);
        //把病人状态变为已诊断
        p.setDiagnosed(true);
        System.out.println("存入成功");

        Container.stringPatientHashMap.put(p.getCaseNumber(),p);
        //把病人状态变为挂好号
        p.setRegistered(true);
        //把病人状态变为已诊断
        p.setDiagnosed(true);
        System.out.println("存入成功");
    }





}
