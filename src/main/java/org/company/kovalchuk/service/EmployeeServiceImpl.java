package org.company.kovalchuk.service;

import org.company.kovalchuk.exception.EmployeeNotFoundException;
import org.company.kovalchuk.model.Employee;
import org.springframework.stereotype.Service;
import org.company.kovalchuk.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee getEmployee(int id) {
        return employeeRepository.getEmployeeById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @Override
    public void createEmployee(String firstName, String lastName,
                               int employeeTypeId, int programmerLevelId, int programmerTypeId) {
        employeeRepository.insertEmployee(firstName, lastName, employeeTypeId, programmerLevelId, programmerTypeId);
    }

    @Override
    public void updateEmployee(int id, String firstName, String lastName,
                               int employeeTypeId, int programmerLevelId, int programmerTypeId) {
        employeeRepository.getEmployeeById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
        employeeRepository.updateEmployee(id, firstName, lastName, employeeTypeId, programmerLevelId, programmerTypeId);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.getEmployeeById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
        employeeRepository.deleteEmployeeById(id);
    }
}
