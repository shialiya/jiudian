package cn.scau.pojo;

/**
 * @ClassName：User
 * @Description：TODO
 * @Author： lishuai
 * @Date：2021/7/31 1:13 下午
 * @Versiion：1.0
 */
public class User {

    private Integer id;
    private Integer duankou;
    private String name;
    private String vx;
    private String endTime;
    /**
     * 登录密码
     */
    private String password;
    private String canshu;
    private String beizhu;
    /**
     * 登录账号
     */
    private String youxiang;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDuankou() {
        return duankou;
    }

    public void setDuankou(Integer duankou) {
        this.duankou = duankou;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVx() {
        return vx;
    }

    public void setVx(String vx) {
        this.vx = vx;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCanshu() {
        return canshu;
    }

    public void setCanshu(String canshu) {
        this.canshu = canshu;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

    public String getYouxiang() {
        return youxiang;
    }

    public void setYouxiang(String youxiang) {
        this.youxiang = youxiang;
    }

    public User(Integer id, Integer duankou, String name, String vx, String endTime, String password, String canshu, String beizhu, String youxiang) {
        this.id = id;
        this.duankou = duankou;
        this.name = name;
        this.vx = vx;
        this.endTime = endTime;
        this.password = password;
        this.canshu = canshu;
        this.beizhu = beizhu;
        this.youxiang = youxiang;
    }

    public User() {
    }
}
