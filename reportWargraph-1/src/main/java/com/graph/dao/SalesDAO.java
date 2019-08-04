package com.graph.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.graph.dto.ChartDTO;

@Repository
public class SalesDAO {

    private static final String QUARTER_COLUMN_NAME = "QUARTER";
    private static final String AMOUNT_COLUMN_NAME = "AMOUNT";
    private static final String CAR_MANUFACTURER_LABEL = "carManufacturerId";

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public ChartDTO getData(Integer carManufacturerId) {
        return namedParameterJdbcTemplate.query(getQuery(), new MapSqlParameterSource(CAR_MANUFACTURER_LABEL, carManufacturerId), new ResultSetExtractor<ChartDTO>() {
            @Override
            public ChartDTO extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                ChartDTO chartDTO = new ChartDTO();

                while(resultSet.next()) {
                    chartDTO.addXaxisValue(resultSet.getString(QUARTER_COLUMN_NAME));
                    chartDTO.addYaxisValue(resultSet.getDouble(AMOUNT_COLUMN_NAME));
                }

                return chartDTO;
            }
        });
    }


    private String getQuery() {
        return "SELECT "+QUARTER_COLUMN_NAME+", "+AMOUNT_COLUMN_NAME+" FROM CAR_MANUFACTURER CM " +
                "JOIN SALES S ON CM.ID = S.ID " +
                "WHERE CM.ID = :" +CAR_MANUFACTURER_LABEL+"\n"+
                "ORDER BY "+QUARTER_COLUMN_NAME;
    }
}
