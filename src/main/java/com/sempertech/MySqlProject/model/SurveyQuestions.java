package com.sempertech.MySqlProject.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "questions")
public class SurveyQuestions {
    @Id
    @Column(name = "id_questions")
    private long id;
    @Column(name = "question")
    private String question;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "questions")
    private List<SurveyAnswers> surveyAnswers;
    @ManyToOne
    @JoinColumn(name = "survey_id")
    private Survey survey;


    public SurveyQuestions() {
    }

    public SurveyQuestions(long id, String question, Survey survey) {
        this.id = id;
        this.question = question;
        this.survey = survey;
    }

    public SurveyQuestions(long id, List<SurveyAnswers> surveyAnswers) {
        this.id = id;
        this.surveyAnswers = surveyAnswers;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }


    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }
}
