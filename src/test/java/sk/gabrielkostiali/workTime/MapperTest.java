package sk.gabrielkostiali.workTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sk.gabrielkostiali.workTime.mappers.EmployeeMapper;
import sk.gabrielkostiali.workTime.mappers.WorkTimeMapper;
import sk.gabrielkostiali.workTime.model.Employee;
import sk.gabrielkostiali.workTime.model.WorkTime;
import sk.gabrielkostiali.workTime.model.dto.EmployeeDto;
import sk.gabrielkostiali.workTime.model.dto.WorkTimeDto;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.transaction.Transactional;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MapperTest {


    @Test
    public void employeeToDto() {
        Employee employee = new Employee("Gabo", "Kostialik", "java");

        employee.setId(1L);

        EmployeeDto employeeDto = EmployeeMapper.INSTANCE.employeeToDto(employee);

        System.out.println(employeeDto.getName());

        assertEquals(employee.getId(), employeeDto.getId());
        assertEquals(employee.getName(), employeeDto.getName());
    }

    @Test
    public void workTimeToDto() {
        Employee employee = new Employee("Gabo", "Kostialik", "java");

        employee.setId(1L);

        WorkTime workTime = new WorkTime(1L, 8, 16, LocalDate.now(), employee);

        System.out.println(workTime);

        WorkTimeDto workTimeDto = WorkTimeMapper.INSTANCE.workTimeToDTO(workTime);

        System.out.println(workTimeDto);

        assertEquals(workTime.getId(), workTimeDto.getId());
        assertEquals(workTime.getTime_from(), workTimeDto.getTime_from());

    }
}
