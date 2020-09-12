package sk.gabrielkostiali.workTime.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.gabrielkostiali.workTime.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
