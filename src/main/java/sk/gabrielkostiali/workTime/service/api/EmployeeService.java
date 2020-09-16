package sk.gabrielkostiali.workTime.service.api;

import sk.gabrielkostiali.workTime.model.Employee;
import sk.gabrielkostiali.workTime.model.WorkTime;
import sk.gabrielkostiali.workTime.model.dto.EmployeeDto;
import sk.gabrielkostiali.workTime.model.dto.ViewForm;
import sk.gabrielkostiali.workTime.model.dto.WorkTimeDto;

import java.util.List;
import java.util.Set;

public interface EmployeeService {

    void addEmployee(Employee employee);

    List<EmployeeDto> getEmployees();

    EmployeeDto get(long employeeId);

    void addWorkTime(WorkTime workTime, long id);

    Set<WorkTime> getWorkTimes(ViewForm viewForm);

    Employee getEmployeeView(ViewForm viewForm);
}
