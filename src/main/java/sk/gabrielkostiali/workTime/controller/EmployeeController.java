package sk.gabrielkostiali.workTime.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sk.gabrielkostiali.workTime.exceptions.EmployeeNotFoundException;
import sk.gabrielkostiali.workTime.model.Employee;
import sk.gabrielkostiali.workTime.model.WorkTime;
import sk.gabrielkostiali.workTime.model.dto.EmployeeDto;
import sk.gabrielkostiali.workTime.service.api.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {

    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("{id}")
    public EmployeeDto get(@PathVariable("id") long id) {
        EmployeeDto employee = employeeService.get(id);

        if (employee == null) {
            throw new EmployeeNotFoundException(id);
        }
        return employee;
    }

    @GetMapping()
    public List<EmployeeDto> getEmployees() {
        return employeeService.getEmployees();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }

    @PostMapping("{id}/addWorkTime")
    public void addWorkTime(@RequestBody WorkTime workTime, @PathVariable("id") long id) {
        employeeService.addWorkTime(workTime, id);
    }

    @RequestMapping("/home")
    public String home() {
        System.out.println("Going home...");
        return "index";
    }

}
