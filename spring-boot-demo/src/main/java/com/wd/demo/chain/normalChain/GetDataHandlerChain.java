package com.wd.demo.chain.normalChain;

public interface GetDataHandlerChain<T> {
    T getData();

    GetDataHandlerChain<T> getNextChain();

    GetDataHandlerChain<T> getPreChain();

    void saveData(T t);
}
