package com.alivin.mall.tiny.common.api;

/**
 * 封装 API 的错误码
 *
 * @author Fer
 * @date 2021/8/5
 */
public interface IErrorCode {
    long getCode();

    String getMessage();
}
