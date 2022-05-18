package stumage.dao.Impl;

import stumage.dao.CourseDao;
import stumage.po.Course;
import stumage.po.Student;
import stumage.util.Dbutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoImpl implements CourseDao {

    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    @Override
    public List<Course> listCourse(){

        Course course = null;
        List<Course> list = new ArrayList<>();
        String sql ="select * from studb.course ";

        try {
            con = Dbutil.getConnection();
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while(rs.next()){
                course = new Course();
                course.setCid(rs.getInt("cid"));
                course.setCname(rs.getString("cname"));
                course.setCtime(rs.getInt("ctime"));
                course.setCpoint(rs.getInt("cpoint"));
                list.add(course);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Dbutil.close(rs,pst,con);
        }
        return list;

    }

    @Override
    public int saveCourse(String cname){

        int cid = 0;
        String sql = "insert into studb.course(cname) values(?)";
        try {
            con = Dbutil.getConnection();
            //设置返回自增长列值
            pst = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, cname);
            pst.executeUpdate();
            //获取自增长列值（一行一列）
            rs = pst.getGeneratedKeys();
            if(rs.next()) {
                cid = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Dbutil.close(rs, pst, con);
        }
        return cid;

    }

    //
    @Override
    public int deleteCourse(int cid){

        int result = 0;
        String delStudentSql = "delete from studb.course where cid=?";
        try {
            con = Dbutil.getConnection();
            //开启一个事务
            con.setAutoCommit(false);
            pst = con.prepareStatement(delStudentSql);
            pst.setInt(1, cid);
            result = pst.executeUpdate();

            con.commit();
        } catch (SQLException e) {
            result = 0;
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            Dbutil.close(null, pst, con);
        }
        return result;

    }


    @Override
    public Course getcouBycidBycname(int cid,String cname){

        Course course = null;
        String sql = "select * from studb.course where cid=? and cname=?";
        try {
            con = Dbutil.getConnection();
            pst = con.prepareStatement(sql.toString());
            pst.setInt(1, cid);
            pst.setString(2, cname);
            rs = pst.executeQuery();
            while(rs.next()) {
                course = new Course();
                course.setCid(rs.getInt("cid"));
                course.setCname(rs.getString("cname"));
                course.setCtime(rs.getInt("ctime"));
                course.setCpoint(rs.getInt("cpoint"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Dbutil.close(rs, pst, con);
        }
        return course;

    }

    @Override
    public int updateCourse(Course course){

        int result = 0;
        String sql = "update studb.course set cname=?,ctime=?,cpoint=? where cid=?";
        try {
            con = Dbutil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, course.getCname());
            pst.setInt(2, course.getCtime());
            pst.setInt(3, course.getCpoint());
            pst.setInt(4, course.getCid());
            result = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Dbutil.close(null, pst, con);
        }
        return result;

    }
}
