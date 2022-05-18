package stumage.dao;

import stumage.po.Course;
import stumage.po.Student;

import java.util.List;

public interface CourseDao {

    public List<Course> listCourse();//按sname和smajor输出学生信息

    public int saveCourse(String cname);//新建学生信息

    public int deleteCourse(int cid);//删除学生信息

    public Course getcouBycidBycname(int cid,String cname);//通过sid和sname获取学生信息

    public int updateCourse(Course course);//更新学生信息
}
