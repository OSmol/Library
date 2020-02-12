package by.trjava.library.dao;

import by.trjava.library.bean.User;

public interface IUserDAO {
    boolean registration(User user) throws DAOException;
    String getFullFile() throws DAOException;
}

