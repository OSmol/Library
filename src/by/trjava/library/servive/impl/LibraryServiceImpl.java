package by.trjava.library.servive.impl;

import by.trjava.library.bean.Book;
import by.trjava.library.servive.LibraryService;
import by.trjava.library.servive.exception.ServiceException;

public class LibraryServiceImpl implements LibraryService {

    @Override
    public void take(Book book) throws ServiceException{

    }

    @Override
    public void giveBack(Book book) throws ServiceException {}
}
