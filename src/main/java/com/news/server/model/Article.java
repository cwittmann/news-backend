package com.news.server.model;

import org.springframework.data.annotation.Id;

public class Article {

    @Id
    public String id;

    public String author;
    public String title;
    public String description;
    public String url;
    public String urlToImage;
    public String publishedAt;
    public String content;
    public String category;

    public Article() {
    }

    public Article(String id, String author, String title, String description, String url, String urlToImage,
            String publishedAt, String content, String category) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
        this.content = content;
        this.category = category;
    }
}