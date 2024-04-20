package com.wd.demo.chain.checkChain;

public class CheckChainTest {
    public static void main(String[] args) {
        ResponseResult responseResult = ValidUtils.validParam("123", "第一个字符串为空").andValid(() -> ValidUtils.validParam(1, "第二个参数为空")).andValid(() -> ValidUtils.validParam(1, "第三个参数为空"));
        System.out.println(responseResult.isSuccess());
        System.out.println(responseResult.getBaseResponse().getCode());
        System.out.println(responseResult.getBaseResponse().getMessage());
    }
}
