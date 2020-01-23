package by.trjava.library.controller;

import by.trjava.library.controller.command.ICommand;

public final class Controller {

    private final CommandProvider commandProvider = new CommandProvider();

    public String executeTask(String request){
        String response;
        ICommand  executionCommand;

        executionCommand = findExecutionCommand(request);
        response = executionCommand.execute(request);

        return response;
    }

    private String executeCommand(String request){
        String  commandName;
        char delimiter = ' ';

        commandName = request.substring(0, request.indexOf(delimiter));

        return commandName;
    }


    private ICommand findExecutionCommand(String request){
        ICommand executionCommand;

        executionCommand = commandProvider.getCommand(executeCommand(request));

        return executionCommand;
    }

}
