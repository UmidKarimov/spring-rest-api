package spring.rest.response;

public class EmployeeCRUDResponse {

    private String result;


    public EmployeeCRUDResponse(String result){
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
