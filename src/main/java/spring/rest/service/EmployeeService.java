package umid.spring.hibernate.service;

import umid.spring.hibernate.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployee();

    public void saveEmployee(Employee employee);

    public Employee getEmployeeById(int id);

    public void deleteEmployee(int id);
}
