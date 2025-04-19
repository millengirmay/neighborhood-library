package com.neighborhood_library;

public class Book {
    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private String checkedOutTo;
    //Constructor
    public Book(int id, String isbn, String title){
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = false;
        this.checkedOutTo = "";
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
    public boolean getIsCheckedOut(){
        return isCheckedOut;
    }
    public String getCheckedOutTo(){
        return checkedOutTo;
    }
    //check ou method
    public void checkOut(String name){
        checkedOutTo = name;
        isCheckedOut = true;
    }
    public void checkIn(){
        checkedOutTo = "";
        isCheckedOut = false;
    }

}
