package org.cascading;

import javax.persistence.*;

@Entity
public class AnswerC {

    @Id
    @Column(name= "a_id")
    private int answerId;

    @Column(name= "a_name")
    private String answerName;

    @ManyToOne
    @JoinColumn(name= "q_id")
    private QuestionC question;

    public void setQuestion(QuestionC question){
        this.question= question;
    }

    public AnswerC() {
    }

    public AnswerC(int answerId, String answerName) {
        this.answerId = answerId;
        this.answerName = answerName;
    }

}
