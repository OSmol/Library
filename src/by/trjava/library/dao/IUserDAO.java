package by.trjava.library.dao;

import by.trjava.library.bean.User;
import by.trjava.library.dao.exception.DAOException;

public interface IUserDAO {
   // String singIn(String login) throws DAOException;
    boolean registration(User user) throws DAOException;
    String getFullFile() throws DAOException;
}

