package com.sempertech.MySqlProject;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import com.sempertech.MySqlProject.model.SurveyAnswers;
import com.sempertech.MySqlProject.model.SurveyQuestions;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class DBHelper {
    private Connection con;
/*
    public DBHelper() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/survey", "springuser", "asdffdsa");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public List<SurveyAnswers> getAll() {
        List<SurveyAnswers> results = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from answers;");
            while (rs.next()) {
                SurveyAnswers answer = new SurveyAnswers(rs.getLong(1), rs.getString(2));
                results.add(answer);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return results;
    }

    public List<SurveyQuestions> getAllQ() {
        List<SurveyQuestions> results = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from questions;");
            while (rs.next()) {
                SurveyQuestions questions = new SurveyQuestions(rs.getInt(1), rs.getString(2));
                results.add(questions);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return results;
    }

    public List<SurveyAnswers> insertAnswers(String fA,String sA, String tA) {
        List<SurveyAnswers> results = new ArrayList<>();
        try {
            Statement stmt = (Statement) con.createStatement();
            int rs = stmt.executeUpdate("INSERT INTO `survey`.`answers` (`firstQ`, `secondQ`, `thirdQ`) VALUES ('"+ fA +"', '"+ sA +"', '"+ tA +"');");

        } catch (Exception e) {
            System.out.println(e);
        }
        return getAll();

    }

    public List<SurveyAnswers> updateAnswers(long id, String fA, String sA, String tA) {
        List<SurveyAnswers> results = new ArrayList<>();
        try {
            Statement stmt = (Statement) con.createStatement();
            int rs = stmt.executeUpdate("UPDATE `survey`.`answers` SET `firstQ` = '"+ fA +"', `secondQ` = '"+ sA +"', `thirdQ` = '"+ tA +"'  WHERE (`id` = '"+ id +"');");

        } catch (Exception e) {
            System.out.println(e);
        }
        return getAll();
    }

    public List<SurveyAnswers> deleteAnswers(long id) {
        List<SurveyAnswers> results = new ArrayList<>();
        try {
            Statement stmt = (Statement) con.createStatement();
            stmt.executeUpdate("ALTER TABLE survey.answers AUTO_INCREMENT = "+id+";");
            int rs = stmt.executeUpdate("DELETE FROM `survey`.`answers` WHERE (`id` = '"+id  +"');");

        } catch (Exception e) {
            System.out.println(e);
        }
        return getAll();
    }

    public List<SurveyQuestions> deleteQuestions(long id) {
        List<SurveyQuestions> results = new ArrayList<>();
        try {
            Statement stmt = (Statement) con.createStatement();
            stmt.executeUpdate("ALTER TABLE survey.questions AUTO_INCREMENT = "+id+";");
            int rs = stmt.executeUpdate("DELETE FROM `survey`.`questions` WHERE (`id_questions` = '"+id  +"');");

        } catch (Exception e) {
            System.out.println(e);
        }
        return getAllQ();
    }

    public List<SurveyAnswers> getId(long id) {
        List<SurveyAnswers> results = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from answers where id = "+ id +";");
            while (rs.next()) {
                SurveyAnswers answer = new SurveyAnswers(rs.getString(2));
                results.add(answer);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return results;
    }*/
}
