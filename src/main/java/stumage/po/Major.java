package stumage.po;

public class Major {

    private Integer mid;
    private String mname;
    private String minfo;
    private String mleader;

    @Override
    public String toString(){
        return "\n专业编号："+this.mid+
                "\n专业名称："+this.mname+
                "\n专业介绍："+this.minfo+
                "\n专业带头人："+this.mleader;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMinfo() {
        return minfo;
    }

    public void setMinfo(String minfo) {
        this.minfo = minfo;
    }

    public String getMleader() {
        return mleader;
    }

    public void setMleader(String mleader) {
        this.mleader = mleader;
    }
}
