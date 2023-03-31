package org.company.kovalchuk.service.impl;

import org.company.kovalchuk.model.Employee;
import org.company.kovalchuk.model.EmployeeLevel;
import org.company.kovalchuk.model.EmployeeType;
import org.company.kovalchuk.model.ProgrammerType;
import org.company.kovalchuk.model.dto.EmployeeWithProjectsDto;
import org.company.kovalchuk.repository.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceImplTest {
    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Test
    void shouldReturnEmployeeWithProjectsDtoById() {
        long employeeId = 2;

        Employee employee = new Employee();

        EmployeeType employeeType = new EmployeeType();
        employeeType.setId(2);
        employeeType.setName("Programmer");

        EmployeeLevel employeeLevel = new EmployeeLevel();
        employeeLevel.setId(1);
        employeeLevel.setName("Jun");

        ProgrammerType programmerType = new ProgrammerType();
        programmerType.setId(1);
        programmerType.setName("Dev");

        employee.setId(employeeId);
        employee.setFirstName("Ivan");
        employee.setLastName("Ivanov");
        employee.setEmployeeType(employeeType);
        employee.setEmployeeLevel(employeeLevel);
        employee.setProgrammerType(programmerType);
        Mockito.when(employeeRepository.findById(employeeId)).thenReturn(Optional.of(employee));

        EmployeeWithProjectsDto result = employeeService.getEmployee(employeeId);

        Assertions.assertNotNull(result);
        Assertions.assertEquals("Ivan", result.getFirstName());
        Assertions.assertEquals("Ivanov", result.getLastName());
        Assertions.assertEquals("Programmer", result.getEmployeeType());
        Assertions.assertEquals("Jun", result.getEmployeeLevel());
        Assertions.assertEquals("Dev", result.getProgrammerType());
    }
}
