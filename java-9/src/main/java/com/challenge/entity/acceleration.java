package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@EntityListeners({challenge.class})
@Embeddable
public class acceleration {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column
    @NotNull
    @Size(max = 100)
    private String name;

    @Column
    @NotNull
    @Size(max = 50)
    private String slug;


    @ManyToOne
    @JoinColumn(name="challenge_id", referencedColumnName = "id", nullable = false)
    @NotNull
    private challenge challenge;

    @Column(name = "created_at")
    @NotNull
    @CreatedDate
    private Timestamp created_at;


    @NotNull
    @OneToMany(mappedBy="acceleration")
    private Set<candidate> candidate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public com.challenge.entity.challenge getChallenge() {
        return challenge;
    }

    public void setChallenge(com.challenge.entity.challenge challenge) {
        this.challenge = challenge;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof acceleration)) return false;
        acceleration that = (acceleration) o;
        return getId() == that.getId() &&
                getName().equals(that.getName()) &&
                getSlug().equals(that.getSlug()) &&
                getChallenge().equals(that.getChallenge()) &&
                getCreated_at().equals(that.getCreated_at());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSlug(), getChallenge(), getCreated_at());
    }

    @Override
    public String toString() {
        return "acceleration{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", slug='" + slug + '\'' +
                ", challenge=" + challenge +
                ", created_at=" + created_at +
                '}';
    }
}
