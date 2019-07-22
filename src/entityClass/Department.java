package entityClass;
//科室编码、科室名称、科室分类、科室类别
public class Department {

    //科室编码
    private String departmentId;

    //科室名称
    private String departmentName;

    //科室分类
    private String departmentClassification;

    //科室类别
    private String departmentCategory;



    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentClassification() {
        return departmentClassification;
    }

    public void setDepartmentClassification(String departmentClassification) {
        this.departmentClassification = departmentClassification;
    }

    public String getDepartmentCategory() {
        return departmentCategory;
    }

    public void setDepartmentCategory(String departmentCategory) {
        this.departmentCategory = departmentCategory;
    }

}
