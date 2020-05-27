package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.crypto.Data;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@EntityListeners({candidate.class, submission.class})
@Embeddable
public class user implements Serializable {

    @NotNull
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @NotNull
    @Size(max = 100)
    private String fullname;

    @NotNull
    @Size(max = 100)
    @Email
    private String email;

    @NotNull
    @Size(max = 50)
    private String nickname;

    @NotNull
    @Size(max = 255)
    private String password;

    @Column(name = "created_at")
    @NotNull
    @CreatedDate
    private Timestamp created_at;

    @NotNull
    @OneToMany(mappedBy="user")
    private Set<candidate> user_id;

    @NotNull
    @OneToMany(mappedBy="user")
    private Set<submission> user_id_1;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFull_name() {
        return fullname;
    }

    public void setFull_name(String full_name) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        if (!(o instanceof user)) return false;
        user user = (user) o;
        return getId() == user.getId() &&
                Objects.equals(getFull_name(), user.getFull_name()) &&
                Objects.equals(getEmail(), user.getEmail()) &&
                Objects.equals(getNickname(), user.getNickname()) &&
                Objects.equals(getPassword(), user.getPassword()) &&
                Objects.equals(getCreated_at(), user.getCreated_at());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFull_name(), getEmail(), getNickname(), getPassword(), getCreated_at());
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", full_name='" + fullname + '\'' +
                ", email='" + email + '\'' +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", created_at=" + created_at +
                '}';
    }
}
