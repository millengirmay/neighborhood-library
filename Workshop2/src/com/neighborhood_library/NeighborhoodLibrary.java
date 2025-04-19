package com.neighborhood_library;

import java.util.Scanner;

public class NeighborhoodLibrary {

    private static Book[] inventory = new Book[20];
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        initializeInventory();
        showHomeScreen();
    }

    private static void initializeInventory() {
        inventory[0] = new Book(1, "978-0061120084","Thinking FAST & SLOW");
        inventory[1] = new Book(2, "978-0415420265","Become a Better of You");
        inventory[2] = new Book(3, "978-8796120147","Atomic Habit");
        inventory[3] = new Book(4, "978-0697120652","System Design In JAVA");
        inventory[4] = new Book(5, "978-1231120488","The Power of Now");
        inventory[5] = new Book(6, "978-1478120351","Healing Is the New High");
        inventory[6] = new Book(7, "978-9632120689","How to Solve Your Own Murder");
        inventory[7] = new Book(8, "978-8547120085","Can not hurt me");
        inventory[8] = new Book(9, "978-6547120082","To Have and Have More");
        inventory[9] = new Book(10, "978-9631120083","The Ashfire King");
        inventory[10] = new Book(11, "978-4120611287","The Book Thief");
        inventory[11] = new Book(12, "978-0479610084","The Shadow King");
        inventory[12] = new Book(13, "978-9457120080","Start With Why");
        inventory[13] = new Book(14, "978-0061101332","Dare to Lead");
        inventory[14] = new Book(15, "978-0069717624","Effective Java");
        inventory[15] = new Book(16, "978-0061120852","Half of a Yellow Sun");
        inventory[16] = new Book(17, "978-0061129653","Where the Crawdads Sign");
        inventory[17] = new Book(18, "978-0061120714","Things Fall Apart");
        inventory[18] = new Book(19, "978-0061120084","To kill a Mockingbird");
        inventory[19] = new Book(20, "978-0061128437","Algorithms to Live");
    }
        private static void showHomeScreen() {
            System.out.println("\nNeighorhood Library - HomeScreen");
            System.out.println("1. Show Available Books");
            System.out.println("2. Show CheckedOut Books");
            System.out.println("3. Exit");
            System.out.println("Please choose an option: ");

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    showAvailableBooks();
                    break;
                case 2:
                    showCheckedOutBooks();
                    break;
                case 3:
                    System.out.println("Thank you for using the Neighborhood Library!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    showHomeScreen();
            }
        }
        private static void showAvailableBooks() {
            System.out.println("\nAvailable Books:");
            System.out.println("ID\tISBN\tTitle");

            for (Book book : inventory) {
                if (!book.getIsCheckedOut()) {
                    System.out.println(book.getId() + "\t" + book.getIsbn() + "\t" + book.getTitle());
                }
            }
            System.out.println("\nEnter the ID of the book you want to check out, or 0 to go back:");
            int bookId = input.nextInt();
            input.nextLine();

            if (bookId == 0) {
                showHomeScreen();
            } else if (bookId < 1 || bookId > inventory.length) {
                System.out.println("Invalid book ID. Please try again.");
                showAvailableBooks();
            } else {
                Book selectedBook = inventory[bookId - 1];
                if (selectedBook.getIsCheckedOut()) {
                    System.out.println("This book is already checked out. please select another book.");
                    showAvailableBooks();
                } else {
                    System.out.println("Enter your name: ");
                    String name = input.nextLine();
                    selectedBook.checkOut(name);
                    System.out.println("You have successfully checked out: " + selectedBook.getTitle());
                    showHomeScreen();
                }
            }
        }
        private static void showCheckedOutBooks() {
            System.out.println("\nChecked Out Books:");
            System.out.println("ID\tISBN\t\tTitle\t\tChecked Out To");

            for (Book book : inventory) {
                if (book.getIsCheckedOut()) {
                    System.out.println(book.getId() + "\t" + book.getIsbn() + "\t" +
                            book.getTitle() + "\t" + book.getCheckedOutTo());
                }
            }
            System.out.println("\nEnter c to check in a book, or X to go back to home:");

            String choice = input.nextLine().toUpperCase();

            if (choice.equals("X")) {
                showHomeScreen();
            } else if (choice.equals("C")) {
                System.out.println("Enter the ID of the book you want to check in:");
                int bookId = input.nextInt();
                input.nextLine();

                if (bookId < 1 || bookId > inventory.length) {
                    System.out.println("Invalid book ID. Please try again.");
                    showCheckedOutBooks();
                } else {
                    Book selectedBook = inventory[bookId - 1];
                    if (!selectedBook.getIsCheckedOut()) {
                        System.out.println("This book is not checked out.");
                    } else {
                        selectedBook.checkIn();
                        System.out.println("You have successfully checked in: " + selectedBook.getTitle());
                    }
                    showHomeScreen();
                }
            } else {
                System.out.println("Invalid option. Please try again.");
                showCheckedOutBooks();
            }
        }

    }


