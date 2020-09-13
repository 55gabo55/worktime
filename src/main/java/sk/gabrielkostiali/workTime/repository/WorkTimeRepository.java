package sk.gabrielkostiali.workTime.repository;

import org.springframework.data.repository.CrudRepository;
import sk.gabrielkostiali.workTime.model.WorkTime;

public interface WorkTimeRepository extends CrudRepository<WorkTime, Long> {
}
