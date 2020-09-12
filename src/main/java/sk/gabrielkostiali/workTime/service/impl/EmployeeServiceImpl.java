package sk.gabrielkostiali.workTime.service.impl;

import org.springframework.stereotype.Service;
import sk.gabrielkostiali.workTime.exceptions.EmployeeNotFoundException;
import sk.gabrielkostiali.workTime.model.Employee;
import sk.gabrielkostiali.workTime.repository.EmployeeRepository;
import sk.gabrielkostiali.workTime.service.api.EmployeeService;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee get(long employeeId) {

        return employeeRepository.findById(employeeId).orElse(null);

        /*if (employeeRepository.existsById(employeeId)) {
            return employeeRepository.findById(employeeId).orElse(null);
        } else {
            return null;
        }*/
    }
}
