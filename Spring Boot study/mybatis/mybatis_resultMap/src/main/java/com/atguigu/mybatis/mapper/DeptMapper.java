package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {

    //分步查询员工所对应的部门信息的第二步
    Dept getEmpDeptByStepTwo(@Param("id") Integer id);

//    查询部门中的员工信息
    Dept getDeptAndEmpByDeptId(@Param("id") Integer id);

    //    通过分布查询查询部门中的员工信息
    Dept getDeptAndEmpByStepOne(@Param("id") Integer id);
}
