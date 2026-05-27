package com.eduhub.eduhub.Services;

import org.springframework.stereotype.Component;

@Component
public class CourseService {

    private int courseCode;
    private String subjectName;
    private int credits;

    public CourseService() {}

    public CourseService(int courseCode, String subjectName, int credits) {
        this.courseCode = courseCode;
        this.subjectName = subjectName;
        this.credits = credits;
    }

    public int getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(int courseCode) {
        this.courseCode = courseCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }
}
