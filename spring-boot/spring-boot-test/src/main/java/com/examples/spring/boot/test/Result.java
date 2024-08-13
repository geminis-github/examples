package com.examples.spring.boot.test;

import lombok.Data;

/**
 * 控制器实体类返回封装
 *
 * @author Thinking9527
 * @date 2022-12-15 22:55
 */
@Data
public class Result <T> {

    private Integer code;
    private String msg;
    private T obj;

    public static <T> Result<T> success(T obj) {
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMsg("success");
        result.setObj(obj);
        return result;
    }

}
