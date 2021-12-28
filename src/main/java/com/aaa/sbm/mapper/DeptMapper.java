package com.aaa.sbm.mapper;/**
 * @ClassName TbDeptDao
 * @Description TODO
 * @Author zhangjiamei
 * @Date 2021/12/13 下午4:01
 * @Version 1.0
 */

import com.aaa.sbm.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


/**
 *@ClassName TbDeptDao
 *@Description:
 *@Author zhangjiamei
 *@Date 2021/12/13 下午4:01
 *@Version 1.0
 */

public interface DeptMapper {
    List<Dept> queryAll();
    int insert(Dept dept);
    int update(Dept dept);
    int deleteById(int deptno);
}
