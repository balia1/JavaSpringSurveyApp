package com.sempertech.MySqlProject.repository;

import com.sempertech.MySqlProject.model.StoredAnswers;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoredAnswersRepository extends MongoRepository<StoredAnswers,String> {
    List<StoredAnswers> findByAnswer(String s);
}
