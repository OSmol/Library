package by.trjava.library.servive;

import by.trjava.library.bean.User;
import by.trjava.library.servive.exception.ServiceException;

public interface ClientService {
    void singIn(String login, String password) throws ServiceException;
    void registration(User user) throws ServiceException;
}
