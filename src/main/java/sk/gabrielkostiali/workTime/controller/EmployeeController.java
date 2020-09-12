package sk.gabrielkostiali.workTime.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.gabrielkostiali.workTime.exceptions.EmployeeNotFoundException;
import sk.gabrielkostiali.workTime.model.Employee;
import sk.gabrielkostiali.workTime.service.api.EmployeeService;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {

    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("{id}")
    public Employee get(@PathVariable("id") long id) {

        Employee employee = employeeService.get(id);

        if (employee == null) {
            throw new EmployeeNotFoundException(id);
        }
        return employee;
    }
}
