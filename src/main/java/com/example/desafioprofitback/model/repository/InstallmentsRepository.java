package com.example.desafioprofitback.model.repository;

import com.example.desafioprofitback.model.entity.Installments;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class InstallmentsRepository {

    private JdbcTemplate jdbcTemplate;

    public InstallmentsRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Installments searchInstallments(int id) {
        String sql = "select * from installments where id = ?";

        return jdbcTemplate.queryForObject(sql, new InstallmentsMapper(), id);
    }
}
