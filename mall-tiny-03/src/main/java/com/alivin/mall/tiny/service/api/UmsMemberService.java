package com.alivin.mall.tiny.service.api;

import com.alivin.mall.tiny.common.impl.CommonResult;

/**
 * 会员管理
 *
 * @author Fer
 * @date 2021/8/9
 */
public interface UmsMemberService {

    /**
     * 生成验证码
     */
    CommonResult<String> generateAuthCode(String telephone);

    /**
     * 判断验证码和手机号码是否匹配
     */
    CommonResult<String> verifyAuthCode(String telephone, String authCode);

}
