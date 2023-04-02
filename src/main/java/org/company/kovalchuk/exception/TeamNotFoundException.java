package org.company.kovalchuk.exception;

public class TeamNotFoundException extends RuntimeException {
    private final long teamId;

    public TeamNotFoundException(long teamId) {
        this.teamId = teamId;
    }

    @Override
    public String getMessage() {
        return "Team with id = " + teamId + " not found";
    }
}
