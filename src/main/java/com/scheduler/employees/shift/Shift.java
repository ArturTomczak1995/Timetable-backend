package com.scheduler.employees.shift;

import com.scheduler.employees.employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Shift {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private java.sql.Timestamp shiftStart;
    private java.sql.Timestamp shiftEnd;
    @ManyToOne
    private Employee employee;


    public Shift() {

    }

    public Shift(Timestamp shiftStart, Timestamp shiftEnd, Employee employee) {
        super();
        this.shiftStart = shiftStart;
        this.shiftEnd = shiftEnd;
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getShiftStart() {
        return shiftStart;
    }

    public void setShiftStart(Timestamp shiftStart) {
        this.shiftStart = shiftStart;
    }

    public Timestamp getShiftEnd() {
        return shiftEnd;
    }

    public void setShiftEnd(Timestamp shiftEnd) {
        this.shiftEnd = shiftEnd;
    }
}
