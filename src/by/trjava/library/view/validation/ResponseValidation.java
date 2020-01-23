package by.trjava.library.view.validation;

public class ResponseValidation{

    public boolean responseValidation(String response){

        if(response.equals("You are singed in") || response.equals("Registration completed!"))
            return true;

        return false;
    }
}
