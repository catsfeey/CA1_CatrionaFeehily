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
    private final List<Petition> petitions = new ArrayList<>();
    private List<Signature> signatures;

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

    public void addPetition(Petition petition) {
        petitions.add(petition);
    }

    public List<Petition> getPetitions() {
        return petitions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Petition> searchPetitions(String title) {
        List<Petition> result = new ArrayList<>();

        for (Petition petition : petitions) {
            if (petition.getTitle().equalsIgnoreCase(title)) {
                result.add(petition);
            }
        }

        return result;
    }
}



