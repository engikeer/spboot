package com.mfun.spboot;

import com.mfun.spboot.bean.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpbootApplicationTests {

    @Autowired
    private Person person;

    @Test
    void contextLoads() {
        System.out.println(person);
    }

}
