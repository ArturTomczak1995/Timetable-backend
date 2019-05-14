package com.scheduler.employees.shift;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ShiftRepository extends CrudRepository<Shift, Integer> {
    List<Shift> findByEmployeeId(Integer employeeId);
}
