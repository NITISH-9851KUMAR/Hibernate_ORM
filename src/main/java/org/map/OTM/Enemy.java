package org.map.OTM;

import javax.persistence.*;

@Entity
@Table(name = "enemy")
public class Enemy {

    @Id
    @Column(name = "e_id")
    private int enemyId;

    @Column(name = "e_name")
    private String enemyName;

    @ManyToOne
    @JoinColumn(name = "p_id")
    private Person person;

    public void setPerson(Person person) {
        this.person = person;
    }

    public Enemy() {
    }

    public Enemy(int enemyId, String enemyName) {
        this.enemyId = enemyId;
        this.enemyName = enemyName;
    }

    @Override
    public String toString() {
        return enemyId+" "+enemyName;
    }

}
