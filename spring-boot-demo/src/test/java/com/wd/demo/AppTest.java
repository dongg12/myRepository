package com.wd.demo;

import com.wd.demo.entity.User;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Unit test for simple App.
 */
@SpringBootTest
public class AppTest {

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
//        String e1 = encryptor.encrypt("wangdong");
//        String e2 = encryptor.encrypt("123456");
//        System.out.println(e1);
//        System.out.println(e2);
//
//        System.setProperty("jasypt.encrptor.password", "wangdong");

        System.out.println(User.class.isAssignableFrom(User.class));
    }
}
