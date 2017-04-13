package com.theironyard;

/**
 * Created by JamesHartanto on 4/12/17.
 */
public class Player {
    private int id;
    private String name;
    private String description;
    private String age;
    private int score;

    public Player() {
    }

    public Player(String name, String description, String age, int score) {
        this.name = name;
        this.description = description;
        this.age = age;
        this.score = score;
    }

    public Player(int id, String name, String description, String age, int score) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.age = age;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
