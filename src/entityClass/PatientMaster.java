package entityClass;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class PatientMaster {
    //自动生成病历号
    public static String automaticallyFormCasNumber(){
        Date now=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");
        return sdf.format(now);
    }
}
