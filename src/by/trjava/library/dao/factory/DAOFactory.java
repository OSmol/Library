package by.trjava.library.dao.factory;

import by.trjava.library.dao.IBookDAO;
import by.trjava.library.dao.IUserDAO;
import by.trjava.library.dao.impl.FileBookDAOImpl;
import by.trjava.library.dao.impl.FileUserDAOImpl;

public final class DAOFactory {

    private static final DAOFactory instance = new DAOFactory();

    private final IBookDAO fileBookImpl = new FileBookDAOImpl();
    private final IUserDAO fileUserImpl = new FileUserDAOImpl();

    private DAOFactory(){}

    public static DAOFactory getInstance(){
        return instance;
    }

    public IBookDAO getBookDAO(){
        return fileBookImpl;
    }

    public IUserDAO getUserDAO() {
        return fileUserImpl;
    }
}
