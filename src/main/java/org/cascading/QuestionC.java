package org.cascading;

import javax.persistence.*;
import java.util.List;

@Entity
public class QuestionC {
    @Id
    @Column(name= "q_id")
    private int questionId;

    @Column(name= "q_name")
    private String questionName;

    @OneToMany(mappedBy= "question", cascade= CascadeType.ALL)
    private List<AnswerC> answer;

    public void setAnswer(List<AnswerC> answer){
        this.answer= answer;
    }

    public List<AnswerC> getAnswer(){
        return this.answer;
    }

    public QuestionC() {
    }

    public QuestionC(int questionId, String questionName) {
        this.questionId = questionId;
        this.questionName = questionName;
    }

}
