package org.company.kovalchuk.exception;

public class EmployeeNotFoundException extends RuntimeException {
    private final long employeeId;

    public EmployeeNotFoundException(long employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String getMessage() {
        return "Employee with id = " + employeeId + " not found";
    }
}
