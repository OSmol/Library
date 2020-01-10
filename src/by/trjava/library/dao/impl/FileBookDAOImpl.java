package by.trjava.library.dao.impl;

import by.trjava.library.bean.Book;
import by.trjava.library.dao.IBookDAO;
import by.trjava.library.dao.exception.DAOException;

import java.io.*;

public class FileBookDAOImpl implements IBookDAO {

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

    private void writeInfoToFile(Book book, String fileName, String info, boolean append){
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
            System.err.println("ошибка открытия потока " + e);

        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }

    private String readInfoFromFile(String fileName){

        BufferedReader bufferedReader = null;
        StringBuilder stringBuilder = new StringBuilder();

        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
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

    private String  deleteFromFile(Book book, String fileName){

        StringBuilder file =  new StringBuilder(readInfoFromFile(fileName));

        if(doesBookExistInFile(book, file.toString())){

            file.delete(file.indexOf(book.getAuthor()), file.indexOf(book.getAuthor())+book.getAuthor().length());
            file.delete(file.indexOf("'"+book.getBookName()+"';"),file.indexOf("'"+book.getBookName()+"';")+("'"+book.getBookName()+"';").length());

            writeInfoToFile(book, fileName ,file.toString().trim(), false);
        }

        else return "no book";

        return "";
    }

   private boolean doesBookExistInFile(Book book, String fileInfo){
        if(fileInfo.contains(book.getAuthor()+" "+ "'"+ book.getBookName()+"'"))
            return true;

        return  false;
   }

    public static void main(String [] args) throws DAOException {

        Book book1 = new Book("from a", "h");

        FileBookDAOImpl fileBookDAO = new FileBookDAOImpl();
        fileBookDAO.giveBack(book1);

    }

}
