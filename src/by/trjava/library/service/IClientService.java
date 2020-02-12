package by.trjava.library.service;

import by.trjava.library.bean.User;

public interface IClientService {
    boolean singIn(String login, String password) throws ServiceException;
    boolean registration(User user) throws ServiceException;
}
