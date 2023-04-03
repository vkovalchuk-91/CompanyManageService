package org.company.kovalchuk.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc(printOnlyOnFailure = false)
class EmployeeToTeamToProjectControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void handleGetEmployeesInTeam_EmployeeIdIsNotExist_ReturnsValidResponseEntity() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = get("/teams/9999/employees");

        mockMvc.perform(requestBuilder)
                .andExpectAll(
                        status().isOk(),
                        content().string("Team with id = 9999 not found")
                );
    }

    @Test
    void handleGetEmployeeTeams_EmployeeIdIsNotExist_ReturnsValidResponseEntity() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = get("/employees/9999/teams");

        mockMvc.perform(requestBuilder)
                .andExpectAll(
                        status().isOk(),
                        content().string("Employee with id = 9999 not found")
                );
    }

    @Test
    void handleGetTeamsInProject_EmployeeIdIsNotExist_ReturnsValidResponseEntity() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = get("/projects/9999/teams");

        mockMvc.perform(requestBuilder)
                .andExpectAll(
                        status().isOk(),
                        content().string("Project with id = 9999 not found")
                );
    }

    @Test
    void handleGetTeamProjects_EmployeeIdIsNotExist_ReturnsValidResponseEntity() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = get("/teams/9999/projects");

        mockMvc.perform(requestBuilder)
                .andExpectAll(
                        status().isOk(),
                        content().string("Team with id = 9999 not found")
                );
    }
}