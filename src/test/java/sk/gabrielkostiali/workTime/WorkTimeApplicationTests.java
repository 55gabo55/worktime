package sk.gabrielkostiali.workTime;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Assert;
import sk.gabrielkostiali.workTime.model.Employee;
import sk.gabrielkostiali.workTime.repository.EmployeeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
class WorkTimeApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Test
	public void addEmployee() {

		Employee employee = new Employee("jozo", "berky", "java");

		employeeRepository.save(employee);

		Employee employeeFromFB = employeeRepository.findById(1L).get();

		Assert.assertEquals(employee, employeeFromFB);
	}
}
