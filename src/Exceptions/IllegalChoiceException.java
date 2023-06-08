package Exceptions;

public class IllegalChoiceException extends Exception{
    @Override
    public String getMessage() {
        return "This choice does not exist\n";
    }
}
