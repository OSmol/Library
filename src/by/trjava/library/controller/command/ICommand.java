package by.trjava.library.controller.command;

public interface ICommand {

    static final char DELIMITER1 = '=';
    static final char DELIMITER2 = ';';

    String execute(String request);
}
