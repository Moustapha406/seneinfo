package com.sene.info.repository.jdbc;

import com.sene.info.domain.Post;
import com.sene.info.repository.DataSource;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class jdbcPostRepositoryTest {
    jdbcPostRepository jdbcPostRepository;
    @Before
    public void setUp() throws SQLException {
        DataSource dataSource =new MysqlDataSource();
        jdbcPostRepository=new jdbcPostRepository(dataSource);
    }

    @Test
    public void getAll() {
        Post[] posts=jdbcPostRepository.getAll();
        assertEquals(3,posts.length);
    }
}