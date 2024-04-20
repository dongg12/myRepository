package com.wd.demo.chain.normalChain;

import com.wd.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

public class GetDataFromMySql<T> implements GetDataHandlerChain<T> {

    private T t;

    @Override
    public T getData() {
        if (Objects.nonNull(t)){
            return t;
        }
        return null;
    }

    @Override
    public GetDataHandlerChain<T> getNextChain() {
        return null;
    }

    @Override
    public GetDataHandlerChain<T> getPreChain() {
        return new GetDataFromEs<T>();
    }

    @Override
    public  void saveData(T t) {
    }

}
