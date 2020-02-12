package by.trjava.library.service.impl;

import by.trjava.library.bean.User;
import by.trjava.library.dao.IUserDAO;
import by.trjava.library.dao.*;
import by.trjava.library.dao.factory.DAOFactory;
import by.trjava.library.service.IClientService;
import by.trjava.library.service.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientServiceImpl implements IClientService {

    @Override
    public boolean singIn(String login, String password) throws ServiceException {

        IUserDAO factory = DAOFactory.getInstance().getUserDAO();

        try {

            if(userProfileExistenceCheck(login, password, factory)){
                return  true;
            }

        } catch (DAOException e) {
            throw new ServiceException("Error! Impossible to sing in!");
        }

        return false;
    }

    @Override
    public boolean registration(User user) throws ServiceException{

        IUserDAO factory = DAOFactory.getInstance().getUserDAO();

        try {

            if(userDataCheck(user.getLogin(), factory)){
                return false;
            }
            else {
                factory.registration(user);
                return true;
            }

        } catch (DAOException e) {
            throw new ServiceException("Error! Unable to register user");
        }

    }


    private boolean userDataCheck(String data,IUserDAO factory ) throws DAOException {

        Matcher matcher;
        Pattern pattern;

        if(data.length()!=0){
            pattern = Pattern.compile(""+data+"\\s");
            matcher = pattern.matcher(factory.getFullFile());

            if (matcher.find()){
                    return true;
            }

        }

        return  false;
    }

    private boolean userProfileExistenceCheck(String login,  String password, IUserDAO factory) throws DAOException {

        Pattern pattern;
        Matcher matcher ;

        pattern = Pattern.compile("." + login + "\\s" + password + ";");
        matcher = pattern.matcher(factory.getFullFile());

        if (!matcher.find())
            return false;


       return true;
    }
}
