package stumage.view;

public interface CourseView {

    public void listCourseALL();

    public void listCourseSin(Integer cid,String cname);

    public void saveCourse();

    public void deleteCourse();

    public void updateCourse(Integer cid,String cname);
}
