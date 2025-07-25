package org.map.OTO;

import javax.persistence.*;

@Entity
@Table(name = "answerOTO")
public class Answer {

    @Id
    @Column(name = "a_id")
    int answerId;

    @Column(name = "a_name")
    String answerName;

    @OneToOne(mappedBy = "answer")
    private Question question;

    public Answer() {
    }

    public Answer(int answerId, String answerName) {
        this.answerId = answerId;
        this.answerName = answerName;
    }

    @Override
    public String toString() {
        return answerId+" "+answerName;
    }

}
