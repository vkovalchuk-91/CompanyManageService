package org.company.kovalchuk.exception;

public class ProjectNotFoundException extends RuntimeException {
    private final long projectId;

    public ProjectNotFoundException(long projectId) {
        this.projectId = projectId;
    }

    @Override
    public String getMessage() {
        return "Project with id = " + projectId + " not found";
    }
}
