package com.neighborhood_library;

public class Book {
    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private String checkOutTo;
    //Constructor
    public Book(int id, String isbn, String title){
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = false;
        this.checkOutTo = "";
    }
    //Getters
    public int getId(){
        return id;
    }
    public String getIsbn(){
        return isbn;
    }
    public String getTitle(){
        return title;
    }
    public boolean isCheckedOut(){
        return isCheckedOut;
    }
    public String getCheckOutTo(){
        return checkOutTo;
    }
    //check ou method
    public void checkOut(String name){
        checkOutTo = name;
        isCheckedOut = true;
    }
    public void checkIn(){
        checkOutTo = "";
        isCheckedOut = false;
    }

}
