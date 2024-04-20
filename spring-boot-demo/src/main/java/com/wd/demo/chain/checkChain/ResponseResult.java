package com.wd.demo.chain.checkChain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.function.Supplier;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseResult {
    private boolean isSuccess;
    private BaseResponse baseResponse;


    public ResponseResult andValid(Supplier<ResponseResult> supplier) {
        return isSuccess ? supplier.get() : this;
    }
}
