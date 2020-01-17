package by.trjava.library.dao;

import by.trjava.library.bean.Book;
import by.trjava.library.dao.exception.DAOException;

public interface IBookDAO{
    void take(Book book) throws DAOException;
    void giveBack(Book book) throws DAOException;
    String getTakenBooks() throws DAOException;
    String getAvailableBooks() throws DAOException;

}
