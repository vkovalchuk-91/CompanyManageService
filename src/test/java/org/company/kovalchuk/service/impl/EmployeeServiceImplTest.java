package org.company.kovalchuk.service.impl;

import org.company.kovalchuk.model.Employee;
import org.company.kovalchuk.model.EmployeeLevel;
import org.company.kovalchuk.model.EmployeeType;
import org.company.kovalchuk.model.ProgrammerType;
import org.company.kovalchuk.model.dto.EmployeeWithTeamsDto;
import org.company.kovalchuk.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {
    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;
    @Test
    void getAllEmployees_ReturnsValidListEmployeeWithTeamsDto() {
        List<Employee> employees = getAllEmployeesList_Mocked();
        Mockito.when(employeeRepository.findAll()).thenReturn(employees);

        List<EmployeeWithTeamsDto> employeeWithTeamsDtos = employeeService.getAllEmployees();

        assertNotNull(employeeWithTeamsDtos);
        assertEquals(3, employeeWithTeamsDtos.size());
        assertInstanceOf(EmployeeWithTeamsDto.class, employeeWithTeamsDtos.get(0));
        verifyNoMoreInteractions(employeeRepository);
    }

    @Test
    void getEmployee_EmployeeIdIsExist_ReturnsValidEmployeeWithTeamsDto() {
        Employee employee = getEmployee_Mocked();
        long employeeId = 1;
        Mockito.when(employeeRepository.findById(employeeId)).thenReturn(Optional.of(employee));

        EmployeeWithTeamsDto employeeWithTeamsDto = employeeService.getEmployee(employeeId);

        assertNotNull(employeeWithTeamsDto);
        if (EmployeeWithTeamsDto.class.equals(employeeWithTeamsDto.getClass())) {
            assertEquals("FirstName1", employeeWithTeamsDto.getFirstName());
            assertEquals("LastName1", employeeWithTeamsDto.getLastName());
            assertEquals("Programmer", employeeWithTeamsDto.getEmployeeType());
            assertEquals("Jun", employeeWithTeamsDto.getEmployeeLevel());
            assertEquals("Dev", employeeWithTeamsDto.getProgrammerType());
        } else {
            assertInstanceOf(EmployeeWithTeamsDto.class, employeeWithTeamsDto.getClass());
        }

        verifyNoMoreInteractions(employeeRepository);
    }

    private List<Employee> getAllEmployeesList_Mocked() {
        Employee employee1 = new Employee();
        employee1.setId(1);
        employee1.setFirstName("FirstName1");
        employee1.setLastName("LastName1");
        employee1.setEmployeeType(new EmployeeType());
        employee1.setEmployeeLevel(new EmployeeLevel());
        employee1.setProgrammerType(new ProgrammerType());

        Employee employee2 = new Employee();
        employee2.setId(2);
        employee2.setFirstName("FirstName2");
        employee2.setLastName("LastName2");
        employee2.setEmployeeType(new EmployeeType());
        employee2.setEmployeeLevel(new EmployeeLevel());
        employee2.setProgrammerType(new ProgrammerType());

        Employee employee3 = new Employee();
        employee2.setId(3);
        employee3.setFirstName("FirstName3");
        employee3.setLastName("LastName3");
        employee3.setEmployeeType(new EmployeeType());
        employee3.setEmployeeLevel(new EmployeeLevel());
        employee3.setProgrammerType(new ProgrammerType());

        return List.of(employee1, employee2, employee3);
    }

    private Employee getEmployee_Mocked() {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setFirstName("FirstName1");
        employee.setLastName("LastName1");
        EmployeeType employeeType = new EmployeeType();
        employeeType.setId(2);
        employeeType.setName("Programmer");
        employee.setEmployeeType(employeeType);
        EmployeeLevel employeeLevel = new EmployeeLevel();
        employeeLevel.setId(1);
        employeeLevel.setName("Jun");
        employee.setEmployeeLevel(employeeLevel);
        ProgrammerType programmerType = new ProgrammerType();
        programmerType.setId(1);
        programmerType.setName("Dev");
        employee.setProgrammerType(programmerType);
        return employee;
    }
}