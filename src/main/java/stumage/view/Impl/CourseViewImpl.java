package stumage.view.Impl;

import stumage.dao.CourseDao;
import stumage.dao.Impl.CourseDaoImpl;
import stumage.dao.Impl.StudentDaoImpl;
import stumage.dao.StudentDao;
import stumage.po.Course;
import stumage.po.Student;
import stumage.view.CourseView;

import java.util.List;
import java.util.Scanner;

public class CourseViewImpl implements CourseView {

    Scanner input = new Scanner(System.in);

    @Override
    public void listCourseALL(){

        CourseDao dao = new CourseDaoImpl();
        List<Course> list = dao.listCourse();
        System.out.println("\t课程号\t课程名\t课程时长\t学分");
        for(Course cou : list){
            System.out.printf("\t%-8d%-8s%-7d%-8d",cou.getCid(),cou.getCname(),cou.getCtime(),cou.getCpoint());
            System.out.println();
        }

    }


    @Override
    public void saveCourse(){

        System.out.println("请输入课程名：");
        String cname = input.next();
        CourseDao dao = new CourseDaoImpl();
        int sid = dao.saveCourse(cname);
        if(sid>0) {
            System.out.println("插入课程信息成功！新课程号为："+sid);
        }else {
            System.out.println("新课程信息插入失败！");
        }

    }

    @Override
    public void listCourseSin(Integer cid,String cname){

        CourseDao dao = new CourseDaoImpl();
        Course course = dao.getcouBycidBycname(cid,cname);
        System.out.println(course);

    }

    @Override
    public void deleteCourse(){

        System.out.println("请输入要删除课程的课程号：");
        int cid = input.nextInt();

        CourseDao dao = new CourseDaoImpl();
        System.out.println("确认要删除吗(y/n)：");
        if(input.next().equals("y")) {
            int result = dao.deleteCourse(cid);
            if(result==1) {
                System.out.println("删除课程信息成功！");
            }else {
                System.out.println("删除课程信息失败！");
            }
        }

    }

    @Override
    public void updateCourse(Integer cid,String cname){

        CourseDao dao = new CourseDaoImpl();
        Course course = dao.getcouBycidBycname(cid,cname);
        System.out.println(course);

        String inputStr = "";
        System.out.println("是否修改课程名(y/n)：");
        inputStr = input.next();
        if(inputStr.equals("y")) {
            System.out.println("请输入新的课程名：");
            course.setCname(input.next());
        }

        System.out.println("是否修改课程学时(y/n)：");
        inputStr = input.next();
        if(inputStr.equals("y")) {
            System.out.println("请输入新的课程学时：");
            course.setCtime(input.nextInt());
        }

        System.out.println("是否修改课程学分(y/n)：");
        inputStr = input.next();
        if(inputStr.equals("y")) {
            System.out.println("请输入新的课程学分：");
            course.setCpoint(input.nextInt());
        }



        int result = dao.updateCourse(course);
        if(result>0) {
            System.out.println("\n修改课程信息成功！\n");
        }else {
            System.out.println("\n修改课程信息失败！\n");
        }

    }

}
