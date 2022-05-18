package stumage.dao;

import stumage.po.Major;
import stumage.po.Student;

import java.util.List;

public interface MajorDao {

    public List<Major> listMajor();//打印所有专业

    public int saveMajor(String mname);//新增专业

    public Major getmajorBymidBymname(int mid,String mname);//通过mid和mname获取某一专业的信息

    public int deleteMajor(int mid);//删除某个专业

    public int updateMajor(Major major);//更新专业信息
}
