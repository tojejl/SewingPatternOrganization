package com.CoderGirl.SewingPatternStorage.model;

public class PatternInfo {
    private String patternCompany;
    private String patternNumber;
    private String sizeRange;
    private String patternDescription;
    private String patternNotes;
    private int id;

    public PatternInfo() {
    }

    public PatternInfo(int id, String patternCompany, String patternNumber, String sizeRange, String patternDescription, String patternNotes){
        this.id = id;
        this.patternCompany = patternCompany;
        this.patternNumber = patternNumber;
        this.sizeRange = sizeRange;
        this.patternDescription = patternDescription;
        this.patternNotes = patternNotes;
    }

    public PatternInfo(String patternCompany, String patternNumber, String sizeRange, String patternDescription, String patternNotes){
        this.patternCompany = patternCompany;
        this.patternNumber = patternNumber;
        this.sizeRange = sizeRange;
        this.patternDescription = patternDescription;
        this.patternNotes = patternNotes;
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

    public int getId() {return id; }

    public void setId(int id) {this.id = id;}
}
