package by.trjava.library.dao;

import by.trjava.library.bean.Book;
import by.trjava.library.dao.exception.DAOException;
import com.sun.org.apache.bcel.internal.generic.DDIV;

import java.util.zip.DataFormatException;

public interface IBookDAO{
    void take(Book book) throws DAOException;
    void giveBack(Book book) throws DAOException;
    String getTakenBooks() throws DAOException;
    String getAvailableBooks() throws DAOException;

}
