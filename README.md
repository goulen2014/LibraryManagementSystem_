# Library Management System

## Overview

The Library Management System is a Java-based web application using Maven build tool, designed to streamline the management of library operations. It includes functionality for managing librarians and books. The project uses JSP (Java Server Pages) for the front-end and Java Servlets for the back-end. The database used is MySQL.

---

## Features

### Admin Features

- Add new librarians.
- View all librarians.
- Edit librarian details.
- Delete librarians.
- Logout.

### Librarian Features

- Add new books.
- Edit book details.
- Delete books.
- View all books.
- Issue books to users.
- View issued books.
- Return books.
- Logout.

---

## Requirements

- **IDE:** NetBeans
- **Server:** Apache Tomcat
- **Database:** MySQL
- **Java Version:** JDK 8 or higher

---

## Project Setup

### Step 1: Clone or Download the Repository

1. Clone this repository or download it as a ZIP file.
2. Extract the ZIP file (if downloaded).

### Step 2: Configure the Database

1. Open MySQL and create a database named `librarymanagementsystem`.
2. Run the SQL script provided to set up the required tables:
    
    ### `admin` Table
    
    This table will store admin credentials.
    
    ```sql
    CREATE TABLE admin (
        id INT AUTO_INCREMENT PRIMARY KEY,
        username VARCHAR(50) NOT NULL,
        password VARCHAR(255) NOT NULL
    );
    ```
    
    ### `librarian` Table
    
    This table will store librarian details.
    
    ```sql
    CREATE TABLE librarian (
        id INT AUTO_INCREMENT PRIMARY KEY,
        name VARCHAR(100) NOT NULL,
        email VARCHAR(100) UNIQUE NOT NULL,
        phone VARCHAR(15) NOT NULL,
        password VARCHAR(255) NOT NULL
    );
    ```
    
    ### `book` Table
    
    This table will store book details.
    
    ```sql
    CREATE TABLE book (
        id INT AUTO_INCREMENT PRIMARY KEY,
        title VARCHAR(255) NOT NULL,
        author VARCHAR(255) NOT NULL,    
        quantity INT NOT NULL,    
    );
    ```
    
    ### `issued_books` Table
    
    This table will track issued books.
    
    ```sql
    CREATE TABLE issued_books (
        id INT AUTO_INCREMENT PRIMARY KEY,
        book_id INT NOT NULL,
        issued_to VARCHAR(100) NOT NULL,
        issue_date DATE NOT NULL,
        return_date DATE,
        FOREIGN KEY (book_id) REFERENCES book(id) ON DELETE CASCADE
    );
    ```
    
    ### Insert Sample Admin Account
    
    Use the following script to insert a sample admin account (you can replace the password with your own hashed password).
    
    ```sql
    INSERT INTO admin (username, password)
    VALUES ('admin', 'admin123');
    ```
    

### Step 3: Import the Project into NetBeans

1. Open NetBeans.
2. Go to `File > Open Project`.
3. Navigate to the folder where you downloaded the project and open it.

### Step 4: Configure Apache Tomcat Server

1. Ensure Apache Tomcat is installed and configured in NetBeans.
2. Go to `Tools > Servers`.
3. Add the Apache Tomcat server if not already configured.

### Step 5: Update Database Connection

1. Open the `LibrarianDAO.java` and other DAO files.
2. Update the database connection credentials (URL, username, and password) to match your MySQL setup:
    
    ```java
    private final String jdbcURL = "jdbc:mysql://localhost:3306/librarymanagementsystem";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "your_password";
    
    ```
    

### Step 6: Build and Run the Project

1. Clean and build the project in NetBeans using `Build > Clean and Build Project`.
2. Deploy the project to the Apache Tomcat server by running it (`Run > Run Project`).
3. Access the application in your web browser at `http://localhost:8080/LibraryManagementSystem`.

---

## File Structure

```
├── Web Pages
│   ├── META-INF
│   ├── WEB-INF
│   ├── addLibrarian.jsp
│   ├── adminDashboard.jsp
│   ├── editLibrarian.jsp
│   ├── librarianDashboard.jsp
│   ├── login.jsp
│   ├── viewLibrarians.jsp
│
├── Source Packages
│   ├── com.lms.controller
│   │   ├── AdminLoginServlet.java
│   │   ├── AdminServlet.java
│   │   ├── LibrarianServlet.java
│   ├── com.lms.dao
│   │   ├── BookDAO.java
│   │   ├── LibrarianDAO.java
│   │   ├── LoginDAO.java
│   ├── com.lms.model
│   │   ├── Book.java
│   │   ├── Librarian.java
```

---

## How to Use

### Admin Login

1. Login to the application using the Admin credentials (configured in the database).
2. Manage librarians using the Admin dashboard.

### Librarian Login

1. Login to the application using the Librarian credentials (configured in the database).
2. Manage books and issue/return books using the Librarian dashboard.

---

## Technologies Used

- **Frontend:** JSP, HTML, CSS
- **Backend:** Java (Servlets)
- **Database:** MySQL
- **Server:** Apache Tomcat

---

## License

This project is licensed under the MIT License. Feel free to use and modify it as needed.