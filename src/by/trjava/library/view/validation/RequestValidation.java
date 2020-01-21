package by.trjava.library.view.validation;

public class RequestValidation{

    public boolean requestValidation(String response){

        if(response.equals("You are singed in") || response.equals("Registration completed!"))
            return true;

        return false;
    }
}
