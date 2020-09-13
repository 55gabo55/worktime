package sk.gabrielkostiali.workTime.mappers;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import sk.gabrielkostiali.workTime.model.Employee;

@Mapper
public class EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);


}
