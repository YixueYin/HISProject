package entityClass;

import java.util.*;

public class Container {
    //新建一个Hashmap用来通过病历号访问病人
    public static HashMap<String, Patient> stringPatientHashMap=new HashMap<>();
    //新建一个Hashmap
    protected static HashMap<String,Registration> stringRegistrationHashMap=new HashMap<>();

    //返回已诊病人列表
    public static List<Patient> hashMapValueToList(){
        List<Patient> returnResult=new ArrayList<>();
        Set<String> keySet=stringPatientHashMap.keySet();
        Iterator<String> it=keySet.iterator();
        while(it.hasNext()){
            returnResult.add(stringPatientHashMap.get(it.next()));
        }
        return returnResult;
    }


    //通过病历号去查找一个病人
    public Patient getPatientByCaseNumber(String caseNumber){
        return stringPatientHashMap.get(caseNumber);
    }

    //通过病历号去查找挂号记录
    public Registration getRegistrationByCaseNumber(String caseNumber){return  stringRegistrationHashMap.get(caseNumber);}
}
