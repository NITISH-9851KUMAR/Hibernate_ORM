package org.map.OTO;

import javax.persistence.*;

@Entity
@Table(name = "questionOTO")
public class Question {

    @Id
    @Column(name = "q_id", length = 3)
    int questionId;

    @Column(name = "q_name")
    String questionName;

    @OneToOne
    @JoinColumn(name = "a_id")
    private Answer answer;

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public Question() {
    }

    public Question(int questionId, String questionName) {
        this.questionId = questionId;
        this.questionName = questionName;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionName='" + questionName + '\'' +
                ", questionId=" + questionId +
                '}';
    }

}
