package com.aaa.sbm.controller;/**
 * @ClassName DeptController
 * @Description TODO
 * @Author zhangjiamei
 * @Date 2021/12/13 下午4:18
 * @Version 1.0
 */

import com.aaa.sbm.entity.Dept;
import com.aaa.sbm.service.DeptService;

import com.aaa.sbm.util.Result;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import java.util.Map;

/**
 *@ClassName DeptController
 *@Description:
 *@Author zhangjiamei
 *@Date 2021/12/13 下午4:18
 *@Version 1.0
 */
@RequestMapping("/dept")
@RestController
//@Slf4j
@ApiOperation("部门管理控制器")
public class DeptController extends BaseController {
    @Resource
    private DeptService deptService;

    private Logger logger = LoggerFactory.getLogger(DeptController.class);
    /**
     * 查询所有
     * @return
     */
    @GetMapping("/queryAll")
    @ApiOperation("查询所有部门")
    public Result queryAll() {
        logger.info("进入了部门查询方法。。。。");
        //System.out.println();
        Result success = success(deptService.queryAll());
        logger.info("部门查询方法结束。。。。");
        return success;
    }

    /**
     * 添加
     * @param dept
     * @return
     */
    @PostMapping("add")
    @ApiOperation("部门添加")

    //public  Result insert(@RequestBody  @ApiParam("部门对象") Dept dept){
    public  Result insert(@RequestBody  @ApiParam("部门对象")  Dept dept){
        return success(deptService.insert(dept));

    }
    /**
     * 更新
     * @param dept
     * @return
     */
    @PutMapping("/update")
    public  Result update(@RequestBody  Dept dept){
        return success(deptService.update(dept));
    }

    /**
     * 根据编号删除
     * @param deptNo
     * @return
     */
    @DeleteMapping("/delete")
    public  Result delete(Integer deptNo){
        return success(deptService.deleteById(deptNo));
    }
}
