package spring.rest.exception_handler;

public class EmployeeExceptionResponse {

    private String info;

    public EmployeeExceptionResponse(){}

    public String getInfo(){
        return  this.info;
    }

    public void setInfo(String s){
        this.info = s;
    }
}
