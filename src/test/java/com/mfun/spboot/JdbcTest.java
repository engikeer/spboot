package com.mfun.spboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
public class JdbcTest {

    @Autowired
    private DataSource dataSource;

    @Test
    void test() throws SQLException {
        System.out.println("数据源类型：" + dataSource.getClass());

        try (Connection connection = dataSource.getConnection()) {
            System.out.println(connection);
        }
    }
}
