package entityClass;
//用于医院管理员维护的所有使用该系统的用户
//用户父类
//用户基本信息包括：登录名、密码、真实姓名、用户所在科室，用户类别（挂号收费员、门诊医生、药房操作员、医院管理员）。
// 如果是医生，还需要维护医生的职称信息（主任医师、副主任医师、主治医师、住院医师）和是否参与排班
public class User {
    //用户登陆名
    private String userName;
    //密码
    private String password;
    //真实姓名
    private String name;
    //用户所在科室
    private Department department;

    public User(){}
    public User(String userName, String password, String name, Department department) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.department = department;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

}
