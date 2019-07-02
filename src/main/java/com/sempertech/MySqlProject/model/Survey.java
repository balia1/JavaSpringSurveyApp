package com.sempertech.MySqlProject.model;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.jws.soap.SOAPBinding;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "surveys")
public class Survey {

    @Id
    @Column(name = "survey_id", nullable = false)
    private long id;
    @Column(name = "survey_name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "survey")
    private List<SurveyQuestions> questions;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    public long getId() {
        return id;
    }

    public Users getUser() {
        return user;
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

    public Survey() {
    }

    public Survey(long id, Users user) {
        this.id = id;
        this.user = user;
    }
}
