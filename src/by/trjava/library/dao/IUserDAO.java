package by.trjava.library.dao;

import by.trjava.library.bean.User;
import by.trjava.library.dao.exception.DAOException;

public interface IUserDAO {
    void singIn(String login, String password) throws DAOException;
    void registration(User user) throws DAOException;
}

