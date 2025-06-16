package org.mapOneToMany;

import javax.persistence.*;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Table(name= "Question2")
public class Question {

    @Id
    @Column(length= 3)
    private int id;

    @Column(length= 50)
    private String question;

    @OneToMany(mappedBy = "question" , fetch = FetchType.EAGER)
    private List<Answer> answer;

    public String toString(){
        return id+ " "+question;
    }

    public void setAnswer(List<Answer> a){
        this.answer= a;
    }

    public List<Answer> getAnswer(){
        return answer;
    }

    public Question() {
    }

    public Question(int id, String question) {
        this.id = id;
        this.question = question;
    }
}
