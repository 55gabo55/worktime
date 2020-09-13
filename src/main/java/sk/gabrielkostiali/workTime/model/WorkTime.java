package sk.gabrielkostiali.workTime.model;

import com.sun.istack.NotNull;

import javax.persistence.*;


@Entity
@Table(name = "work_time")
public class WorkTime  {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private int time_from;

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;*/

    public WorkTime() {
    }

    public WorkTime(Long id, int time_from, Employee employee) {
        this.id = id;
        this.time_from = time_from;
      //  this.employee = employee;
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

 /*   public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }*/

    // private int to;
  //  private Date date;
   // private String type;


   /* @Override
    public String toString() {
        return "WorkTime{" +
                "id=" + id +
                ", time_from=" + time_from +
                ", employee=" + employee.getName() +
                '}';
    }*/
}
