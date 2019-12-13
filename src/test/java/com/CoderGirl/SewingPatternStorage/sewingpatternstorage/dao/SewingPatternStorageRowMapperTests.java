package com.CoderGirl.SewingPatternStorage.sewingpatternstorage.dao;

import com.CoderGirl.SewingPatternStorage.dao.SewingRowMapper;
import com.CoderGirl.SewingPatternStorage.model.Pattern;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SewingPatternStorageRowMapperTests {

    @Test
    public void mapTheSewingPatterns() throws SQLException {

        /*This is some code that stimulates what happens when Java runs
        SQL code using JDBC. It's meant to stimulate a database call
        that produces this:

        ID
         */
        ResultSet rs = mock(ResultSet.class);
        when(rs.getInt("id")).thenReturn(47);
        when(rs.getString("patternCompanyAndNumber")).thenReturn("patternCompanyAndNumber");
        when(rs.getString("sizeRange")).thenReturn("sizeRange");
        when(rs.getString("patternDescription")).thenReturn("patternDescription");
        when(rs.getString("patternNotes")).thenReturn("patternNotes");
        when(rs.getString("keyword")).thenReturn("keyword");

        //This is the call to the Row Mapper
        Pattern mapped = new SewingRowMapper().mapRow(rs,0);

        //Here we check the result to see if it worked!
        //Assert.assertEquals(47, mapped.getId());
        //Assert.assertEquals("patternCompanyAndNumber", mapped.getPatternCompanyAndNumber());

    }
}
