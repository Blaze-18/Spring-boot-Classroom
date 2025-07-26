package com.classroom.config;

import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Component
public class DatabaseVerifier implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(DatabaseVerifier.class);

    private final DataSource dataSource;
    private final EntityManager entityManager;

    public DatabaseVerifier(DataSource dataSource, EntityManager entityManager) {
        this.dataSource = dataSource;
        this.entityManager = entityManager;
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            checkDatabaseConnection();
            checkDatabaseVersion();
        } catch (Exception e) {
            log.error("\n\n---------------Database connection failed -------------------\n\n", e);
            throw e;
        }
    }

    private void checkDatabaseConnection() throws SQLException {
        try (Connection conn = dataSource.getConnection()) {
            log.info("\n\n--------------Database connection established to: {}-----------------\n\n", conn.getMetaData().getURL());
        }
    }

    private void checkDatabaseVersion() {
        String version = (String) entityManager
                .createNativeQuery("SELECT version()")
                .getSingleResult();
        log.info("🧠 PostgreSQL version: {}", version);
    }
}

