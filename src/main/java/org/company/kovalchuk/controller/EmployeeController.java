package org.company.kovalchuk.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.company.kovalchuk.model.Employee;
import org.company.kovalchuk.model.request.EmployeeRequest;
import org.company.kovalchuk.service.EmployeeService;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/{employeeId:\\d+}")
    public Employee getEmployee(@PathVariable int employeeId) {
        return employeeService.getEmployee(employeeId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createEmployee(@Valid @RequestBody EmployeeRequest request) {
        employeeService.createEmployee(
                request.firstName,
                request.lastName,
                request.employeeTypeId,
                request.programmerLevelId,
                request.programmerTypeId
        );
    }

    @PutMapping(value = "/{employeeId:\\d+}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateEmployee(
            @Valid @RequestBody EmployeeRequest request,
            @PathVariable int employeeId
    ) {
        employeeService.updateEmployee(
                employeeId,
                request.firstName,
                request.lastName,
                request.employeeTypeId,
                request.programmerLevelId,
                request.programmerTypeId
        );
    }

    @DeleteMapping(value = "/{employeeId:\\d+}")
    public void deleteEmployee(@PathVariable int employeeId) {
        employeeService.deleteEmployee(employeeId);
    }
}