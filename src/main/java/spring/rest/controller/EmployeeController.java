package spring.rest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.rest.entity.Employee;
import spring.rest.exception_handler.NegativeIdNumberException;
import spring.rest.exception_handler.NoSuchEmployeeException;

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
            throw new NoSuchEmployeeException();

        return employee;
    }

}
