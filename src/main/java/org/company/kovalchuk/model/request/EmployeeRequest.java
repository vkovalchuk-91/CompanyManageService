package org.company.kovalchuk.model.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class EmployeeRequest {
    @NotNull
    public String firstName;
    @NotNull
    public String lastName;
    @NotNull
    @Min(1)
    public Integer employeeTypeId;
    @NotNull
    @Min(1)
    public Integer programmerLevelId;
    @NotNull
    @Min(1)
    public Integer programmerTypeId;
}
