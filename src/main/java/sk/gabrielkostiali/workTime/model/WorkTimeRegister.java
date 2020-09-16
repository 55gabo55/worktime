package sk.gabrielkostiali.workTime.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class WorkTimeRegister {
    private Long id;
    private int time_from;
    private int time_to;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate localDate;
    private String employee;

    public WorkTimeRegister(Long id, int time_from, int time_to, LocalDate localDate, String employee) {
        this.id = id;
        this.time_from = time_from;
        this.time_to = time_to;
        this.localDate = localDate;
        this.employee = employee;
    }

    public WorkTimeRegister() {
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

    public int getTime_to() {
        return time_to;
    }

    public void setTime_to(int time_to) {
        this.time_to = time_to;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "WorkTimeRegister{" +
                "id=" + id +
                ", time_from=" + time_from +
                ", time_to=" + time_to +
                ", localDate=" + localDate +
                ", employee='" + employee + '\'' +
                '}';
    }
}
