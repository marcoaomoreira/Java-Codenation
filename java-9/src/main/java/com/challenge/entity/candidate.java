package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Entity
@EntityListeners({user.class, acceleration.class, company.class})
public class candidate implements Serializable {


    @EmbeddedId
    private candidateID id;

    @NotNull
    @Column
    private int status;

    @Column(name = "created_at")
    @NotNull
    @CreatedDate
    private Timestamp created_at;


    private List<candidate> candidate;

    public candidate(){}

    public candidateID getId() {
        return id;
    }

    public void setId(candidateID id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public List<com.challenge.entity.candidate> getCandidate() {
        return candidate;
    }

    public void setCandidate(List<com.challenge.entity.candidate> candidate) {
        this.candidate = candidate;
    }


}
