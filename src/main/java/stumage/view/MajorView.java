package stumage.view;

public interface MajorView {

    public void listMajorALL();//查看全部专业

    public void saveMajor();//新增专业

    public void listMajorSin(Integer mid,String mname);//按mid和mname查询某个专业

    public void deleteMajor();//删除某个专业

    public void updateMajor(Integer mid,String mname);//更新专业信息
}
