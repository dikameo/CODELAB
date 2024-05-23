package com.main.books;

public class Storybook extends Book{
    private String category;

    public Storybook(){

    }

    
    public void setCategory(String category){
        this.category = category;
    }

    public String getCategory(){
        return this.category;
    }
}
