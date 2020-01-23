package by.trjava.library.view;

import by.trjava.library.controller.Controller;
import by.trjava.library.view.menu.OperationsMenu;
import by.trjava.library.view.menu.UserMenu;
import by.trjava.library.view.validation.StopValidation;
import by.trjava.library.view.validation.ResponseValidation;

public class View {
    public static void main(String[] args) {

        InformationInput informationInput = new InformationInput();
        Controller controller = new Controller();

        ResponseValidation responseValidation = new ResponseValidation();
        UserMenu userMenu = new UserMenu();
        String response;

        OperationsMenu operationsMenu = new OperationsMenu();
        StopValidation stopValidation = new StopValidation();


        do{
            userMenu.userMenuText();
            response = controller.executeTask(userMenu.userMenuRequestCreating(informationInput));
            System.out.println(response);

        }while (!responseValidation.responseValidation(response));

        do {
            operationsMenu.operationsMenuText();
            response = controller.executeTask( operationsMenu.operationMenuCreating(informationInput));
            System.out.println(response);
        }while (!stopValidation.responseValidation(response));

    }
}
