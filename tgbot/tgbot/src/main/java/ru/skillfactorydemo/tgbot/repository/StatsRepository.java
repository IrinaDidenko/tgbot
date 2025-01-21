package ru.skillfactorydemo.tgbot.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class StatsRepository {
    final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public int getCountOfIncomesThatGreaterThan(BigDecimal amount) {

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("amount", amount);
        return namedParameterJdbcTemplate.queryForObject("SELECT count(*) from INCOMES where income >:amount", parameters, new StatsRowMapper());

    }

    public int getCountOfSpendThatGreaterThan(BigDecimal amount) {

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("amount", amount);
        return namedParameterJdbcTemplate.queryForObject("SELECT count(*) from SPEND where spend >:amount", parameters, new StatsRowMapper());

    }

    public List<Map<String, Object>> getSpendsBetweenDates(Date from, Date to) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("from", from);
        parameters.put("to", to);
        return namedParameterJdbcTemplate.queryForList("Select spend, date from public.spend where date between :from and :to ", parameters);
    }

    public List<Map<String, Object>> getIncomesBetweenDates(Date from, Date to) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("from", from);
        parameters.put("to", to);
        return namedParameterJdbcTemplate.queryForList("Select income, date from public.incomes where date between :from and :to ", parameters);
    }

    private static final class StatsRowMapper implements RowMapper<Integer> {


        @Override
        public Integer mapRow(ResultSet resultSet, int i) throws SQLException {
            return resultSet.getInt("COUNT");
        }
    }

    private static final class StatsDatesRowMapper implements RowMapper<String> {
        @Override
        public String mapRow(ResultSet rs, int rowNum) throws SQLException {
            return String.valueOf(rs.getInt("INCOME")) + " " + String.valueOf(rs.getString("DATE"));
        }
    }
}
