package com.training.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.training.spring.constant.Constants;
import com.training.spring.entity1.Publisher;

@Repository
public class PublisherDAO {
	@Autowired
	@PersistenceContext(unitName = Constants.JPA_UNIT_NAME_1)
	private EntityManager env;

	@SuppressWarnings("unchecked")
	public List<Publisher> listPublishers() {
		String sql = "Select e from " + Publisher.class.getName() + " e ";
		Query query = env.createQuery(sql, Publisher.class);
		return query.getResultList();
	}

	public Publisher findById(Long id) {
		return this.env.find(Publisher.class, id);
	}
}
