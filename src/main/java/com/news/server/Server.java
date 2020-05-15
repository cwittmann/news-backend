package com.news.server;

import java.util.List;

import com.news.server.db.ArticleRepository;
import com.news.server.model.Article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Server implements CommandLineRunner {

	@Autowired
	private ArticleRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Server.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<Article> articles = repository.findAll();
	}

}
