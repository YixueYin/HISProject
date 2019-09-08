package entityClass;


public class Department {
    private String name;
    //医生
    //科室和医生为一对多的关系

    public Department(String name) { this.name = name; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return this.getName();
    }
}
