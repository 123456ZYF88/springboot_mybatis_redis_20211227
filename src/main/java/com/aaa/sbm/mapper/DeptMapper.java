package com.aaa.sbm.mapper;/**
 * @ClassName TbDeptDao
 * @Description TODO
 * @Author zhangjiamei
 * @Date 2021/12/13 下午4:01
 * @Version 1.0
 */

import com.aaa.sbm.entity.Dept;
import com.aaa.sbm.util.MyCustomCache;
import org.apache.ibatis.annotations.CacheNamespace;
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
//如果使用的是mybatisplus就可以使用这个注解来缓存
//@CacheNamespace(implementation = MyCustomCache.class)
public interface DeptMapper {
    List<Dept> queryAll();
    int insert(Dept dept);
    int update(Dept dept);
    int deleteById(int deptno);
}
