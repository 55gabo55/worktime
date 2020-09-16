package sk.gabrielkostiali.workTime.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import sk.gabrielkostiali.workTime.model.Employee;
import sk.gabrielkostiali.workTime.model.dto.EmployeeDto;

@Mapper
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    EmployeeDto employeeToDto(Employee employee);
    Employee employeeDtoToEmployee(EmployeeDto employeeDto);
}
