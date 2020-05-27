package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

@Entity
@EntityListeners(candidate.class)
@Embeddable
public class company {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column
    @Size(max = 100)
    private String name;

    @NotNull
    @Column
    @Size(max = 50)
    private String slug;

    @Column(name = "created_at")
    @NotNull
    @CreatedDate
    private Timestamp created_at;

    @NotNull
    @OneToMany(mappedBy="company")
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

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof company)) return false;
        company company = (company) o;
        return getId() == company.getId() &&
                getName().equals(company.getName()) &&
                getSlug().equals(company.getSlug()) &&
                getCreated_at().equals(company.getCreated_at());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSlug(), getCreated_at());
    }

    @Override
    public String toString() {
        return "company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", slug='" + slug + '\'' +
                ", created_at=" + created_at +
                '}';
    }
}
