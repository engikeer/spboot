package com.mfun.spboot;

import com.mfun.spboot.bean.Person;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class SpbootApplicationTests {

    Logger logger = LoggerFactory.getLogger(getClass());

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

    @Test
    void logging() {
        logger.trace("TRACE：跟踪特定对象的变化");
        logger.debug("DEBUG：关键步骤的调试信息");
        logger.info("INFO：信息");
        logger.warn("WARN：警告");
        logger.error("ERROR：错误");
    }

}
