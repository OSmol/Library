package by.trjava.library.dao.impl;

import by.trjava.library.bean.Book;
import by.trjava.library.dao.IBookDAO;
import by.trjava.library.dao.exception.DAOException;
import java.io.*;

public class FileBookDAOImpl implements IBookDAO {

    private final static String DELIMITER1 ="'";
    private final static String DELIMITER2 ="';";

    @Override
    public void take(Book book) throws DAOException{

        deleteFromFile(book,"resource\\availableBooks.txt" );
        writeInfoToFile(book,"resource\\takenBooks.txt", "", true);
    }

    @Override
    public void giveBack(Book book) throws DAOException{

        deleteFromFile(book,"resource\\takenBooks.txt" );
        writeInfoToFile(book,"resource\\availableBooks.txt", "", true);
    }

    @Override
    public String getAvailableBooks() throws DAOException {

        return readInfoFromFile("resource\\availableBooks.txt");
    }

    @Override
    public String getTakenBooks() throws DAOException {

        return readInfoFromFile("resource\\takenBooks.txt");
    }

    private void writeInfoToFile(Book book, String fileName, String info, boolean append) throws DAOException {
        PrintWriter pw = null;

        try {
            pw =  new PrintWriter(new BufferedWriter(new FileWriter(new File(fileName), append)));

            if(info.length()==0)
                pw.printf("\n%s '%s';", book.getAuthor().trim(),book.getBookName().trim());
            if(info.length()!=0){
                for (String element: info.split(";"))
                    pw.printf("\n%s;", element.trim());
            }
        } catch (IOException e) {
           throw new DAOException("Error! Unavailable to write to the file");
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }

    private String readInfoFromFile(String fileName) throws DAOException {

        BufferedReader bufferedReader = null;
        StringBuilder stringBuilder = new StringBuilder();

        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            String tmp;
            while ((tmp = bufferedReader.readLine()) != null)
                stringBuilder.append(tmp);

        } catch (IOException e) {
           throw new DAOException("Error! Unavailable to read this file!");
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    throw new DAOException("Error! Unavailable to read this file!");
                }
            }
        }
        return  stringBuilder.toString();
    }

    private void deleteFromFile(Book book, String fileName) throws DAOException {

        StringBuilder file =  new StringBuilder(readInfoFromFile(fileName));

        file.delete(file.indexOf(book.getAuthor()), file.indexOf(book.getAuthor())+ book.getAuthor().length());
        file.delete(file.indexOf(DELIMITER1+book.getBookName()+DELIMITER2),file.indexOf(DELIMITER1+book.getBookName()+DELIMITER2)+(DELIMITER1+book.getBookName()+DELIMITER2).length());

        writeInfoToFile(book, fileName ,file.toString().trim(), false);
    }

}
