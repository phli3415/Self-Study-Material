import com.atguigu.mybatis.mapper.DeptMapper;
import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.Dept;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

public class resultMapTest {

    @Test
    public void testGetEmpByEmpId() {
        SqlSession session = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = session.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpByEmpId(1);
        System.out.println(emp);
//      Emp{empId=null, empName='null', age=20, gender='m'}
//      应为表的字段名和属性名不一致，没有映射关系， 无法查询

    }

    @Test
    public void testGetEmpAndDeptByEid() {
        SqlSession session = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = session.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDeptByEmpId(2);
        System.out.println(emp);


    }


    @Test
    public void getEmpAndDeptByStepOne() {
        SqlSession session = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = session.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDeptByStepOne(2);
        System.out.println(emp);


    }

    @Test
    public void TestGetDeptAndEmpByDeptId() {
        SqlSession session = SqlSessionUtil.getSqlSession();
        DeptMapper mapper = session.getMapper(DeptMapper.class);
        Dept emp = mapper.getDeptAndEmpByDeptId(1);
        System.out.println(emp);
    }

    @Test
    public void TestgetDeptAndEmpByStepOne() {
        SqlSession session = SqlSessionUtil.getSqlSession();
        DeptMapper mapper = session.getMapper(DeptMapper.class);
        Dept emp = mapper.getDeptAndEmpByDeptId(1);
        System.out.println(emp);
    }

}
