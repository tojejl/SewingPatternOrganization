package com.CoderGirl.SewingPatternStorage.dao;

import com.CoderGirl.SewingPatternStorage.model.PatternInfo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SewingRowMapper implements RowMapper<PatternInfo> {

    public PatternInfo mapRow(ResultSet resultset, int ignoreThis) throws SQLException {

        int id = resultset.getInt("id");
        String patternCompany = resultset.getString("patternCompany");
        String patternNumber = resultset.getString("patternNumber");
        String sizeRange = resultset.getString("sizeRange");
        String patternDescription = resultset.getString("patternDescription");
        String patternNotes = resultset.getString("patternNotes");
        String keyword = resultset.getString("keyword");

        return new PatternInfo(id, patternCompany, patternNumber, sizeRange, patternDescription, patternNotes, keyword);
    }
}
