package by.trjava.library.service.impl;

import by.trjava.library.bean.Book;
import by.trjava.library.dao.IBookDAO;
import by.trjava.library.dao.exception.DAOException;
import by.trjava.library.dao.factory.DAOFactory;
import by.trjava.library.service.ILibraryService;
import by.trjava.library.service.exception.ServiceException;

public class LibraryServiceImpl implements ILibraryService {

    @Override
    public boolean take(Book book) throws ServiceException {

        IBookDAO factory = DAOFactory.getInstance().getBookDAO();

        try {
            if (bookExistenceCheckForTaking(book, factory)) {
                factory.take(book);
                return true;
            }
        } catch (DAOException e) {
            throw new ServiceException("Error!Unable to take this book!");
        }

        return false;
    }

    @Override
    public boolean giveBack(Book book) throws ServiceException {

        IBookDAO factory = DAOFactory.getInstance().getBookDAO();

        try {
            if (bookExistenceCheckForGivingBack(book, factory)) {
                factory.giveBack(book);
                return true;
            }
        } catch (DAOException e) {
            throw new ServiceException("Error!Unable to give back this book!");
        }

        return false;
    }

    @Override
    public String showAllAvailableBooks() throws ServiceException {

        IBookDAO factory = DAOFactory.getInstance().getBookDAO();

        try {
            return  factory.getAvailableBooks();
        } catch (DAOException e) {
            throw new ServiceException("Error!Unable to show books");
        }
    }

    private boolean bookExistenceCheckForTaking(Book book, IBookDAO factory) throws ServiceException {

        try {
            if (factory.getAvailableBooks().contains(book.getAuthor() + " " + "'" + book.getBookName() + "'"))
                return true;
        } catch (DAOException e) {
            throw new ServiceException("Error!Unable to take this book!");
        }

        return false;
    }

    private boolean bookExistenceCheckForGivingBack(Book book, IBookDAO factory) throws ServiceException {

        try {
            if (factory.getTakenBooks().contains(book.getAuthor() + " " + "'" + book.getBookName() + "'"))
                return true;
        } catch (DAOException e) {
            throw new ServiceException("Error!Unable to give back this book!");
        }

        return false;
    }
}