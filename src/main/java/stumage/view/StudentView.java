package stumage.view;

import stumage.po.Student;

public interface StudentView {

    public void listStudentALL();

    public void listStudentSin(Integer sid,String sname);

    public void saveStudent();

    public void deleteStudent();

    public void updateStudent(Integer sid,String sname);

}
