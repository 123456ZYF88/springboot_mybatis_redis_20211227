package com.aaa.sbm.service;/**
 * @ClassName DeptServer
 * @Description TODO
 * @Author zhangjiamei
 * @Date 2021/12/13 下午4:01
 * @Version 1.0
 */

import com.aaa.sbm.entity.Dept;

import java.util.List;
import java.util.Map;

/**
 *@ClassName DeptServer
 *@Description:
 *@Author zhangjiamei
 *@Date 2021/12/13 下午4:01
 *@Version 1.0
 */
public interface DeptService {
    List<Dept> queryAll();
    int insert(Dept dept);
    int update(Dept dept);
    int deleteById(int deptno);
}
