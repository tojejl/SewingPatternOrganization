package com.CoderGirl.SewingPatternStorage.dao;

import com.CoderGirl.SewingPatternStorage.model.Pattern;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SewingRowMapper implements RowMapper<Pattern> {

    public Pattern mapRow(ResultSet resultset, int ignoreThis) throws SQLException {

        int id = resultset.getInt("id");
        String patternCompanyAndNumber = resultset.getString("patternCompanyAndNumber");
        String sizeRange = resultset.getString("sizeRange");
        String patternDescription = resultset.getString("patternDescription");
        String patternNotes = resultset.getString("patternNotes");
        String keyword = resultset.getString("keyword");

        return new Pattern(id, patternCompanyAndNumber, sizeRange, patternDescription, patternNotes, keyword);
    }
}
