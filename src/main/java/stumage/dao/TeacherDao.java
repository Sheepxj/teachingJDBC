package stumage.dao;

import stumage.po.Teacher;

public interface TeacherDao {

    public Teacher getstuByNameByPass(String tname, String password);
    //获取teacher对象

    public int updateTeacherBypassword(Integer tid,String password);
    //更新密码

    public Teacher getTeacherBytidByname(Integer tid,String tname);
    //获取teacher对象
}
