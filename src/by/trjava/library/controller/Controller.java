package by.trjava.library.controller;

import by.trjava.library.controller.command.ICommand;

public final class Controller {

    private final CommandProvider commandProvider = new CommandProvider();
    private final static char DELIMITER = ' ';

    public String executeTask(String request){
        String response;
        ICommand  executionCommand;

        executionCommand = findExecutionCommand(request);
        response = executionCommand.execute(request);

        return response;
    }

    private String executeCommand(String request){// не перебарщивай с декомпозицией, ради одного оператора целый отдельный методп исать - перебор
        String  commandName;

        commandName = request.substring(0, request.indexOf(DELIMITER));

        return commandName;
    }


    private ICommand findExecutionCommand(String request){
        ICommand executionCommand;

        executionCommand = commandProvider.getCommand(executeCommand(request));

        return executionCommand;
    }
}
