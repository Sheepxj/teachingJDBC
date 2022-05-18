package stumage.view.Impl;

import java.util.List;
import java.util.Scanner;

import stumage.dao.StudentDao;
import stumage.dao.Impl.StudentDaoImpl;
import stumage.po.Student;
import stumage.view.StudentView;

public class StudentViewImpl implements StudentView {

    Scanner input = new Scanner(System.in);

    @Override
    public void listStudentALL(){

        StudentDao dao = new StudentDaoImpl();
        List<Student> list = dao.listStudent();
        System.out.println("\t学号\t\t姓名\t\t性别\t\t民族\t\t\t专业\t\t分数\t\t\t党员");
        for(Student stu : list){
            System.out.printf("\t%-8d%-8s%-8s%-8s%-8s%-8d%-8s",stu.getSid(),stu.getSname(),stu.getSex(),stu.getEthnic(),stu.getMajor(),stu.getPoint(),stu.getPolitics());
            System.out.println();
        }
    }//查询全部

    @Override
    public void listStudentSin(Integer sid,String sname){

        // int sid = 0;
        // System.out.println("请输入学生学号：");
        // sid = input.nextInt();
        //
        // StudentDao dao = new StudentDaoImpl();
        // List<Student> list = dao.listStudentSin(sid);
        // System.out.println("\t学号\t姓名\t性别\t民族\t专业\t分数\t党员");
        // for(Student stu : list){
        //     System.out.println("\t"+stu.getSid()+"\t"+stu.getSname()+"\t"+stu.getSex()+"\t"+stu.getEthnic()+"\t"+stu.getMajor()+"\t"+stu.getPoint()+"\t"+stu.getPolitics()+"\t");
        // }
        //错误代码

        StudentDao dao = new StudentDaoImpl();
        Student student = dao.getstuBysidBysname(sid,sname);
        System.out.println(student);

    }//查询某一行

    @Override
    public void saveStudent(){

        System.out.println("请输入学生姓名：");
        String sname = input.next();
        StudentDao dao = new StudentDaoImpl();
        int sid = dao.saveStudent(sname);
        if(sid>0) {
            System.out.println("插入学生信息成功！新同学学号为："+sid);
        }else {
            System.out.println("学生信息插入失败！");
        }

    }//新增学生

    @Override
    public void deleteStudent(){

        System.out.println("请输入要删除学生的学号：");
        int sid = input.nextInt();

        StudentDao dao = new StudentDaoImpl();
        System.out.println("确认要删除吗(y/n)：");
        if(input.next().equals("y")) {
            int result = dao.deleteStudent(sid);
            if(result==1) {
                System.out.println("删除学生信息成功！");
            }else {
                System.out.println("删除学生信息失败！");
            }
        }

    }//删除学生

    @Override
    public void updateStudent(Integer sid,String sname){

        StudentDao dao = new StudentDaoImpl();
        Student business = dao.getstuBysidBysname(sid,sname);
        System.out.println(business);

        String inputStr = "";
        System.out.println("是否修改学生姓名(y/n)：");
        inputStr = input.next();
        if(inputStr.equals("y")) {
            System.out.println("请输入新的学生姓名：");
            business.setSname(input.next());
        }

        System.out.println("是否修改学生性别(y/n)：");
        inputStr = input.next();
        if(inputStr.equals("y")) {
            System.out.println("请输入新的学生性别：");
            business.setSex(input.next());
        }

        System.out.println("是否修改学生民族(y/n)：");
        inputStr = input.next();
        if(inputStr.equals("y")) {
            System.out.println("请输入新的学生民族：");
            business.setEthnic(input.next());
        }

        System.out.println("是否修改学生专业(y/n)：");
        inputStr = input.next();
        if(inputStr.equals("y")) {
            System.out.println("请输入新的学生专业：");
            business.setMajor(input.next());
        }

        System.out.println("是否修改分数(y/n)：");
        inputStr = input.next();
        if(inputStr.equals("y")) {
            System.out.println("请输入新的分数：");
            business.setPoint(input.nextInt());
        }

        System.out.println("是否修改党员(y/n)：");
        inputStr = input.next();
        if(inputStr.equals("y")) {
            System.out.println("请输入新的党员：");
            business.setPolitics(input.next());
        }

        int result = dao.updateStudent(business);
        if(result>0) {
            System.out.println("\n修改学生信息成功！\n");
        }else {
            System.out.println("\n修改学生信息失败！\n");
        }

    }//更新学生信息

}
