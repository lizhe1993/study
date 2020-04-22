package com.log.study.logstudy;


import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LogStudyApplicationTests {

    private final static Logger logger = LoggerFactory.getLogger(LogStudyApplicationTests.class);

    @Test
    void contextLoads() {

    }

}
