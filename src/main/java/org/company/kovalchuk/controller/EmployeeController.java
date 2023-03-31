package org.company.kovalchuk.controller;

import org.company.kovalchuk.model.dto.EmployeeWithProjectsDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.company.kovalchuk.model.request.EmployeeRequest;
import org.company.kovalchuk.service.EmployeeService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<EmployeeWithProjectsDto> getEmployee() {
        return employeeService.getAllEmployees();
    }

    @GetMapping(value = "/{employeeId:\\d+}")
    public EmployeeWithProjectsDto getEmployee(@PathVariable long employeeId) {
        return employeeService.getEmployee(employeeId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createEmployee(@Valid @RequestBody EmployeeRequest request) {
        employeeService.createEmployee(
                request.firstName,
                request.lastName,
                request.employeeTypeId,
                request.employeeLevelId,
                request.programmerTypeId == null ? 0 : request.programmerTypeId
        );
    }

    @PutMapping(value = "/{employeeId:\\d+}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateEmployee(
            @Valid @RequestBody EmployeeRequest request,
            @PathVariable long employeeId
    ) {
        employeeService.updateEmployee(
                employeeId,
                request.firstName,
                request.lastName,
                request.employeeTypeId,
                request.employeeLevelId,
                request.programmerTypeId == null ? 0 : request.programmerTypeId
        );
    }

    @DeleteMapping(value = "/{employeeId:\\d+}")
    public void deleteEmployee(@PathVariable long employeeId) {
        employeeService.deleteEmployee(employeeId);
    }
}