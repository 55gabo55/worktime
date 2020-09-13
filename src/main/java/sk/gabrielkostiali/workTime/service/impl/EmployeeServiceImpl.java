package sk.gabrielkostiali.workTime.service.impl;

import org.springframework.stereotype.Service;
import sk.gabrielkostiali.workTime.exceptions.EmployeeNotFoundException;
import sk.gabrielkostiali.workTime.model.Employee;
import sk.gabrielkostiali.workTime.model.WorkTime;
import sk.gabrielkostiali.workTime.repository.EmployeeRepository;
import sk.gabrielkostiali.workTime.repository.WorkTimeRepository;
import sk.gabrielkostiali.workTime.service.api.EmployeeService;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final WorkTimeRepository workTimeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, WorkTimeRepository workTimeRepository) {
        this.employeeRepository = employeeRepository;
        this.workTimeRepository = workTimeRepository;
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
    }

    @Override
    public void addWorkTime(WorkTime workTime, long id) {
        Employee employee = employeeRepository.findById(id).orElse(null);

        if (employee == null) {
            throw new EmployeeNotFoundException(id);
        }

      //  workTime.setEmployee(employee);
        WorkTime workTime1 = workTimeRepository.save(workTime);
        employee.getWorkTimes().add(workTime1);
    }
}
