package com.aaa.sbm.controller;

import com.aaa.sbm.util.Result;
import com.aaa.sbm.util.ResultStatus;


/**
 * @ fileName:BaseController
 * @ description:
 * @ author:zhz
 * @ createTime:2021/12/10 9:34
 * @ version:1.0.0
 */
public class BaseController {

    /**
     * 封裝成功方法
     * @param <T>
     * @param t
     * @return
     */
    protected <T> Result success(T t){
        return new Result<T>(ResultStatus.SUCCESS.getCode(),
                ResultStatus.SUCCESS.getMessage(),t);
    }
    /**
     * 封裝失敗方法
     * @param t
     * @param <T>
     * @return
     */
    protected <T> Result<T> error(T t){
        return new Result<T>(ResultStatus.ERROR.getCode(),
                ResultStatus.ERROR.getMessage(),t);
    }



}
