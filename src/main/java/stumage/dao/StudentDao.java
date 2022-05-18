package stumage.dao;

import stumage.po.Student;

import java.util.List;

public interface StudentDao {

    public List<Student>  listStudent();//按sname和smajor输出学生信息

    public int saveStudent(String sname);//新建学生信息

    public int deleteStudent(int sid);//删除学生信息

    public Student getstuBysidBysname(int sid,String sname);//通过sid和sname获取学生信息

    public int updateStudent(Student student);//更新学生信息
}
