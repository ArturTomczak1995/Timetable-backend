package com.scheduler.employees.shift;


import com.scheduler.employees.employee.Employee;
import com.scheduler.employees.employee.EmployeeRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ShiftService {

    private final ShiftRepository shiftRepository;
    private final EmployeeRepository employeeRepository;


    public ShiftService(ShiftRepository shiftRepository, EmployeeRepository employeeRepository) {
        this.shiftRepository = shiftRepository;
        this.employeeRepository = employeeRepository;
    }

    List<Shift> getAllShifts(int employeeId) {
        return new ArrayList<>(shiftRepository.findByEmployeeId(employeeId));
    }

    Shift getShift(int shiftId) {
        return shiftRepository.findById(shiftId).orElse(null);
    }

    Response addShift(Shift shift, int employeeId) {
        if (employeeFinder(employeeId).isPresent()){
            shift.setEmployee(employeeFinder(employeeId).get());
            shiftRepository.save(shift);
            return new Response(true);
        }
        return new  Response(false);
    }

    private Optional<Employee> employeeFinder(int employeeId) {
        return employeeRepository.findById(employeeId);
    }

    Response updateShift(Shift shift) {
        if (shiftFinder(shift.getId()).isPresent()){
            shiftRepository.save(shift);
            return new Response(true);
        }
        return new Response(false);
    }

    Response removeShift(int shiftId){
        if(shiftFinder(shiftId).isPresent()){
            shiftRepository.deleteById(shiftId);
            return new Response(true);
        }
        return new Response(false);
    }

    private Optional<Shift> shiftFinder(int shiftId) {
        return shiftRepository.findById(shiftId);
    }

}
