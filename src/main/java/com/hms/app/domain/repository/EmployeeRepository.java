package com.hms.app.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hms.app.domain.models.Employee;
import com.hms.app.domain.models.User;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{
	Optional<Employee> findEmployeeByEmail(String userId);
}
