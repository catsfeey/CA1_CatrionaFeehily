package com.example.catrionaspetitions;
import java.util.ArrayList;
import java.util.List;

public class Petition {

    private static long idCounter = 0;
    private Long id;
    private String title;
    private String content;

    private List<Signature> signatures;

    public Petition(){

    }

    public Petition(String title, String content) {
        this.id = ++idCounter;
        this.title = title;
        this.content = content;
        this.signatures = new ArrayList<>();
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

    // Method to add a signature
    public void addSignature(String name, String email) {
        Signature signature = new Signature(name, email);
        signatures.add(signature);
    }


    public List<Signature> getSignatures(){
        return signatures;
        }

    // Nested class representing a signature
    public static class Signature {
        private String name;
        private String email;

        public Signature(String name, String email) {
            this.name = name;
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }


}



