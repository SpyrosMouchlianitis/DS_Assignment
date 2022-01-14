package com.hua.gr.DS_Assignment;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Connection;
import java.util.*;

import java.sql.DriverManager;

@SpringBootApplication
public class DsAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(DsAssignmentApplication.class, args);
	}



}