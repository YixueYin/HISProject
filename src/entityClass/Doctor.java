package entityClass;

import java.io.Serializable;

public class Doctor extends User implements Serializable {

    public Doctor(){}
    public Doctor(String userName, String password, String name, Department department) {
        super(userName, password, name, department);
    }

    @Override
    public String toString(){
        return this.getName();
    }
}
