package com.challenge.entity;


import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

@Entity
@EntityListeners({submission.class, acceleration.class})
public class challenge {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(max=100)
    @Column
    private String name;

    @NotNull
    @Size(max=50)
    @Column
    private String slug;

    @Column(name = "created_at")
    @NotNull
    @CreatedDate
    private Timestamp created_at;

    @NotNull
    @OneToMany(mappedBy="challenge")
    private Set<submission> submission;

    @NotNull
    @OneToMany(mappedBy="challenge")
    private Set<acceleration> acceleration;

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

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof challenge)) return false;
        challenge challenge = (challenge) o;
        return getId() == challenge.getId() &&
                Objects.equals(getName(), challenge.getName()) &&
                Objects.equals(getSlug(), challenge.getSlug()) &&
                Objects.equals(getCreated_at(), challenge.getCreated_at());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSlug(), getCreated_at());
    }

    @Override
    public String toString() {
        return "challenge{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", slug='" + slug + '\'' +
                ", created_at=" + created_at +
                '}';
    }
}
