package com.sempertech.MySqlProject.boot.controller.surveyController;

import com.sempertech.MySqlProject.*;
import com.sempertech.MySqlProject.model.*;
import com.sempertech.MySqlProject.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class SurveyController {

    @Autowired
    private SurveyQuestionsRepository surveyQuestionsRepository;
    @Autowired
    private SurveyAnswersRepository surveyAnswersRepository;
    @Autowired
    private UserInterface userInterface;
    @Autowired
    private SurveyRepository surveyRepository;
    @Autowired
    private StoredAnswersRepository storedAnswersRepository;
    @Autowired
    EntityManager entityManager;


    @RequestMapping(value = "/mysql/surveyquestions", method = RequestMethod.GET)
    public List<SurveyQuestions> getSurveyQuestions() {
        List<SurveyQuestions> surveyQuestions = surveyQuestionsRepository.findAll();
        return surveyQuestionsRepository.findAll();
    }


/*
    private DBHelper dbHelper = new DBHelper();
*/
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_VIEWER')")
    @RequestMapping(value = "/mysql/mongo", method = RequestMethod.GET)
    public List<StoredAnswers> storedAnswersGet() {
        return storedAnswersRepository.findAll();
    }

    @RequestMapping(value = "/mysql/mongoAnswer/{s}", method = RequestMethod.GET)
    public List<StoredAnswers> filterStoredAnswers(@PathVariable String s) {
        return (List<StoredAnswers>) storedAnswersRepository.findByAnswer(s);
    }

    @RequestMapping(value = "/mysql/mongoDelete/{s}", method = RequestMethod.GET)
    public List<StoredAnswers> deleteStoredAnswer(@PathVariable String s) {
        storedAnswersRepository.deleteById(s);
        return (List<StoredAnswers>) storedAnswersRepository.findAll();
    }

    @RequestMapping(value = "/mysql/mongoDeleteAll", method = RequestMethod.GET)
    public List<StoredAnswers> deleteStoredAnswer() {
        storedAnswersRepository.deleteAll();
        return (List<StoredAnswers>) storedAnswersRepository.findAll();
    }

    @RequestMapping(value = "/mysql/mongo", method = RequestMethod.POST)
    public List<StoredAnswers> storedAnswersSend(@RequestBody StoredAnswers storedAnswers) {
        storedAnswersRepository.save(storedAnswers);
        return storedAnswersRepository.findAll();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_VIEWER')")
    @RequestMapping(value = "/mysql/secured", method = RequestMethod.GET)
    public String greeting() {
        return "Hello Security";
    }
    // MYSQL CRUD


    @RequestMapping(value = "/mysql/questionsBy/{i}", method = RequestMethod.GET)
    public List<SurveyQuestions> getQuestionsBySurveyId(@PathVariable long i) {
        return surveyQuestionsRepository.findBySurveyId(i);
    }

    @RequestMapping(value = "/mysql/questions", method = RequestMethod.GET)
    public List<SurveyQuestions> getQuestions() {
        return surveyQuestionsRepository.findAll();
    }
    @RequestMapping(value = "/mysql/questions", method = RequestMethod.POST)
    public String sendQuestions(@RequestBody SurveyQuestions surveyQuestions) {
        surveyQuestionsRepository.save(surveyQuestions);
        return "Successful";
    }
    @RequestMapping(value = "/mysql/questionsDel/{id}", method = RequestMethod.GET)
    public String deleteQuestionById(@PathVariable long id) {
        surveyQuestionsRepository.deleteById(id);
        return "Successful";
    }

    @RequestMapping(value = "/mysql/answers", method = RequestMethod.GET)
    public List<SurveyAnswers> getAnswers() {
        return surveyAnswersRepository.findAll();
    }
    @RequestMapping(value = "/mysql/answers", method = RequestMethod.POST)
    public String sendAnswers(@RequestBody SurveyAnswers surveyAnswers) {
        surveyAnswersRepository.save(surveyAnswers);
        return "Successful";
    }

    @RequestMapping(value = "/mysql/surveys", method = RequestMethod.GET)
    public List<Survey> getSurveys() {
        return surveyRepository.findAll();
    }
    @RequestMapping(value = "/mysql/surveys", method = RequestMethod.POST)
    public Survey sendSurveys(@RequestBody Survey survey) {
        return surveyRepository.save(survey);
    }
    @RequestMapping(value = "/mysql/surveysDel/{id}", method = RequestMethod.GET)
    public String deleteSurveyById(@PathVariable long id) {
        surveyRepository.deleteById(id);
        return "Successful";
    }
    @RequestMapping(value = "/mysql/surveyByUser/{i}", method = RequestMethod.GET)
    public List<Survey> getSurveyByUserId(@PathVariable long i) {
        return surveyRepository.findByUserId(i);
    }

    @RequestMapping(value = "/mysql/allUsers", method = RequestMethod.GET)
    public List<Users> getAllUsers() {
        return userInterface.findAll();
    }
    @RequestMapping(value = "/mysql/allUsers", method = RequestMethod.POST)
    public Users sendUser(@RequestBody Users users) {
        return userInterface.save(users);
    }


    @RequestMapping(value = "/mysql/create", method = RequestMethod.POST)
    public SurveyAnswers insertAnswers(@RequestBody SurveyAnswers surveyAnswers) {
        return surveyAnswersRepository.save(surveyAnswers);
    }
    /*

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_VIEWER') or hasRole('ROLE_USER')")
    @RequestMapping(value = "/mysql/all", method = RequestMethod.GET)
    public List<SurveyAnswers> getAll(HttpServletRequest request)throws IOException {
        return dbHelper.getAll();
    }

    @RequestMapping(value = "/mysql/update/{id}/{fA}/{sA}/{tA}", method = RequestMethod.GET)
    public List<SurveyAnswers> remove (@PathVariable("id") long id,
                                       @PathVariable ("fA") String fA,
                                       @PathVariable ("sA") String sA,
                                       @PathVariable ("tA") String tA){

        return dbHelper.updateAnswers(id,fA,sA,tA);
    }
    @RequestMapping(value = "/mysql/delete/answers/{id}", method = RequestMethod.GET)
    public List<SurveyAnswers> deleteAnswer (@PathVariable("id") long id) {

        return dbHelper.deleteAnswers(id);
    }

    @RequestMapping(value = "/mysql/delete/questions/{id}", method = RequestMethod.GET)
    public List<SurveyQuestions> deleteQuestion (@PathVariable("id") long id) {

        return dbHelper.deleteQuestions(id);
    }

    @RequestMapping(value = "/mysql/find/{id}", method = RequestMethod.GET)
    public List<SurveyAnswers> findById(@PathVariable ("id") long id) {
        return dbHelper.getId(id);
    }
    */
}