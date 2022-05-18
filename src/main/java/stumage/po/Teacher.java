package stumage.po;

public class Teacher {

    private Integer tid;
    private String tname;
    private String password;

    @Override
    public String toString(){
        return "\n教师编号"+this.tid+
                "\n姓名"+this.tname+
                "\n密码"+this.password;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
