package com.news.server.controller;

import java.util.List;

import com.news.server.db.ArticleRepository;
import com.news.server.exception.NotFoundException;
import com.news.server.model.Article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {

    @Autowired
    private ArticleRepository repository;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/api/articles")
    public List<Article> getArticles() {
        return repository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/api/articles/{id}")
    public Article getArticle(@PathVariable String id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Article not found: " + id));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/api/articles")
    public Article postArticle(@RequestBody Article article) {
        return repository.save(article);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/api/articles/{id}")
    public Article putArticle(@RequestBody Article newArticle, @PathVariable String id) {
        return repository.findById(id).map(article -> {
            article.author = newArticle.author;
            article.category = newArticle.category;
            article.content = newArticle.content;
            article.description = newArticle.description;
            article.publishedAt = newArticle.publishedAt;
            article.title = newArticle.title;
            article.url = newArticle.url;
            article.urlToImage = newArticle.urlToImage;
            return repository.save(article);
        }).orElseThrow(() -> new NotFoundException("Article not found: " + id));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/api/articles")
    public void deleteArticle(@PathVariable String id) {
        repository.deleteById(id);
    }
}