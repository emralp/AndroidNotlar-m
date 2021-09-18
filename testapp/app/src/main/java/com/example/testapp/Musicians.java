package com.example.testapp;

public class Musicians {

   private String name;
   private String enstruman;
   private int age;

    public Musicians(String name, String enstruman, int age){
        this.name=name;
        this.enstruman=enstruman;
        this.age=age;
    }

    //setter gettere

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getEnstruman(){
        return enstruman;
    }
    public void setEnstruman(String enstruman){
        this.enstruman=enstruman;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age=age;
    }
}
