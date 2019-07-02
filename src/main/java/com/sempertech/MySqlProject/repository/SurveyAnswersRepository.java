package com.sempertech.MySqlProject.repository;

import com.sempertech.MySqlProject.model.SurveyAnswers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyAnswersRepository extends JpaRepository<SurveyAnswers,Long> {

}
