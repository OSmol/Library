package by.trjava.library.dao;

import by.trjava.library.bean.User;
import by.trjava.library.dao.exception.DAOException;

public interface IUserDAO {
    boolean registration(User user) throws DAOException;
    String getFullFile() throws DAOException;
}

