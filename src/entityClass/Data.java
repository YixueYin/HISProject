package entityClass;

import com.alibaba.fastjson.JSON;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class Data implements Serializable {
    private static ArrayList<Patient> patients = new ArrayList<>();
    private static ArrayList<Doctor> doctors = new ArrayList<>();
    private static ArrayList<Registration> registrations = new ArrayList<>();

    public static void addPatient(Patient patient) {
        if (patient.isRegistered())
            System.out.println("该病人已存在");
        else {
            //在数组里加入patient
            patients.add(patient);
        }
    }

    public static List<Department> readDepartment() {
        List<Department> ks = new ArrayList<>();
        List<String> lines = null;
        try {
            //把文件按行读取，存储进一个List
            lines = Files.readAllLines(Paths.get("C:\\Users\\47583\\HISProject\\department.txt"));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        //按行读取对象
        if (lines != null) {
            for (String line : lines) {
                // line.split(" ")
                ks.add(new Department(line));
            }
        }
        return ks;
    }

    public static List<Doctor> readDoctors() {
        List<Doctor> ys = new ArrayList<>();
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get("C:\\Users\\47583\\HISProject\\doctors.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //按行读取对象
        if(lines!=null)
        {
            for(String line:lines)
            {
                String[] str=line.split(" ");
                for(Department item:readDepartment())
                {
                    if(str[3].equals(item.getName()))
                    {
                        ys.add(new Doctor(str[0],str[1],str[2],item));

                    }
                }
            }
        }
        return ys;
    }

        //文件按行读取
    public static List<Drug> cerateDrugList() {
        //构造一个药品列表
        List<Drug> drugs = new ArrayList<>();

        drugs.add(new Drug("注射用甲氨喋呤", "1g×1支", "支", "注射", "一天两次", "15.73"));
        drugs.add(new Drug("氟康唑氯化钠注射液(大扶康)", "200mg×100ml/瓶", "瓶", "注射", "一天两次", "7.01"));
        drugs.add(new Drug("50%葡萄糖注射液(塑瓶)", "10:20ml×1支", "支", "注射", "一天一次", "25.16"));
        drugs.add(new Drug("红芪", "10g/袋", "袋", "口服", "一天三次", "30.79"));
        drugs.add(new Drug("盐酸氨酮戊酸散（外用）", "118mg×1瓶", "瓶", "外用", "一天两次", "19.51"));
        drugs.add(new Drug("盐酸美金刚片(易贝申)", "10mg×28片/盒", "盒", "口服", "一天三次", "22.05"));
        drugs.add(new Drug("磷酸奥司他韦胶囊(达菲)", "75mg×10粒/盒", "盒", "口服", "一天三次", "60.96"));
        drugs.add(new Drug("泽泻颗粒", "1g/10g/袋", "袋", "口服", "一天两次", "0.09"));
        drugs.add(new Drug("山药颗粒", "0.5g/10g/袋", "袋", "口服", "一天两次", "6.79"));
        drugs.add(new Drug("雄氏老方", "50mg×50粒/盒", "盒", "口服", "一天五次", "100"));
        drugs.add(new Drug("蒙药心脑方", "20mg×30粒/盒", "袋", "口服", "一天四次", "100"));


        return drugs;
    }




    //将挂号信息写入文件
    //使用JSON写进文件
    public static void writeRegistrationData(Registration r){
        String objJson= JSON.toJSONString(r);
        try {
            FileWriter fw=new FileWriter("C:\\Users\\47583\\HISProject\\Registration.txt");
            BufferedWriter bw=new BufferedWriter(fw);
            bw.write(objJson);
            bw.flush();
            fw.close();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //使用序列化
    /*public static void writeRegistrationData(Registration r) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("C:\\Users\\47583\\HISProject\\Registration.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(r);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }*/


}



