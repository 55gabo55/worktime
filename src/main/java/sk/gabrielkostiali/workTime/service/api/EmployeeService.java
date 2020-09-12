package sk.gabrielkostiali.workTime.service.api;

import sk.gabrielkostiali.workTime.model.Employee;

import java.util.List;

public interface EmployeeService {

    void addEmployee(Employee employee);

    List<Employee> getEmployees();

    Employee get(long employeeId);
}
