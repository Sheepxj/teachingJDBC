package stumage.dao.Impl;

import stumage.dao.TeacherDao;
import stumage.po.Teacher;
import stumage.util.Dbutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherDaoImpl implements TeacherDao {

    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    @Override
    public Teacher getstuByNameByPass(String tname, String password){
        Teacher tch = null;
        String sql = "select * from studb.teacher  where tname=? and password=?";
        try{
            con = Dbutil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1,tname);
            pst.setString(2,password);
            rs = pst.executeQuery();
            while(rs.next()){
                tch = new Teacher();
                tch.setTid(rs.getInt("tid"));
                tch.setTname(rs.getString("tname"));
                tch.setPassword(rs.getString("password"));

            }
        }catch (SQLException a){
            a.printStackTrace();
        }finally {
            Dbutil.close(rs,pst,con);
        }
        return tch;
    }

    @Override
    public int updateTeacherBypassword(Integer tid,String password){

        int result = 0;
        String sql = "update studb.teacher set password=? where tid=?";
        try {
            con = Dbutil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, password);
            pst.setInt(2, tid);
            result = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Dbutil.close(null, pst, con);
        }
        return result;

    }

    @Override
    public Teacher getTeacherBytidByname(Integer tid,String tname){

        Teacher teacher = null;
        String sql = "select * from studb.teacher where tid=? and tname=?";

        try{
            con = Dbutil.getConnection();
            pst = con.prepareStatement(sql.toString());
            pst.setInt(1,tid);
            pst.setString(2,tname);
            rs = pst.executeQuery();
            while(rs.next()){
                teacher = new Teacher();
                teacher.setTid(rs.getInt("tid"));
                teacher.setTname(rs.getString("tname"));
                teacher.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Dbutil.close(rs,pst,con);
        }
        return teacher;

    }
}
