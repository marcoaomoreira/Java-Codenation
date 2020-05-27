package com.challenge.entity;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class submissionID {

    @ManyToOne
    @JoinColumn(name = "user_id")
    public user user_id;


    @ManyToOne
    @JoinColumn(name = "challenge_id")
    private challenge challenge_id;

}
