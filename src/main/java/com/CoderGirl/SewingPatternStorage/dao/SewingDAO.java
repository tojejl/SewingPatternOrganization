package com.CoderGirl.SewingPatternStorage.dao;

import com.CoderGirl.SewingPatternStorage.model.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SewingDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Pattern> getAll() {

        return jdbcTemplate.query("select * from sewing.patterns",
                new SewingRowMapper());
    }

    public void addPattern(Pattern pattern) {
        System.out.println("Inserting " + pattern);
        jdbcTemplate.update("INSERT INTO sewing.patterns(patternCompanyAndNumber, sizeRange, " +
                        "patternDescription, patternNotes, keyword) VALUES (?,?,?,?,?,)",
                pattern.getPatternCompanyAndNumber(),  pattern.getSizeRange(),
                pattern.getPatternDescription(), pattern.getPatternNotes(), pattern.getKeyword());
    }

    public void updatePattern(int id, Pattern pattern) {
        System.out.println("Updating " + pattern);
        jdbcTemplate.update("UPDATE sewing.patterns SET patternCompanyAndNumber=?, sizeRange=?, patternDescription=?, patternNotes=?, keyword=? where id=?",
                pattern.getPatternCompanyAndNumber(), pattern.getSizeRange(),
                pattern.getPatternDescription(), pattern.getPatternNotes(), pattern.getKeyword(), id);
    }

    public Pattern findById(int id) {
        List<Pattern> matches = jdbcTemplate.query(
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

    public List<Pattern> findByString(String keyword) {
        System.out.println("Finding patterns by searching strings... ");
        return jdbcTemplate.query("select * from sewing.patterns WHERE lower( keyword) LIKE ? ", new SewingRowMapper(), "%" + keyword + "%");
    }

    //public void delete
}
