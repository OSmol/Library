package by.trjava.library.view;

import by.trjava.library.controller.Controller;
import by.trjava.library.view.menu.OperationsMenu;
import by.trjava.library.view.menu.UserMenu;
import by.trjava.library.view.validation.OperationMenuStopValidation;
import by.trjava.library.view.validation.RequestValidation;

public class View {
    public static void main(String[] args) {

        InformationInput informationInput = new InformationInput();
        Controller controller = new Controller();

        RequestValidation requestValidation = new RequestValidation();
        UserMenu userMenu = new UserMenu();
        String response;

        OperationsMenu operationsMenu = new OperationsMenu();
        OperationMenuStopValidation stopValidation = new OperationMenuStopValidation();


        do{
            userMenu.userMenuText();
            response = controller.executeTask(userMenu.userMenuRequestCreating(informationInput));
            System.out.println(response);

        }while (!requestValidation.requestValidation(response));

        do {
            operationsMenu.operationsMenuText();
            response = controller.executeTask( operationsMenu.operationMenuCreating(informationInput));
            System.out.println(response);
        }while (stopValidation.responseValidation(response));

    }
}
