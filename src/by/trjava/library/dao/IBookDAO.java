package by.trjava.library.dao;

import by.trjava.library.bean.Book;

public interface IBookDAO{
    void take(Book book) throws DAOException;
    void giveBack(Book book) throws DAOException;
    String getTakenBooks() throws DAOException;
    String getAvailableBooks() throws DAOException;

}
