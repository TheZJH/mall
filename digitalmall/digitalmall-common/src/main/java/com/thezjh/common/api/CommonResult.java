package com.thezjh.common.api;

import org.springframework.stereotype.Component;

/**
 * @author thezjh
 * @create 2022/4/14 下午5:58
 */
@Component
public class CommonResult<T> {
    /**
     * 状态码
     */
    private long code;
    /**
     * 提示信息
     */
    private String message;

    /**
     * 数据封装
     */
    private T data;

    public CommonResult(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public CommonResult() {
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * 返回失败结果
     * @param message
     * @return
     */
    public CommonResult<T> failed(String message) {
        return new CommonResult<T>(ResultCode.FAILED.getCode(), message, null);
    }

    /**
     * 返回参数不对结果
     * @param message
     * @return
     */
    public CommonResult<T> validatefailed(String message){
        return new CommonResult<>(ResultCode.VALIDATE_FAILED.getCode(), message,null);
    }

    /**
     * 成功返回参数
     * @param data
     * @return
     */
    public CommonResult<T> success(T data){
        return new CommonResult<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(),data);
    }
}
