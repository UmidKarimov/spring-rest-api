package spring.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.rest.dao.EmployeeDAO;
import spring.rest.entity.Employee;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    @Transactional
    public List<Employee> getAllEmployee() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {

        employeeDAO.saveEmployee(employee);
    }

    @Override
    @Transactional
    public Employee getEmployeeById(int id) {

        return employeeDAO.getEmployeeById(id);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);
    }
}
