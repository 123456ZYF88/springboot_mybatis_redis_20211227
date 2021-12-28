package com.aaa.sbm.service.impl;/**
 * @ClassName DeptServerImpl
 * @Description TODO
 * @Author zhangjiamei
 * @Date 2021/12/13 下午4:13
 * @Version 1.0
 */

import com.aaa.sbm.entity.Dept;
import com.aaa.sbm.mapper.DeptMapper;
import com.aaa.sbm.service.DeptService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 *@ClassName DeptServerImpl
 *@Description:
 *@Author zhangjiamei
 *@Date 2021/12/13 下午4:13
 *@Version 1.0
 */
@Service
public class DeptServiceImpl implements DeptService {
    @Resource
    private DeptMapper deptMapper;

    @Override
    public List<Dept> queryAll () {
        return deptMapper.queryAll();
    }

    @Override
    public int insert (Dept dept) {
        return deptMapper.insert(dept);
    }

    @Override
    public int update (Dept dept) {
        return deptMapper.update(dept);
    }

    @Override
    //@Transactional
    public int deleteById (int deptno) {
       // deptMapper.deleteById(1)
       // deptMapper.deleteById(2)
        return deptMapper.deleteById(deptno);
    }
}
