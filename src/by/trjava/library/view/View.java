package by.trjava.library.view;

import by.trjava.library.controller.Controller;
import by.trjava.library.view.menu.UserMenu;
import by.trjava.library.view.validation.RequestValidation;

public class View {
    public static void main(String[] args) {

        InformationInput informationInput = new InformationInput();
        Controller controller = new Controller();
        RequestValidation requestValidation = new RequestValidation();
        UserMenu userMenu = new UserMenu();
        String response;

        do{
            userMenu.userMenuText();
            response = controller.executeTask(userMenu.userMenuRequestCreating(informationInput));
            System.out.println(response);

        }while (!requestValidation.requestValidation(response));

            System.out.println("out");
    }
}
