package com.aaa.sbm.util;

/**
 * @ fileName:ResultStatus
 * @ description:
 * @ author:zhz
 * @ createTime:2021/12/10 9:31
 * @ version:1.0.0
 */
public enum ResultStatus {
     SUCCESS(200,"操作成功"),
     ERROR(500,"操作失敗");
     private int code;
     private String message;

    ResultStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
