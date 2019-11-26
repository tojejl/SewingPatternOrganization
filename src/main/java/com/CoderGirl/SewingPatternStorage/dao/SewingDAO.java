package com.CoderGirl.SewingPatternStorage.dao;

import com.CoderGirl.SewingPatternStorage.model.PatternInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class SewingDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<PatternInfo> getAll() {

        return jdbcTemplate.query("select * from sewing.patterns",
                new SewingRowMapper());
    }

    public void addPattern(PatternInfo patternInfo) {
        System.out.println("Inserting " + patternInfo);
        jdbcTemplate.update(
                "INSERT INTO sewing.patterns(patternCompany, patternNumber, sizeRange, patternDescription, patternNotes, keyword) VALUES (?,?,?,?,?,?)",
                patternInfo.getPatternCompany(), patternInfo.getPatternNumber(), patternInfo.getSizeRange(),
                patternInfo.getPatternDescription(), patternInfo.getPatternNotes(), patternInfo.getKeyword());
    }

    public void updatePattern(int id, PatternInfo patternInfo) {
        System.out.println("Updating " + patternInfo);
        jdbcTemplate.update(
                "UPDATE sewing.patterns SET patternCompany=?, patternNumber=?, sizeRange=?, patternDescription=?, patternNotes=?, keyword=?, where id=?",
                patternInfo.getPatternCompany(), patternInfo.getPatternNumber(), patternInfo.getSizeRange(), patternInfo.getPatternDescription(), patternInfo.getPatternNotes(), patternInfo.getKeyword(), id);
    }

    public PatternInfo findById(int id) {
        List<PatternInfo> matches = jdbcTemplate.query(
                "Select * from sewing.patterns where id = ?",
                new Object[] { id },
                new SewingRowMapper());
        if(matches.isEmpty()){
            return null;
        }
        else{
            return matches.get(0);
        }

    }

    public List<PatternInfo> findByString(String keyword) {
        System.out.println("Finding patterns by searching strings... ");
        return jdbcTemplate.query("select * from sewing.patterns WHERE patternKeyword LIKE ? ", new SewingRowMapper(), "%" + keyword + "%");
    }
}
