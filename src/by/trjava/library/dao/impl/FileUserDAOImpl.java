package by.trjava.library.dao.impl;

import by.trjava.library.bean.User;
import by.trjava.library.dao.IUserDAO;
import by.trjava.library.dao.exception.DAOException;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileUserDAOImpl implements IUserDAO {

    @Override
    public void singIn(String login, String password) throws DAOException {// может ли у интефрйеса быть не воид метод, продусать функционал
         boolean result = dataComparison(login,password) ;
         if(result == true)
             System.out.println("yes");
         else System.out.println("no!");
    }

    @Override
    public void registration(User user) throws DAOException{

        PrintWriter pw = null;
        try {

            pw =  new PrintWriter(new BufferedWriter(new FileWriter(new File("resource\\clients.txt"), true)));
            pw.printf("  %s %s  ", user.getLogin(), user.getPassword() );

        } catch (IOException e) {
            System.err.println("ошибка открытия потока " + e);

        } finally {
            if (pw != null) {
                pw.close();
            }
        }

    }

    private boolean dataComparison(String login, String password){

        Pattern pattern = Pattern.compile(""+login+"\\s"+password+"\\s+");
        Matcher matcher = pattern.matcher(fileToString());

        return matcher.find();
    }


    private String fileToString(){

        BufferedReader bufferedReader = null;
        StringBuilder stringBuilder = new StringBuilder();

        try {
            bufferedReader = new BufferedReader(new FileReader("resource//clients.txt"));
            String tmp;
            while ((tmp = bufferedReader.readLine()) != null)
                stringBuilder.append(tmp);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return  stringBuilder.toString();
    }

}

