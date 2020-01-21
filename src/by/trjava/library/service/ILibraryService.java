package by.trjava.library.service;

import by.trjava.library.bean.Book;
import by.trjava.library.service.exception.ServiceException;

public interface ILibraryService {
    boolean take(Book book) throws ServiceException;
    boolean giveBack(Book book) throws ServiceException;
    String  showAllAvailableBooks() throws ServiceException;
}
