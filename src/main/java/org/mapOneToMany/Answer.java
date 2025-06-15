package org.mapOneToMany;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "Answer2")
public class Answer {

    @Id
    @Column(length= 3)
    private int ans_id;

    @Column(length= 50)
    private String answer;

    @ManyToOne
    @JoinColumn(name= "q_id")
    private Question question;

    public void setQuestion(Question q){
        this.question= q;
    }

    public String  getAnswer(){
        return answer;
    }

    public Answer() {
    }

    public Answer(int ans_id, String answer) {
        this.ans_id = ans_id;
        this.answer = answer;
    }
}
