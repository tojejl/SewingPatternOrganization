package com.CoderGirl.SewingPatternStorage.model;

public class Pattern {
    private String patternCompany;
    private String patternNumber;
    private String sizeRange;
    private String patternDescription;
    private String patternNotes;
    private String keyword;
    private int id;

    public Pattern() {
    }

    public Pattern(int id, String patternCompany, String patternNumber, String sizeRange, String patternDescription, String patternNotes, String keyword){
        this.id = id;
        this.patternCompany = patternCompany;
        this.patternNumber = patternNumber;
        this.sizeRange = sizeRange;
        this.patternDescription = patternDescription;
        this.patternNotes = patternNotes;
        this.keyword = keyword;
    }

    public Pattern(String patternCompany, String patternNumber, String sizeRange, String patternDescription, String patternNotes, String keyword){
        this.patternCompany = patternCompany;
        this.patternNumber = patternNumber;
        this.sizeRange = sizeRange;
        this.patternDescription = patternDescription;
        this.patternNotes = patternNotes;
        this.keyword = keyword;
    }


    public String getPatternCompany() {return patternCompany; }

    public void setPatternCompany(String patternCompany) {this.patternCompany = patternCompany;}

    public String getPatternNumber() {return patternNumber; }

    public void setPatternNumber(String patternNumber) {this.patternNumber = patternNumber;}

    public String getSizeRange() {return sizeRange; }

    public void setSizeRange(String sizeRange) {this.sizeRange = sizeRange; }

    public String getPatternDescription() {return patternDescription; }

    public void setPatternDescription (String patternDescription) {this.patternDescription = patternDescription; }

    public String getPatternNotes() {return patternNotes; }

    public void setPatternNotes (String patternNotes) {this.patternNotes = patternNotes; }

    public String getKeyword() {return keyword; }

    public void setKeyword(String keyword) {this.keyword = keyword;}

    public int getId() {return id; }

    public void setId(int id) {this.id = id;}
}
