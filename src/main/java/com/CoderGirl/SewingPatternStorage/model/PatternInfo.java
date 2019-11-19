package com.CoderGirl.SewingPatternStorage.model;

public class PatternInfo {
    private String patternCompany;
    private String patternNumber;
    private String sizes;
    private int id;

    public PatternInfo() {
    }

    public PatternInfo(int id, String patternCompany, String patternNumber, String sizes){
        this.id = id;
        this.patternCompany = patternCompany;
        this.patternNumber = patternNumber;
        this.sizes = sizes;
    }

    public PatternInfo(String patternCompany, String patternNumber, String sizes){
        this.patternCompany = patternCompany;
        this.patternNumber = patternNumber;
        this.sizes = sizes;
    }

    public String getPatternCompany() {return patternCompany; }

    public void setPatternCompany(String patternCompany) {this.patternCompany = patternCompany;}

    public String getPatternNumber() {return patternNumber; }

    public void setPatternNumber(String patternNumber) {this.patternNumber = patternNumber;}

    public String getSizes() {return sizes; }

    public void setSizes(String Sizes) {this.sizes = sizes; }

    public int getId() {return id; }

    public void setId(int id) {this.id = id;}
}
