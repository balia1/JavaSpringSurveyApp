package com.sempertech.MySqlProject.repository;

import com.sempertech.MySqlProject.model.SurveyQuestions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurveyQuestionsRepository extends JpaRepository<SurveyQuestions, Long> {
    List<SurveyQuestions> findBySurveyId(long i);
}
