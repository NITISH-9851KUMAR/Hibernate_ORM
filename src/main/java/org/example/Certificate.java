package org.example;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Certificate {

    @Column(length= 20)
    private String course;

    @Column(length= 20)
    private String duration;

    public Certificate() {}

    public Certificate(String course, String duration) {
        this.course = course;
        this.duration = duration;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
