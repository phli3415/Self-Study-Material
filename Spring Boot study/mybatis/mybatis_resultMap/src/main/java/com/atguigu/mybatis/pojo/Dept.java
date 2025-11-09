package com.atguigu.mybatis.pojo;

import java.util.List;

public class Dept {
    private String deptName;
    private int deptId;
    private List<Emp> emps;

    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptName='" + deptName + '\'' +
                ", deptId=" + deptId +
                ", emps=" + emps +
                '}';
    }

    public Dept(String deptName, int deptId) {
        this.deptName = deptName;
        this.deptId = deptId;
    }

    public Dept() {
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }
}
