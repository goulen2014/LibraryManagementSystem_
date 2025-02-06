
package com.lms.model;

import java.sql.Date;

public class IssuedBooks {
    private int bookId;
    private int librarianId;
    private Date issueDate;
    private Date returnDate;
    
    public IssuedBooks(int bookId, int librarianId, Date issueDate, Date returnDate) {
        this.bookId = bookId;
        this.librarianId = librarianId;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getLibrarianId() {
        return librarianId;
    }

    public void setLibrarianId(int librarianId) {
        this.librarianId = librarianId;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
        
}
