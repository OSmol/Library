package by.trjava.library.view.validation;

public class StopValidation {

    public boolean responseValidation(String response){

        if(response.equals(" Good bye!"))
            return true;

        return false;
    }
}
