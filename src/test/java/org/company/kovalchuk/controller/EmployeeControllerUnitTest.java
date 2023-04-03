package org.company.kovalchuk.controller;

import org.company.kovalchuk.model.dto.EmployeeWithTeamsDto;
import org.company.kovalchuk.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeControllerUnitTest {
    @Mock
    private EmployeeServiceImpl employeeService;

    @InjectMocks
    private EmployeeController employeeController;

    @Test
    void handleGetAllEmployees_ReturnsValidResponseEntity() {
        List<EmployeeWithTeamsDto> employees = getAllEmployeesWithTeamsDtos_Mocked();
        doReturn(employees).when(employeeService).getAllEmployees();

        ResponseEntity<List<EmployeeWithTeamsDto>> responseEntity = employeeController.handleGetAllEmployees();

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON, responseEntity.getHeaders().getContentType());
        assertEquals(employees, responseEntity.getBody());
    }

    @Test
    void handleGetEmployee_EmployeeIdIsExist_ReturnsValidResponseEntity() {
        EmployeeWithTeamsDto employee = getEmployeeWithTeamsDtos_Mocked();
        doReturn(employee).when(employeeService).getEmployee(2);

        ResponseEntity<EmployeeWithTeamsDto> responseEntity = employeeController.handleGetEmployee(2);

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON, responseEntity.getHeaders().getContentType());
        assertEquals(employee, responseEntity.getBody());
    }

    private static List<EmployeeWithTeamsDto> getAllEmployeesWithTeamsDtos_Mocked() {
        EmployeeWithTeamsDto employee1 = new EmployeeWithTeamsDto();
        employee1.setFirstName("FirstName1");
        employee1.setLastName("LastName1");
        employee1.setEmployeeType("Programmer");
        employee1.setEmployeeLevel("Mid");
        employee1.setProgrammerType("QA");

        EmployeeWithTeamsDto employee2 = new EmployeeWithTeamsDto();
        employee2.setFirstName("FirstName2");
        employee2.setLastName("LastName2");
        employee2.setEmployeeType("Manager");
        employee2.setEmployeeLevel("Jun");

        EmployeeWithTeamsDto employee3 = new EmployeeWithTeamsDto();
        employee3.setFirstName("FirstName3");
        employee3.setLastName("LastName3");
        employee3.setEmployeeType("Programmer");
        employee3.setEmployeeLevel("Senior");
        employee3.setProgrammerType("Dev");

        return List.of(employee1, employee2, employee3);
    }

    private static EmployeeWithTeamsDto getEmployeeWithTeamsDtos_Mocked() {
        EmployeeWithTeamsDto employee1 = new EmployeeWithTeamsDto();
        employee1.setFirstName("FirstName1");
        employee1.setLastName("LastName1");
        employee1.setEmployeeType("Programmer");
        employee1.setEmployeeLevel("Mid");
        employee1.setProgrammerType("QA");

        return employee1;
    }
}