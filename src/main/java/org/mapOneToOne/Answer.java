package org.mapOneToOne;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Answer {

    @Id
    @Column(name= "answer_id", length= 3)
    private int answerId;

    @Column(length= 50)
    private String answer;

    @OneToOne(mappedBy = "answer")
    private Question question;

    public void setQuestion(Question q){
        this.question = q;
    }

    public Answer() {
    }

    public String getAnswer(){
        return answer;
    }

    public Answer(int answerId, String answer) {
        this.answerId = answerId;
        this.answer = answer;
    }
}
