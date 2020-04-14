package com.mfun.spboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class JdbcTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void test() throws SQLException {
        System.out.println("数据源类型：" + dataSource.getClass());

        try (Connection connection = dataSource.getConnection()) {
            System.out.println(connection);
        }
    }

    @Test
    void jdbcTemplateTest() {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("SELECT * FROM bs_user");
        Map<String, Object> map = maps.get(0);
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "--" + entry.getValue());
        }
    }
}
