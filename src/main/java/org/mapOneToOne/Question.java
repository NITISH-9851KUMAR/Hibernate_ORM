package org.mapOneToOne;

import javax.persistence.*;
import javax.persistence.OneToOne;

@Entity
public class Question {
    @Id
    @Column(name= "question_id", length= 3)
    private int Id;

    @Column(length= 50)
    private String question;

    @OneToOne
    @JoinColumn(name="a_id")
    private Answer answer;

    public String getAnswer(){
        return answer.getAnswer();
    }

    public String getQuestion(){
        return question;
    }

    public Question() {
    }

    public Question(int id, String question, Answer answer) {
        Id = id;
        this.question = question;
        this.answer = answer;
    }
}
