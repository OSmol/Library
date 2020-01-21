package by.trjava.library.view.validation;

public class OperationMenuStopValidation {

    public boolean responseValidation(String response){

        if(response.equals("Good bye!".trim()))
            return false;
        else return true;
    }
}
