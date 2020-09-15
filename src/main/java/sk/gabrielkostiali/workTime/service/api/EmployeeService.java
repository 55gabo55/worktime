package sk.gabrielkostiali.workTime.service.api;

import sk.gabrielkostiali.workTime.model.Employee;
import sk.gabrielkostiali.workTime.model.WorkTime;
import sk.gabrielkostiali.workTime.model.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    void addEmployee(Employee employee);

    List<EmployeeDto> getEmployees();

    EmployeeDto get(long employeeId);

    void addWorkTime(WorkTime workTime, long id);
}
