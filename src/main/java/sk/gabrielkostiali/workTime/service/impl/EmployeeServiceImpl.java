package sk.gabrielkostiali.workTime.service.impl;

import org.springframework.stereotype.Service;
import sk.gabrielkostiali.workTime.exceptions.EmployeeNotFoundException;
import sk.gabrielkostiali.workTime.mappers.EmployeeMapper;
import sk.gabrielkostiali.workTime.model.Employee;
import sk.gabrielkostiali.workTime.model.WorkTime;
import sk.gabrielkostiali.workTime.model.dto.EmployeeDto;
import sk.gabrielkostiali.workTime.model.dto.ViewForm;
import sk.gabrielkostiali.workTime.model.dto.WorkTimeDto;
import sk.gabrielkostiali.workTime.repository.EmployeeRepository;
import sk.gabrielkostiali.workTime.repository.WorkTimeRepository;
import sk.gabrielkostiali.workTime.service.api.EmployeeService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
    public List<EmployeeDto> getEmployees() {
        return employeeRepository.findAll().stream()
                .map(EmployeeMapper.INSTANCE::employeeToDto)
                .collect(Collectors.toList());

    }

    @Override
    public EmployeeDto get(long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);

        if (employee != null) {
            return EmployeeMapper.INSTANCE.employeeToDto(employee);
        }

        return null;
    }

    @Override
    public void addWorkTime(WorkTime workTime, long id) {
        Employee employee = employeeRepository.findById(id).orElse(null);

        if (employee == null) {
            throw new EmployeeNotFoundException(id);
        }

        workTime.setEmployee(employee);
        WorkTime workTime1 = workTimeRepository.save(workTime);
        employee.getWorkTimes().add(workTime1);
    }

    @Override
    public Set<WorkTime> getWorkTimes(ViewForm viewForm) {

        long employeeId = Long.parseLong(viewForm.getS().split("-", 2)[0]);
        Employee employee = employeeRepository.findById(employeeId).orElse(null);

        return employee.getWorkTimes();
    }

    @Override
    public Employee getEmployeeView(ViewForm viewForm) {
        long employeeId = Long.parseLong(viewForm.getS().split("-", 2)[0]);
        return employeeRepository.findById(employeeId).orElse(null);
    }
}
