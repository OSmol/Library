package by.trjava.library.dao;

import by.trjava.library.bean.Book;

public interface IBookDAO{// именование интерфейсов с I уже устарело, лет 5-8 как устарело совсем
    void take(Book book) throws DAOException;
    void giveBack(Book book) throws DAOException;
    String getTakenBooks() throws DAOException;
    String getAvailableBooks() throws DAOException;

}
