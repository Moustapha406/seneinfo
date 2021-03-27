package com.sene.info.repository;

import java.sql.Connection;

public interface DataSource {
    Connection createConnexion();
}
