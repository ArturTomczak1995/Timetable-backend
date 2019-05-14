package com.scheduler.employees.shift;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins="*")
public class ShiftController {

    private ShiftService shiftService;

    public ShiftController(ShiftService shiftService) {
        this.shiftService = shiftService;
    }


    @RequestMapping(value = "employees/{employeeId}/shifts")
    public List<Shift> getAllShifts(@PathVariable int employeeId) {
        return shiftService.getAllShifts(employeeId);
    }

    @RequestMapping("employees/shifts/{shiftId}")
    public Shift getShift(@PathVariable int shiftId) {
        return shiftService.getShift(shiftId);
    }

    @RequestMapping(value = "employees/{employeeId}/shifts", method = RequestMethod.POST)
    public Response addShift(@RequestBody Shift shift, @PathVariable int employeeId) {
        return shiftService.addShift(shift, employeeId);
    }

    @RequestMapping(value = "employees/shifts", method = RequestMethod.PUT)
    public Response updateShift(@RequestBody Shift shift) {
        return shiftService.updateShift(shift);
    }

    @RequestMapping(value = "employees/shifts/{shiftId}", method = RequestMethod.DELETE)
    public Response removeShift(@PathVariable int shiftId) {
        return shiftService.removeShift(shiftId);
    }

}
