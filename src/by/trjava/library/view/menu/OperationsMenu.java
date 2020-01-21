package by.trjava.library.view.menu;

import by.trjava.library.view.InformationInput;

public class OperationsMenu {

    public void operationsMenuText(){
        System.out.println("Library menu:");
        System.out.println("1 - Show available books");
        System.out.println("2 - Take the book");
        System.out.println("3 - Give back the book");
        System.out.println("4 - Exit");
        System.out.println("Your choice?");
    }

    private void bookNameText(){
        System.out.println("Enter book:");
    }

    private void authorNametext(){
        System.out.println("Enter author:");
    }

    public String operationMenuCreating(InformationInput informationInput){

        StringBuilder request = new StringBuilder();

        switch (informationInput.choiceInput()){
            case 1: return ("SHOW_BOOKS show");
            case 2: request.append("TAKE_BOOK "); break;
            case 3: request.append("GIVE_BACK_BOOK ");break;
            case 4:  return "WRONG_REQUEST Good bye!;";
            default: return "WRONG_REQUEST Illegal input!Try again!;";
        }

        authorNametext();
        request.append("author=");
        request.append(informationInput.dataInput());
        request.append("; ");
        bookNameText();
        request.append("book=");
       // request.append("'");
        request.append(informationInput.dataInput());
       // request.append("'");
        request.append(";");

        return request.toString();
    }
}
