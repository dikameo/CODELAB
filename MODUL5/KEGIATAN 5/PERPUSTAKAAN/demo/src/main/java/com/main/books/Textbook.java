package com.main.books;

public class Textbook extends Book{
    private String category;
    
    public Textbook(){

    }

    
    public void setCategory(String category){
        this.category = category;
    }

    public String getCategory(){
        return this.category;
    }
}
