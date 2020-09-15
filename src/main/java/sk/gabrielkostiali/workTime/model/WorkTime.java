package sk.gabrielkostiali.workTime.model;

import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


@Entity
@Table(name = "work_time")
public class WorkTime  {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private int time_from;
    @NotNull
    private int time_to;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate localDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    public WorkTime() {
    }

    public WorkTime(Long id, int time_from, int time_to, LocalDate localDate, Employee employee) {
        this.id = id;
        this.time_from = time_from;
        this.time_to = time_to;
        this.localDate = localDate;
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTime_from() {
        return time_from;
    }

    public void setTime_from(int time_from) {
        this.time_from = time_from;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getTime_to() {
        return time_to;
    }

    public void setTime_to(int time_to) {
        this.time_to = time_to;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    @Override
    public String toString() {
        return "WorkTime{" +
                "id=" + id +
                ", time_from=" + time_from +
                ", time_to=" + time_to +
                ", localDate=" + localDate +
                ", employee=" + employee +
                '}';
    }
}
