package org.EmbeddedAnno;

import javax.persistence.Embeddable;

@Embeddable
public class Work {

    private String work_name;
    private String work_dur;

    public Work() {
    }

    public Work(String work_name, String work_dur) {
        this.work_name = work_name;
        this.work_dur = work_dur;
    }

}
