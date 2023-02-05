package spring.rest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import spring.rest.entity.Employee;
import spring.rest.exception_handler.NegativeIdNumberException;
import spring.rest.exception_handler.NoSuchEmployeeException;

import spring.rest.response.EmployeeCRUDResponse;
import spring.rest.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees(){
        return employeeService.getAllEmployee();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable("id") int id){

        if(id<0)
            throw new NegativeIdNumberException();

        Employee employee = employeeService.getEmployeeById(id);

        if (employee==null)
            throw new NoSuchEmployeeException("Employee with id "+id+" was not found");

        return employee;
    }

    @PostMapping("/employees")
    public EmployeeCRUDResponse addNewEmployee(@RequestBody Employee employee){

        employeeService.saveEmployee(employee);

        return new EmployeeCRUDResponse("Successfully add new employee");
    }

    @PutMapping("/employees")
    public EmployeeCRUDResponse updateEmployee(@RequestBody Employee employee){

        employeeService.saveEmployee(employee);


        return new EmployeeCRUDResponse("Employee was successfully updated");

    }

    @DeleteMapping("/employees/{id}")
    public EmployeeCRUDResponse deleteEmployee(@PathVariable("id") int id){
        Employee employee = employeeService.getEmployeeById(id);

        if (employee==null)
            throw new NoSuchEmployeeException();

        employeeService.deleteEmployee(id);

        return new EmployeeCRUDResponse("Employee with id "+id+" was successfully deleted");

    }

}
