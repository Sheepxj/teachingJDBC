package stumage.po;

public class Student {

    private Integer sid;
    private String sname;
    private String sex;
    private String major;
    private Integer point;
    private String ethnic;
    private String politics;

    @Override
    public String toString(){
        return "\n学号"+this.sid+
                "\n姓名"+this.sname+
                "\n性别"+this.sex+
                "\n密码"+this.major+
                "\n分数"+this.point+
                "\n民族"+this.ethnic+
                "\n党员"+this.politics;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public String getEthnic() {
        return ethnic;
    }

    public void setEthnic(String ethnic) {
        this.ethnic = ethnic;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPolitics() {
        return politics;
    }

    public void setPolitics(String politics) {
        this.politics = politics;
    }
}
