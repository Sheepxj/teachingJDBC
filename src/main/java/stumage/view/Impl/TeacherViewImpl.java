package stumage.view.Impl;

import stumage.dao.Impl.TeacherDaoImpl;
import stumage.dao.TeacherDao;
import stumage.po.Teacher;
import stumage.view.TeacherView;

import java.util.Scanner;

public class TeacherViewImpl implements TeacherView {

    private Scanner input = new Scanner(System.in);

    @Override
    public Teacher login(){
        System.out.print("请输入老师姓名：");
        String tname = input.next();
        System.out.print("请输入老师密码：");
        String password = input.next();

        TeacherDao tch = new TeacherDaoImpl();
        return tch.getstuByNameByPass(tname,password);
    }

    @Override
    public void updateTeacherBypasword(Integer tid,String tname){

        TeacherDao dao = new TeacherDaoImpl();
        Teacher teacher = dao.getTeacherBytidByname(tid,tname);

        System.out.println("请输入旧密码：");
        String oldpass = input.next();
        if(!teacher.getPassword().equals(oldpass)){
            System.out.println("旧密码输入错误！");
        }else{
            System.out.println("请输入新密码：");
            String password = input.next();
            System.out.println("请再次输入新密码：");
            String newpassword = input.next();
            if(!password.equals(newpassword)){
                System.out.println("两次输入新密码不一致");
            }else{
                int i = dao.updateTeacherBypassword(tid,password);
                if(i>0){
                    System.out.println("重置密码成功！");
                }else{
                    System.out.println("重置密码失败！");
                }
            }
        }


    }
}
