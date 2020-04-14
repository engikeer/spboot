package com.mfun.spboot.controller;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class QueryController {
    private JdbcTemplate jdbcTemplate;

    public QueryController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/query")
    @ResponseBody
    public String query() {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from bs_user");
        return (String) maps.get(0).get("username");
    }
}
