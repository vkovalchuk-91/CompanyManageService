package org.company.kovalchuk.exception;

public class ProjectNotFoundException extends RuntimeException {
    private final int projectId;

    public ProjectNotFoundException(int projectId) {
        this.projectId = projectId;
    }

    @Override
    public String getMessage() {
        return "Project with id = " + projectId + " not found";
    }
}
