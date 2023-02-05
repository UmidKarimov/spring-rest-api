package spring.rest.exception_handler;

public class NegativeIdNumberException extends RuntimeException{

    public NegativeIdNumberException(String text){
        super(text);
    }

    public NegativeIdNumberException(){
        super("Employee's id have to be greater than 0!");
    }
}
