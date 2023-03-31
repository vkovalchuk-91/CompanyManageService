package org.company.kovalchuk.repository;

import org.company.kovalchuk.model.EmployeeLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeLevelRepository extends JpaRepository<EmployeeLevel, Long> {
}