package com.wd.demo.chain.normalChain;

import com.wd.demo.entity.User;

public class GetDataChainTest {
    public static void main(String[] args) {
        GetDataServiceImpl<User> getDataService = new GetDataServiceImpl<>();

        User data = getDataService.getData();
        System.out.println();

    }
}
