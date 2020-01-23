package by.trjava.library.bean;

import java.io.Serializable;

public class Book implements Serializable {

    private String author;
    private String bookName;

    public Book(String author, String bookName){
        this.author = author;
        this.bookName = bookName;
    }

    public Book(){}

    public String getAuthor() {
        return author;
    }

    public String getBookName() {
        return bookName;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
