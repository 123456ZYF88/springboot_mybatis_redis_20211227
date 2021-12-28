package com.aaa.sbm.entity;/**
 * @ClassName Dept
 * @Description TODO
 * @Author zhangjiamei
 * @Date 2021/12/13 下午3:58
 * @Version 1.0
 */

import lombok.Data;

import java.io.Serializable;

/**
 *@ClassName Dept
 *@Description:
 *@Author zhangjiamei
 *@Date 2021/12/13 下午3:58
 *@Version 1.0
 */
@Data
public class Dept implements Serializable {
    private int deptno;
    private String dname;
    private String loc;
}
