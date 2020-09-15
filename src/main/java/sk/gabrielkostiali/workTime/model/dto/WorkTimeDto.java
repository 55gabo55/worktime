package sk.gabrielkostiali.workTime.model.dto;

import com.sun.istack.NotNull;
import sk.gabrielkostiali.workTime.model.Employee;

import java.time.LocalDate;
import java.util.Date;

public class WorkTimeDto {

    private long id;
    private int time_from;
    private int time_to;
    private LocalDate localDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public WorkTimeDto() {
    }

    public WorkTimeDto(long id, int time_from, int time_to, LocalDate localDate) {
        this.id = id;
        this.time_from = time_from;
        this.time_to = time_to;
        this.localDate = localDate;
    }

    @Override
    public String toString() {
        return "WorkTimeDto{" +
                "id=" + id +
                ", time_from=" + time_from +
                ", time_to=" + time_to +
                ", localDate=" + localDate +
                '}';
    }
}
