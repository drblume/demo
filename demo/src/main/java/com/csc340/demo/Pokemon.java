package com.csc340.demo;

public class Pokemon {
    public String name;
    public int id;
    public int height;
    public int weight;

    public Pokemon(String name, int id, int height, int weight){
        this.name = name;
        this.id = id;
        this.height = height;
        this.weight = weight;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
