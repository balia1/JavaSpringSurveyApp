package com.sempertech.MySqlProject.model;
import org.hibernate.dialect.identity.SQLServerIdentityColumnSupport;

import javax.persistence.*;
import java.sql.Statement;

@Entity
@Table(name = "answers")
public class SurveyAnswers{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_answers", nullable = false)
        private long id;
    @Column(name = "Answer", nullable = false)
        private String answer;
    @ManyToOne
    @JoinColumn(name = "id_questions")
    private SurveyQuestions questions;


    public SurveyAnswers(){
        }

    public SurveyAnswers(long id, String answer, SurveyQuestions questions) {
        this.id = id;
        this.answer = answer;
        this.questions = questions;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public SurveyQuestions getQuestions() {
        return questions;
    }

    public void setQuestions(SurveyQuestions questions) {
        this.questions = questions;
    }
}
