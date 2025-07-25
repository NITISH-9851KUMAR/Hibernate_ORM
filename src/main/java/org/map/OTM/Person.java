package org.map.OTM;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @Column(name = "p_id")
    int personId;

    @Column(name = "p_name")
    String personName;

    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY) // fetch type is used for Lazy Loading Class
    private List<Enemy> enemy;

    public void setEnemy(List<Enemy> enemy) {
        this.enemy = enemy;
    }

    public List<Enemy> getEnemy() {
        return enemy;
    }

    public Person() {
    }

    public Person(int personId, String personName) {
        this.personId = personId;
        this.personName = personName;
    }

    @Override
    public String toString() {
        return "personId= " + personId +
                ", personName= '" + personName + '\'' +
                '}';
    }

}
