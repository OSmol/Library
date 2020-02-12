package by.trjava.library.service;

import by.trjava.library.bean.Book;

public interface ILibraryService {
    boolean take(Book book) throws ServiceException;
    boolean giveBack(Book book) throws ServiceException;
    String  showAllAvailableBooks() throws ServiceException;
}
