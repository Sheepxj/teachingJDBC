package stumage.dao.Impl;

import stumage.dao.StudentDao;
import stumage.po.Student;
import stumage.util.Dbutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    @Override
    public List<Student> listStudent(){
        Student student = null;
        List<Student> list = new ArrayList<>();
        String sql ="select * from studb.student ";

        try {
            con = Dbutil.getConnection();
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while(rs.next()){
                student = new Student();
                student.setSid(rs.getInt("sid"));
                student.setSname(rs.getString("sname"));
                student.setSex(rs.getString("sex"));
                student.setEthnic(rs.getString("ethnic"));
                student.setMajor(rs.getString("major"));
                student.setPoint(rs.getInt("point"));
                student.setPolitics(rs.getString("politics"));
                list.add(student);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Dbutil.close(rs,pst,con);
        }
        return list;
    }

    @Override
    public int saveStudent(String sname){//新加入某个学生的信息

        int sid = 0;
        String sql = "insert into studb.student(sname) values(?)";
        try {
            con = Dbutil.getConnection();
            //设置返回自增长列值
            pst = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, sname);
            pst.executeUpdate();
            //获取自增长列值（一行一列）
            rs = pst.getGeneratedKeys();
            if(rs.next()) {
                sid = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Dbutil.close(rs, pst, con);
        }
        return sid;

    }

    @Override
    public int deleteStudent(int sid){//删除某行学生的信息

        int result = 0;
        String delStudentSql = "delete from studb.student where sid=?";
        try {
            con = Dbutil.getConnection();
            //开启一个事务
            con.setAutoCommit(false);

            pst = con.prepareStatement(delStudentSql);
            pst.setInt(1, sid);
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
    public Student getstuBysidBysname(int sid,String sname){//获取学生表某行的信息

        Student student = null;
        String sql = "select * from studb.student where sid=? and sname=?";
        try {
            con = Dbutil.getConnection();
            pst = con.prepareStatement(sql.toString());
            pst.setInt(1, sid);
            pst.setString(2, sname);
            rs = pst.executeQuery();
            while(rs.next()) {
                student = new Student();
                student.setSid(rs.getInt("sid"));
                student.setSname(rs.getString("sname"));
                student.setSex(rs.getString("sex"));
                student.setEthnic(rs.getString("ethnic"));
                student.setMajor(rs.getString("major"));
                student.setPoint(rs.getInt("point"));
                student.setPolitics(rs.getString("politics"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Dbutil.close(rs, pst, con);
        }
        return student;

    }

    @Override
    public int updateStudent(Student student){//根据学号更新学生表的信息，即学号是不可更改的

        int result = 0;
        String sql = "update studb.student set sname=?,sex=?,ethnic=?,major=?,point=?,politics=? where sid=?";
        try {
            con = Dbutil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, student.getSname());
            pst.setString(2, student.getSex());
            pst.setString(3, student.getEthnic());
            pst.setString(4, student.getMajor());
            pst.setInt(5, student.getPoint());
            pst.setString(6,student.getPolitics());
            pst.setInt(7, student.getSid());
            result = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Dbutil.close(null, pst, con);
        }
        return result;

    }

}
