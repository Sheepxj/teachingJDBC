package stumage.po;

public class Course {

    private Integer cid;
    private String cname;
    private Integer ctime;
    private Integer cpoint;

    @Override
    public String toString(){
        return "\n课程号："+this.cid+
                "\n课程名："+this.cname+
                "\n课程学时："+this.ctime+
                "\n课程学分："+this.cpoint;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getCtime() {
        return ctime;
    }

    public void setCtime(Integer ctime) {
        this.ctime = ctime;
    }

    public Integer getCpoint() {
        return cpoint;
    }

    public void setCpoint(Integer cpoint) {
        this.cpoint = cpoint;
    }
}
