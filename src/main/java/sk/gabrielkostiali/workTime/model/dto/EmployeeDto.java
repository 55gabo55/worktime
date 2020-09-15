package sk.gabrielkostiali.workTime.model.dto;

import com.sun.istack.NotNull;
import sk.gabrielkostiali.workTime.model.WorkTime;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

public class EmployeeDto {
    private long id;
    private String name;
    private String surname;
    private String role;
    private Set<WorkTimeDto> workTimes = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<WorkTimeDto> getWorkTimes() {
        return workTimes;
    }

    public void setWorkTimes(Set<WorkTimeDto> workTimes) {
        this.workTimes = workTimes;
    }
}
