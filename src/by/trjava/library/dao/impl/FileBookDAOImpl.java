package by.trjava.library.dao.impl;

import by.trjava.library.bean.Book;
import by.trjava.library.dao.IBookDAO;
import by.trjava.library.dao.*;
import java.io.*;

public class FileBookDAOImpl implements IBookDAO {

    private final static String DELIMITER1 = "'";
    private final static String DELIMITER2 = "';";
    private final static String DELIMITER3 = ";";
    private final static String INFO = "";
    private final static String PATH1 = "resource\\availableBooks.txt";
    private final static String PATH2 = "resource\\takenBooks.txt";

    @Override
    public void take(Book book) throws DAOException{

        try {

            deleteFromFile(book,PATH1 );
            writeInfoToFile(book,PATH2, INFO, true);

        } catch (IOException e) {
            throw new DAOException("Error! Unavailable to write to the file");
        }
    }

    @Override
    public void giveBack(Book book) throws DAOException{

        try {

            deleteFromFile(book,PATH2 );
            writeInfoToFile(book,PATH1, INFO, true);

        } catch (IOException e) {
            throw new DAOException("Error! Unavailable to write to the file");
        }
    }

    @Override
    public String getAvailableBooks() throws DAOException {

        try {

            return readInfoFromFile(PATH1);

        } catch (IOException e) {
            throw new DAOException("Error! Unavailable to read this file!");
        }
    }

    @Override
    public String getTakenBooks() throws DAOException {

        try {

            return readInfoFromFile(PATH2);

        } catch (IOException e) {
            throw new DAOException("Error! Unavailable to read this file!");
        }
    }

    private void writeInfoToFile(Book book, String fileName, String info, boolean append) throws IOException {

        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File(fileName), append)))) {

            if (info.length() == 0)
                pw.printf("\n%s '%s';", book.getAuthor().trim(), book.getBookName().trim());
            if (info.length() != 0) {
                for (String element : info.split(DELIMITER3))
                    pw.printf("\n%s;", element.trim());
            }
        }
    }

    private String readInfoFromFile(String fileName) throws IOException {

        StringBuilder stringBuilder = new StringBuilder();
        String tmp;

        try(BufferedReader  bufferedReader = new BufferedReader(new FileReader(fileName))) {

            while ((tmp = bufferedReader.readLine()) != null)
                stringBuilder.append(tmp);

        }

        return  stringBuilder.toString();
    }

    private void deleteFromFile(Book book, String fileName) throws IOException {

        StringBuilder file =  new StringBuilder(readInfoFromFile(fileName));

        file.delete(file.indexOf(book.getAuthor()), file.indexOf(book.getAuthor())+ book.getAuthor().length());
        file.delete(file.indexOf(DELIMITER1+book.getBookName()+DELIMITER2),file.indexOf(DELIMITER1+book.getBookName()+DELIMITER2)+(DELIMITER1+book.getBookName()+DELIMITER2).length());

        writeInfoToFile(book, fileName ,file.toString().trim(), false);
    }

}
