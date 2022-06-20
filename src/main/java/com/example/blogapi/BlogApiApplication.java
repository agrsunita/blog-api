package com.example.blogapi;

import com.fasterxml.jackson.core.*;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpInputMessage;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class BlogApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(BlogApiApplication.class, args);
		System.out.println("Spring-boot Application has started !");


	}

}
