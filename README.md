# Neighborhood Library 

This is a simple Java console application for a community-based library system. It allows users to check out and return books using an honor system.

## Features

- View available books
- Check out books by entering a name
- View checked out books
- Return books by ID
- Console-based UI with clear instructions

## Book Class Structure

Each book has:
- `id`: int
- `isbn`: String
- `title`: String
- `isCheckedOut`: boolean
- `checkedOutTo`: String

### Methods:
- `checkOut(String name)`
- `checkIn()`

## How to Run

1. Clone this repository
2. Compile and run with Java or Maven

### With Maven:
```bash
mvn compile

Author
Million Girmay
Yearup Student|Seattle,WA
