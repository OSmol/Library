package by.trjava.library.controller;

import by.trjava.library.controller.command.ICommand;
import by.trjava.library.controller.command.impl.*;
import java.util.HashMap;
import java.util.Map;

final  class CommandProvider {

    private  final Map <CommandName, ICommand> commands = new HashMap<>();

    CommandProvider(){
        commands.put(CommandName.SING_IN, new SingIn());
        commands.put(CommandName.REGISTER, new Register());
        commands.put(CommandName.TAKE_BOOK, new TakeBook());
        commands.put(CommandName.GIVE_BACK_BOOK, new GiveBackBook());
        commands.put(CommandName.WRONG_REQUEST, new WrongRequest());
        commands.put(CommandName.SHOW_BOOKS, new ShowBook());
    }

    ICommand getCommand(String name){
        CommandName commandName;
        ICommand command;

        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = commands.get(commandName);
        }catch (IllegalArgumentException e){
            command = commands.get(CommandName.WRONG_REQUEST);
        }

        return command;
    }
}
