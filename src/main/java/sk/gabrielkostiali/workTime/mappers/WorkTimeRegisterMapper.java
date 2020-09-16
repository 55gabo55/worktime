package sk.gabrielkostiali.workTime.mappers;


import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import sk.gabrielkostiali.workTime.model.WorkTime;
import sk.gabrielkostiali.workTime.model.WorkTimeRegister;
import sk.gabrielkostiali.workTime.service.api.EmployeeService;

public class WorkTimeRegisterMapper {

    private final EmployeeService employeeService;

    public WorkTimeRegisterMapper(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public WorkTime toWorkTime(WorkTimeRegister workTimeRegister) {
        WorkTime workTime = new WorkTime();
        workTime.setTime_from(workTimeRegister.getTime_from());
        workTime.setTime_to(workTimeRegister.getTime_to());
        workTime.setLocalDate(workTimeRegister.getLocalDate());

        long employeeId = Long.parseLong(workTimeRegister.getEmployee().split("-", 2)[0]);
        workTime.setEmployee(EmployeeMapper.INSTANCE.employeeDtoToEmployee(employeeService.get(employeeId)));

        return workTime;
    }
}
