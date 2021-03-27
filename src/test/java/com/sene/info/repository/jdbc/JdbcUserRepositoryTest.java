package com.sene.info.repository.jdbc;

import com.sene.info.domain.User;
import com.sene.info.repository.DataSource;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class JdbcUserRepositoryTest {
    JdbcUserRepository jdbcUserRepository;

    @Before
    public void setUp() throws SQLException {
        DataSource dataSource=new MysqlDataSource();
        jdbcUserRepository=new JdbcUserRepository(dataSource);

    }

    @Test
    public void getAll() {
    }

    @Test
    public void getUser() {
        User user=jdbcUserRepository.getUser("Diallo1","123");
        assertEquals(true,user);
    }
}