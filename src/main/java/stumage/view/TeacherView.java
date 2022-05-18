package stumage.view;

import stumage.po.Teacher;

public interface TeacherView {

    public Teacher login();//登录系统

    public void updateTeacherBypasword(Integer tid,String tname);//更新密码
}
