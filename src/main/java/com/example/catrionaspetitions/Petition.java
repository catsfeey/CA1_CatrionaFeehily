package com.example.catrionaspetitions;

import org.springframework.cglib.core.Signature;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Petition {

    private static long idCounter = 0;
    private Long id;
    private String title;
    private String content;

    private List<Signature> signatures;

    public Petition(String title, String content) {
        this.id = ++idCounter;
        this.title = title;
        this.content = content;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }




}



