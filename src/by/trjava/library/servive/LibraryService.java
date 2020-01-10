package by.trjava.library.servive;

import by.trjava.library.bean.Book;
import by.trjava.library.servive.exception.ServiceException;

public interface LibraryService{
    void take(Book book) throws ServiceException;
    void giveBack(Book book) throws ServiceException;
}
