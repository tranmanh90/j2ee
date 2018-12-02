package com.book.store.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.book.store.mapper.AuthorMapper;
import com.book.store.model.Author;

@Repository
public class AuthorDAO extends JdbcDaoSupport {
	private static final String BASE_SQL = "SELECT AU.AUTHOR_ID, AU.AUTHOR_NAME, AU.AUTHOR_ABOUT FROM AUTHORS AU";
	
	@Autowired
	public AuthorDAO(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	// Read (GET method)
	public Author getAuthor(String authorId) {
		String sql = BASE_SQL + " WHERE AU.AUTHOR_ID = ?";
		Object[] params = new Object[] { authorId };
		AuthorMapper mapper = new AuthorMapper();
		try {
			Author author = this.getJdbcTemplate().queryForObject(sql, params, mapper);
			return author;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public List<Author> getAuthors() {
		String sql = BASE_SQL;
		Object[] params = new Object[] {};
		AuthorMapper mapper = new AuthorMapper();
		List<Author> listAuthors = this.getJdbcTemplate().query(sql, params, mapper);
		return listAuthors;
	}

	// Update (PUT method)
	public List<Author> updateAuthor(Author author) {
		String sqlupdate = "UPDATE AUTHORS SET AUTHOR_ID = '" 	+ author.getAuthorId() 
							 + "', AUTHOR_NAME = '" 			+ author.getAuthorName() 
							 + "', AUTHOR_ABOUT = '" 			+ author.getAuthorAbout() 
							 + "' WHERE AUTHOR_ID = '" 			+ author.getAuthorId() 
							 + "'";
		this.getJdbcTemplate().update(sqlupdate);

		// Return results
		String sql = BASE_SQL;
		Object[] params = new Object[] {};
		AuthorMapper mapper = new AuthorMapper();
		List<Author> listAuthors = this.getJdbcTemplate().query(sql, params, mapper);
		return listAuthors;
	}

	// Create (POST method)
	public List<Author> createAuthor(Author author) {
		String sqlcreate = "INSERT INTO AUTHORS VALUES('" 
															+ author.getAuthorId() + "','" 
															+ author.getAuthorName() + "','" 
															+ author.getAuthorAbout() + "')";
		this.getJdbcTemplate().update(sqlcreate);

		// Return results
		String sql = BASE_SQL;
		Object[] params = new Object[] {};
		AuthorMapper mapper = new AuthorMapper();
		List<Author> listAuthors = this.getJdbcTemplate().query(sql, params, mapper);
		return listAuthors;
	}

	// Delete (DELETE method)
	public List<Author> deleteAuthor(String authorId) {
		String sqldlt = "DELETE FROM AUTHORS WHERE AUTHOR_ID = '" + authorId + "'";
		this.getJdbcTemplate().update(sqldlt);

		// Return results
		String sql = BASE_SQL;
		Object[] params = new Object[] {};
		AuthorMapper mapper = new AuthorMapper();
		List<Author> listAuthors = this.getJdbcTemplate().query(sql, params, mapper);
		return listAuthors;
	}
}
