package com.infybuzz.report;

/**
 * @author E.Parominsky 09/01/2024 09:19
 */
public class Subject {

    private String subjectName;
    private long marksObtained;

    public Subject(String subjectName, long marksObtained) {
        this.subjectName = subjectName;
        this.marksObtained = marksObtained;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public long getMarksObtained() {
        return marksObtained;
    }

    public void setMarksObtained(long marksObtained) {
        this.marksObtained = marksObtained;
    }
}
