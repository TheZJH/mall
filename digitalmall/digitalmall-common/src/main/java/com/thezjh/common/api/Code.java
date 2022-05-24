package com.thezjh.common.api;

/**
 * @author thezjh
 * @create 2022/5/7 下午12:04
 */
public interface Code {
    /**
     * 状态码
     * @return
     */
    long getCode();

    /**
     * 提示信息
     * @return
     */
    String getMessage();

}
