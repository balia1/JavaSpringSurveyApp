package com.sempertech.MySqlProject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.AccessTokenRequest;
import org.springframework.security.oauth2.client.token.DefaultAccessTokenRequest;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.ArrayList;
import java.util.Scanner;

@SpringBootApplication
@EnableJpaRepositories("com.sempertech.MySqlProject")
@EntityScan("com.sempertech.MySqlProject.model")
@ComponentScan(basePackages = {"com.sempertech.MySqlProject","com.sempertech.MySqlProject.boot.controller.surveyController","com.sempertech.MySqlProject.boot.controller.userController","com.sempertech.MySqlProject.service"})
public class MySqlProjectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MySqlProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}
}


