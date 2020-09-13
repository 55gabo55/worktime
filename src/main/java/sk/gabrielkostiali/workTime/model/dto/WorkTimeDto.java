package sk.gabrielkostiali.workTime.model.dto;

import com.sun.istack.NotNull;

public class WorkTimeDto {

    private long id;

    @NotNull
    private int time_from;

    @NotNull
    private int to;

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

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }
}
