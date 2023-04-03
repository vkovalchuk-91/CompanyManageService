package org.company.kovalchuk.controller;

import org.company.kovalchuk.model.dto.EmployeeWithTeamsDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<EmployeeWithTeamsDto>> handleGetAllEmployees() {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(employeeService.getAllEmployees());
    }

    @GetMapping(value = "/{employeeId:\\d+}")
    public ResponseEntity<EmployeeWithTeamsDto> handleGetEmployee(@PathVariable long employeeId) {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(employeeService.getEmployee(employeeId));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void handleCreateEmployee(@Valid @RequestBody EmployeeRequest employeeRequest) {
        employeeService.createEmployee(
                employeeRequest.firstName,
                employeeRequest.lastName,
                employeeRequest.employeeTypeId,
                employeeRequest.employeeLevelId,
                employeeRequest.programmerTypeId == null ? 0 : employeeRequest.programmerTypeId
        );
    }

    @PutMapping(value = "/{employeeId:\\d+}")
    @ResponseStatus(HttpStatus.OK)
    public void handleUpdateEmployee(
            @Valid @RequestBody EmployeeRequest employeeRequest,
            @PathVariable long employeeId
    ) {
        employeeService.updateEmployee(
                employeeId,
                employeeRequest.firstName,
                employeeRequest.lastName,
                employeeRequest.employeeTypeId,
                employeeRequest.employeeLevelId,
                employeeRequest.programmerTypeId == null ? 0 : employeeRequest.programmerTypeId
        );
    }

    @DeleteMapping(value = "/{employeeId:\\d+}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleDeleteEmployee(@PathVariable long employeeId) {
        employeeService.deleteEmployee(employeeId);
    }
}