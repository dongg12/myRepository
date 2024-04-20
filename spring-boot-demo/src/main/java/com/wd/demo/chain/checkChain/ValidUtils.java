package com.wd.demo.chain.checkChain;

import java.util.Objects;

public class ValidUtils<T> {

    public static <T> ResponseResult validParam(T param, String message) {
        if (Objects.isNull(param)) {
            return ResponseResult.builder().isSuccess(false).baseResponse(BaseResponse.builder().code(-1).message(message).build()).build();
        }
        return ResponseResult.builder().isSuccess(true).baseResponse(BaseResponse.builder().code(200).message("成功").build()).build();
    }
}
