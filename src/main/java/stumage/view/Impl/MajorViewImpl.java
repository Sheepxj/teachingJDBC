package stumage.view.Impl;

import stumage.dao.Impl.MajorDaoImpl;
import stumage.dao.Impl.StudentDaoImpl;
import stumage.dao.MajorDao;
import stumage.dao.StudentDao;
import stumage.po.Major;
import stumage.po.Student;
import stumage.view.MajorView;

import java.util.List;
import java.util.Scanner;

public class MajorViewImpl implements MajorView {

    Scanner input = new Scanner(System.in);

    @Override
    public void listMajorALL(){
        MajorDao dao = new MajorDaoImpl();
        List<Major> list = dao.listMajor();
        System.out.println("\t专业号\t专业名\t\t\t专业介绍\t\t\t专业领头人");
        for(Major major : list){
            System.out.printf("\t%-8d%-8s%-20s%-8s",major.getMid(),major.getMname(),major.getMinfo(),major.getMleader());
            System.out.println();
        }
    }

    @Override
    public void saveMajor(){

        System.out.println("请输入专业名：");
        String mname = input.next();
        MajorDao dao = new MajorDaoImpl();
        int mid = dao.saveMajor(mname);
        if(mid>0) {
            System.out.println("插入专业成功！新专业号为："+mid);
        }else {
            System.out.println("新建专业插入失败！");
        }

    }

    @Override
    public void listMajorSin(Integer mid,String mname){

        MajorDao dao = new MajorDaoImpl();
        Major major = dao.getmajorBymidBymname(mid,mname);
        System.out.println(major);

    }

    @Override
    public void deleteMajor(){

        System.out.println("请输入要删除专业的学号：");
        int mid = input.nextInt();

        MajorDao dao = new MajorDaoImpl();
        System.out.println("确认要删除吗(y/n)：");
        if(input.next().equals("y")) {
            int result = dao.deleteMajor(mid);
            if(result==1) {
                System.out.println("删除专业信息成功！");
            }else {
                System.out.println("删除专业信息失败！");
            }
        }

    }

    @Override
    public void updateMajor(Integer mid,String mname){

        MajorDao dao = new MajorDaoImpl();
        Major business = dao.getmajorBymidBymname(mid,mname);
        System.out.println(business);

        String inputStr = "";
        System.out.println("是否修改专业名(y/n)：");
        inputStr = input.next();
        if(inputStr.equals("y")) {
            System.out.println("请输入新的专业名：");
            business.setMname(input.next());
        }

        System.out.println("是否修改专业介绍(y/n)：");
        inputStr = input.next();
        if(inputStr.equals("y")) {
            System.out.println("请输入新的专业介绍：");
            business.setMinfo(input.next());
        }

        System.out.println("是否修改专业领头人(y/n)：");
        inputStr = input.next();
        if(inputStr.equals("y")) {
            System.out.println("请输入新的专业领头人：");
            business.setMleader(input.next());
        }



        int result = dao.updateMajor(business);
        if(result>0) {
            System.out.println("\n修改专业信息成功！\n");
        }else {
            System.out.println("\n修改专业信息失败！\n");
        }

    }
}
