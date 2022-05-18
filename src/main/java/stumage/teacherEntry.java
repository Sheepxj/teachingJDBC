package stumage;

import java.util.Scanner;

import stumage.dao.Impl.TeacherDaoImpl;
import stumage.dao.TeacherDao;
import stumage.po.Student;
import stumage.po.Teacher;
import stumage.view.Impl.TeacherViewImpl;
import stumage.view.StudentView;
import stumage.view.CourseView;
import stumage.view.MajorView;
import stumage.view.Impl.StudentViewImpl;
import stumage.view.Impl.CourseViewImpl;
import stumage.view.Impl.MajorViewImpl;
import stumage.view.TeacherView;

public class teacherEntry {

    public void work() {

        Scanner input = new Scanner(System.in);

        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("|\t\t\t\t\t\t\t\t 学生信息管理系统  \t\t\t\t\t\t\t\t|");
        System.out.println("---------------------------------------------------------------------------------");

        // TeacherView teacherview = new TeacherViewImpl();
        // Teacher teacher = teacherview.login();

        if(true){

            int menu = 0;
            while(menu != 5){
            //    输出主菜单
                System.out.println();
                System.out.println(("========== 1.学生信息查询=2.课程信息查询=3.专业信息查询=4.修改账号信息=5.退出系统 =========="));
                System.out.println("请输入您的选择：");
                menu = input.nextInt();

                switch (menu){
                    case 1:
                        work1();
                        break;

                    case 2:
                        work2();
                        break;

                    case 3:
                        work3();
                        break;

                    case 4:
                        TeacherView teacherView = new TeacherViewImpl();
                        System.out.println("请输入老师职工号：");
                        Integer tid = input.nextInt();
                        System.out.println("请输入老师名称：");
                        String tname = input.next();
                        teacherView.updateTeacherBypasword(tid,tname);

                    case 5:
                        System.out.println();
                        System.out.println("# # # # # # # \t\t\t\t\t 欢迎下次使用本系统 \t\t\t\t\t # # # # # # #");

                }
            }
        }else{
            System.out.println("\n教师名称和密码使用有误\n");
        }

    }

    public void work1(){

        Scanner input = new Scanner(System.in);
        int menu1 = 0;

        StudentView studentView = new StudentViewImpl();

        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("|\t\t\t\t\t\t\t\t 学生信息管理处       \t\t\t\t\t\t\t\t|");
        System.out.println("---------------------------------------------------------------------------------");


        while(menu1!=6){

            System.out.println();
            System.out.println("******* 1.查看所有学生*2.查看单个学生*3.新建学生*4.删除学生*5.更新学生信息*6.退出系统 *******");
            System.out.println("请输入您的选择：");
            menu1 = input.nextInt();

            switch (menu1){
                case 1:
                    System.out.println("||\t\t\t\t\t\t学生列表如下\t\t\t\t\t\t||");
                    studentView.listStudentALL();
                    break;

                case 2:
                    System.out.println("请输入学生学号：");
                    int sid = input.nextInt();
                    System.out.println("请输入学生姓名：");
                    String sname = input.next();
                    System.out.println("||\t\t\t该学生信息如下\t\t\t||");
                    studentView.listStudentSin(sid,sname);
                    break;

                case 3:
                    studentView.saveStudent();
                    break;

                case 4:
                    studentView.deleteStudent();
                    break;

                case 5:
                    System.out.println("请输入学生学号：");
                    int sid1 = input.nextInt();
                    System.out.println("请输入学生姓名：");
                    String sname1 = input.next();
                    studentView.updateStudent(sid1,sname1);
                    break;
            }
        }
    }//第一子菜单

    public void work2(){

        Scanner input = new Scanner(System.in);
        int menu2 = 0;

        CourseView courseView = new CourseViewImpl();

        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("|\t\t\t\t\t\t\t\t 课程信息管理处       \t\t\t\t\t\t\t\t|");
        System.out.println("---------------------------------------------------------------------------------");

        while(menu2!=6){

            System.out.println();
            System.out.println("******* 1.查看课程信息*2.查看单个课程*3.新建课程*4.删除课程*5.更新课程信息*6.退出系统 *******");
            System.out.println("请输入您的选择：");
            menu2 = input.nextInt();

            switch (menu2){

                case 1:
                    System.out.println("||\t\t\t课程列表如下\t\t\t||");
                    courseView.listCourseALL();
                    break;

                case 2:
                    System.out.println("请输入课程号：");
                    int cid = input.nextInt();
                    System.out.println("请输入课程名：");
                    String cname = input.next();
                    System.out.println("||\t\t\t该课程信息如下\t\t\t||");
                    courseView.listCourseSin(cid,cname);
                    break;

                case 3:
                    courseView.saveCourse();
                    break;

                case 4:
                    courseView.deleteCourse();
                    break;

                case 5:
                    System.out.println("请输入课程号：");
                    int cid1 = input.nextInt();
                    System.out.println("请输入课程名：");
                    String cname1 = input.next();
                    courseView.updateCourse(cid1,cname1);
                    break;

            }

        }

    }//第二子菜单

    public void work3(){

        Scanner input = new Scanner(System.in);
        int menu3 = 0;

        MajorView majorView = new MajorViewImpl();

        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("|\t\t\t\t\t\t\t\t 专业信息管理处       \t\t\t\t\t\t\t\t|");
        System.out.println("---------------------------------------------------------------------------------");

        while(menu3!=6){

            System.out.println();
            System.out.println("******* 1.查看专业信息*2.查看单个专业*3.新建专业*4.删除专业*5.更新专业信息*6.退出系统 *******");
            System.out.println("请输入您的选择：");
            menu3 = input.nextInt();

            switch (menu3){

                case 1:
                    System.out.println("||\t\t\t\t\t\t专业列表如下\t\t\t\t\t\t||");
                    majorView.listMajorALL();
                    break;

                case 2:
                    System.out.println("请输入专业号：");
                    int mid = input.nextInt();
                    System.out.println("请输入专业名：");
                    String mname = input.next();
                    System.out.println("||\t\t\t该专业信息如下\t\t\t||");
                    majorView.listMajorSin(mid,mname);
                    break;

                case 3:
                    majorView.saveMajor();
                    break;

                case 4:
                    majorView.deleteMajor();
                    break;

                case 5:
                    System.out.println("请输入专业号：");
                    int mid1 = input.nextInt();
                    System.out.println("请输入专业名：");
                    String mname1 = input.next();
                    majorView.updateMajor(mid1,mname1);
                    break;

            }

        }

    }//第三子菜单

    public static void main(String[] args) {new teacherEntry().work();}

}
