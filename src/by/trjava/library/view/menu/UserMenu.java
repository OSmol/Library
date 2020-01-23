package by.trjava.library.view.menu;

import by.trjava.library.view.InformationInput;

public class UserMenu {

    public void userMenuText(){
        System.out.println("Welcome to the library");
        System.out.println("1 - Sing in");
        System.out.println("2 - Registration");
        System.out.println("Your choice?");
    }

    private void loginInputText(){
        System.out.println("Enter login");
    }

    private void passwordInputText(){
        System.out.println("Enter password");
    }

    public String userMenuRequestCreating( InformationInput informationInput){

        StringBuilder request = new StringBuilder();

        switch (informationInput.intInput()){
            case 1: request.append("SING_IN "); break;
            case 2: request.append("REGISTER "); break;
            default: return "WRONG_REQUEST Illegal input!;";
        }

        request.append("login=");
        loginInputText();
        request.append(informationInput.stringInput());
        request.append("; ");
        request.append("password=");
        passwordInputText();
        request.append(informationInput.stringInput());
        request.append(";");

        return request.toString();
    }

}
