package com.wd.demo.chain.normalChain;

import com.wd.demo.entity.User;

import java.util.Objects;

public class GetDataServiceImpl<T> implements GetDataService<T>{

    @Override
    public T getData() {
        GetDataHandlerChain<T> handlerChain = new GetDataFromRedis<T>();
        while (Objects.nonNull(handlerChain)){
            T data = handlerChain.getData();
            if (Objects.isNull(data)){
                handlerChain = handlerChain.getNextChain();
            }else {
                GetDataHandlerChain<T> preChain = handlerChain.getPreChain();
                while (Objects.nonNull(preChain)){
                    preChain.saveData(data);
                    preChain = preChain.getPreChain();
                }
                return data;
            }
        }
        return null;
    }
}
