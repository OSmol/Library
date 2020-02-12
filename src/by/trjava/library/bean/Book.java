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


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;

        if (author == null) {
            if(other.author!= null)
                return false;
        }else if(!author.equals(other.author))
            return false;

        if (bookName == null) {
            if(other.bookName!= null)
                return false;
        }else if(!bookName.equals(other.bookName))
            return false;


        return true;
    }

    @Override
    public int hashCode() {
        return (((author==null)?0:author.hashCode())+ ((bookName==null)?0:bookName.hashCode()));
    }


    @Override
    public String toString() {
        return getClass().getName() + " author = " + author + " book = " + bookName;
    }
}

