package com.jobrecord.model;

public enum JobStatus {
    APPLIED("Applied"),
    INTERVIEWING("Interviewing"),
    REJECTED("Rejected"),
    SELECTED("Selected"),
    GHOSTED("Ghosted");
    
    private final String displayName;
    
    JobStatus(String displayName) {
        this.displayName = displayName;
    }
    
    public String getDisplayName() {
        return displayName;
    }
    
    @Override
    public String toString() {
        return displayName;
    }
}