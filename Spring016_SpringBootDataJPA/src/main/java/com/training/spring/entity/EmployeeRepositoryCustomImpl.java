package com.training.spring.entity;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepositoryCustomImpl implements EmployeeRepositoryCustom {

	@Autowired
	private EntityManager entityManager;

	@Override
	public Long getMaxEmpId() {
		try {
			String sql = "SELECT coalesce(max(e.id), 0) FROM Employee e";
			Query query = entityManager.createQuery(sql);
			return (Long) query.getSingleResult();
		} catch (NoResultException e) {
			return 0L;
		}
	}

	@Override
	public long updateEmployee(Long empId, String fullName, Date joinDate) {
		Employee e = entityManager.find(Employee.class, empId);
		if (e.equals(null)) {
			return 0;
		}
		e.setFullName(fullName);
		e.setJoinDate(joinDate);
		entityManager.flush();
		return 1;
	}

}
