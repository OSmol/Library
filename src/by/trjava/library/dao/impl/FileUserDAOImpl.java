package by.trjava.library.dao.impl;

import by.trjava.library.bean.User;
import by.trjava.library.dao.*;
import java.io.*;

public class FileUserDAOImpl implements IUserDAO{

    private final static String PATH1 = "resource//clients.txt";

    @Override
    public boolean registration(User user) throws DAOException{

        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File(PATH1), true)))) {

            pw.printf("\n%s %s;", user.getLogin(), user.getPassword());

            return true;

        } catch (IOException e) {
            throw new DAOException("Impossible to write to this file!");
        }
    }

    @Override
    public String getFullFile() throws DAOException {
        try {
            return readFile();
        } catch (IOException e) {
            throw new DAOException("Impossible to read this file");
        }
    }

    private String readFile() throws IOException {

        StringBuilder stringBuilder = new StringBuilder();

        try(BufferedReader  bufferedReader = new BufferedReader(new FileReader(PATH1))) {

            String tmp;
            while ((tmp = bufferedReader.readLine()) != null)
                stringBuilder.append(tmp);
        }

        return  stringBuilder.toString();
    }


}

