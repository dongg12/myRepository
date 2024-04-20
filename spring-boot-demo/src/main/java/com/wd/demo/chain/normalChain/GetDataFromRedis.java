package com.wd.demo.chain.normalChain;

import com.wd.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

public class GetDataFromRedis<T> implements GetDataHandlerChain<T> {
    @Override
    public T getData() {
        return null;
    }

    @Override
    public GetDataHandlerChain<T> getNextChain() {
        return new GetDataFromEs<T>();
    }

    @Override
    public GetDataHandlerChain<T> getPreChain() {
        return null;
    }

    @Override
    public void saveData(T t) {
    }
}
