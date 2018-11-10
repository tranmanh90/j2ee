package com.training.spring.entity;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	public Employee findByEmpNo(String empNo);

	List<Employee> findByFullNameLike(String fullName);

	List<Employee> findByJoinDateGreaterThan(Date joinDate);

	@Query("SELECT coalesce(max(e.id), 0) FROM Employee e")
	Long getMaxId();
}
