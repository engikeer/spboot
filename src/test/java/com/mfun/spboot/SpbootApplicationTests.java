package com.mfun.spboot;

import com.mfun.spboot.bean.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class SpbootApplicationTests {

    @Autowired
    private Person person;

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void getBean() {
        System.out.println(applicationContext.containsBean("hello"));
    }

    @Test
    void contextLoads() {
        System.out.println(person);
    }

}
