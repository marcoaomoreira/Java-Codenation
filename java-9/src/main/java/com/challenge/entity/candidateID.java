package com.challenge.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
public class candidateID implements Serializable {


    @ManyToOne
    @JoinColumn(name = "user_id")
    public user user_id;


    @ManyToOne
    @JoinColumn(name = "acceleration_id")
    private acceleration acceleration_id;


    @ManyToOne
    @JoinColumn(name = "company_id")
    private company company_id;


}
