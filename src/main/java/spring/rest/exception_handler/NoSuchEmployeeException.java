package spring.rest.exception_handler;

public class NoSuchEmployeeException extends RuntimeException {

    public NoSuchEmployeeException(String messageText){
        super(messageText);
    }

    public NoSuchEmployeeException(){
        super("Can't find employee with requested Id");
    }
}
