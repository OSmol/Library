package by.trjava.library.dao.impl;

import by.trjava.library.bean.User;
import by.trjava.library.dao.IUserDAO;
import by.trjava.library.dao.exception.DAOException;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileUserDAOImpl implements IUserDAO {

//    @Override
//    public String singIn(String login) throws DAOException {
//        return  findPasswordByLogin(login);
//    }

    @Override
    public boolean registration(User user) throws DAOException{

        PrintWriter pw = null;

        try {

            pw =  new PrintWriter(new BufferedWriter(new FileWriter(new File("resource\\clients.txt"), true)));
            pw.printf("\n%s %s;", user.getLogin(), user.getPassword() );

            return  true;

        } catch (IOException e) {

            throw new DAOException("Impossible to write to this file!");

        } finally {
            if (pw != null) {
                pw.close();
            }
        }

    }

    @Override
    public String getFullFile() throws DAOException {
        return readFile();
    }

//    private String findPasswordByLogin(String login) throws DAOException {
//
//        Pattern pattern = Pattern.compile(login);
//        Matcher matcher = pattern.matcher(readFile());
//        String [] array = readFile().split("[;\\s]");
//        String password= "";
//
//        if(matcher.find())
//            for(int i=0;i<array.length;i++)
//                if(array[i].equals(login))
//                    password = array[i+1];
//
//        return password;
//    }


    private String readFile() throws DAOException {

        BufferedReader bufferedReader = null;
        StringBuilder stringBuilder = new StringBuilder();

        try {
            bufferedReader = new BufferedReader(new FileReader("resource//clients.txt"));
            String tmp;
            while ((tmp = bufferedReader.readLine()) != null)
                stringBuilder.append(tmp);

        } catch (IOException e) {
            throw new DAOException("Impossible to read this file");
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    throw new DAOException("Impossible to read this file!");
                }
            }
        }

        return  stringBuilder.toString();
    }

}

