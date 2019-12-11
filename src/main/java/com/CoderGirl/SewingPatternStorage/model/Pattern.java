package com.CoderGirl.SewingPatternStorage.model;

public class Pattern {
    private String patternCompanyAndNumber;
    private String sizeRange;
    private String patternDescription;
    private String patternNotes;
    private String keyword;
    private int id;

    public Pattern(){}


    public Pattern(int id, String patternCompanyAndNumber, String sizeRange, String patternDescription, String patternNotes, String keyword){
        this.id = id;
        this.patternCompanyAndNumber = patternCompanyAndNumber;
        this.sizeRange = sizeRange;
        this.patternDescription = patternDescription;
        this.patternNotes = patternNotes;
        this.keyword = keyword;
    }

    public Pattern(String patternCompanyAndNumber,  String sizeRange, String patternDescription, String patternNotes, String keyword){
        this.patternCompanyAndNumber = patternCompanyAndNumber;
        this.sizeRange = sizeRange;
        this.patternDescription = patternDescription;
        this.patternNotes = patternNotes;
        this.keyword = keyword;
    }


    public String getPatternCompanyAndNumber() {return patternCompanyAndNumber; }

    public void setPatternCompanyAndNumber(String patternCompanyAndNumber
    ) {this.patternCompanyAndNumber = patternCompanyAndNumber;}

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
