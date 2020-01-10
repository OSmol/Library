package by.trjava.library.bean;

public class Book {

    private String author;
    private String bookName;

    public Book(String author, String bookName){
        this.author = author;
        this.bookName = bookName;
    }


    public String getAuthor() {
        return author;
    }

    public String getBookName() {
        return bookName;
    }
}
