package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;


@Entity
@EntityListeners({user.class, challenge.class})
public class submission {

    @EmbeddedId
    private submissionID id;

    @NotNull
    @Column
    private float score;


    @Column(name = "created_at")
    @NotNull
    @CreatedDate
    private Timestamp created_at;



    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }


    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

}
