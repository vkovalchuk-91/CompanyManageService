package org.company.kovalchuk.service.impl;

import org.company.kovalchuk.exception.EmployeeNotFoundException;
import org.company.kovalchuk.exception.ProjectNotFoundException;
import org.company.kovalchuk.model.Employee;
import org.company.kovalchuk.model.dto.EmployeeWithTeamsDto;
import org.company.kovalchuk.repository.EmployeeLevelRepository;
import org.company.kovalchuk.repository.EmployeeTypeRepository;
import org.company.kovalchuk.repository.ProgrammerTypeRepository;
import org.company.kovalchuk.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.company.kovalchuk.repository.EmployeeRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeTypeRepository employeeTypeRepository;
    private final EmployeeLevelRepository employeeLevelRepository;
    private final ProgrammerTypeRepository programmerTypeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository,
                               EmployeeTypeRepository employeeTypeRepository,
                               EmployeeLevelRepository employeeLevelRepository,
                               ProgrammerTypeRepository programmerTypeRepository) {
        this.employeeRepository = employeeRepository;
        this.employeeTypeRepository = employeeTypeRepository;
        this.employeeLevelRepository = employeeLevelRepository;
        this.programmerTypeRepository = programmerTypeRepository;
    }

    @Override
    public List<EmployeeWithTeamsDto> getAllEmployees() {
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList.stream()
                .map(EmployeeWithTeamsDto::fromModel)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeWithTeamsDto getEmployee(long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException(id));
        return EmployeeWithTeamsDto.fromModel(employee);
    }

    @Override
    public void createEmployee(String firstName, String lastName,
                               long employeeTypeId, long employeeLevelId, long programmerTypeId) {
        Employee employee = new Employee();
        saveEmployeeToDB(firstName, lastName, employeeTypeId, employeeLevelId, programmerTypeId, employee);
    }

    @Override
    public void updateEmployee(long id, String firstName, String lastName,
                               long employeeTypeId, long employeeLevelId, long programmerTypeId) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
        saveEmployeeToDB(firstName, lastName, employeeTypeId, employeeLevelId, programmerTypeId, employee);
    }

    @Override
    public void deleteEmployee(long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
        employeeRepository.delete(employee);
    }

    private void saveEmployeeToDB(String firstName, String lastName,
                                  long employeeTypeId, long employeeLevelId, long programmerTypeId, Employee employee) {
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setEmployeeType(employeeTypeRepository.getById(employeeTypeId));
        employee.setEmployeeLevel(employeeLevelRepository.getById(employeeLevelId));
        if (programmerTypeId != 0) {
            employee.setProgrammerType(programmerTypeRepository.getById(programmerTypeId));
        } else {
            employee.setProgrammerType(null);
        }
        employeeRepository.save(employee);
    }
}