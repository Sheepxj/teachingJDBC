package stumage.dao.Impl;

import stumage.dao.MajorDao;
import stumage.po.Major;
import stumage.po.Student;
import stumage.util.Dbutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MajorDaoImpl implements MajorDao {

    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    @Override
    public List<Major> listMajor(){

        Major major = null;
        List<Major> list = new ArrayList<>();
        String sql ="select * from studb.major ";

        try {
            con = Dbutil.getConnection();
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while(rs.next()){
                major = new Major();
                major.setMid(rs.getInt("mid"));
                major.setMname(rs.getString("mname"));
                major.setMinfo(rs.getString("minfo"));
                major.setMleader(rs.getString("mleader"));
                list.add(major);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Dbutil.close(rs,pst,con);
        }
        return list;

    }

    @Override
    public int saveMajor(String mname){

        int mid = 0;
        String sql = "insert into studb.major(mname) values(?)";
        try {
            con = Dbutil.getConnection();
            //设置返回自增长列值
            pst = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setString(1, mname);
            pst.executeUpdate();
            //获取自增长列值（一行一列）
            rs = pst.getGeneratedKeys();
            if(rs.next()) {
                mid = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Dbutil.close(rs, pst, con);
        }
        return mid;

    }

    @Override
    public Major getmajorBymidBymname(int mid,String mname){

        Major major = null;
        String sql = "select * from studb.major where mid=? and mname=?";
        try {
            con = Dbutil.getConnection();
            pst = con.prepareStatement(sql.toString());
            pst.setInt(1, mid);
            pst.setString(2, mname);
            rs = pst.executeQuery();
            while(rs.next()) {
                major = new Major();
                major.setMid(rs.getInt("mid"));
                major.setMname(rs.getString("mname"));
                major.setMinfo(rs.getString("minfo"));
                major.setMleader(rs.getString("mleader"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Dbutil.close(rs, pst, con);
        }
        return major;

    }

    @Override
    public int deleteMajor(int mid){

        int result = 0;
        String delStudentSql = "delete from studb.major where mid=?";
        try {
            con = Dbutil.getConnection();
            //开启一个事务
            con.setAutoCommit(false);

            pst = con.prepareStatement(delStudentSql);
            pst.setInt(1, mid);
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
    public int updateMajor(Major major){

        int result = 0;
        String sql = "update studb.major set mname=?,minfo=?,mleader=? where mid=?";
        try {
            con = Dbutil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, major.getMname());
            pst.setString(2, major.getMinfo());
            pst.setString(3, major.getMleader());
            pst.setInt(4, major.getMid());
            result = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Dbutil.close(null, pst, con);
        }
        return result;

    }


}
