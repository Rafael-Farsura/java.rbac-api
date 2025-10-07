CREATE TABLE IF NOT EXISTS Identity (
    identity_id INTEGER PRIMARY KEY AUTOINCREMENT,
    username VARCHAR(100) NOT NULL UNIQUE,
    full_name VARCHAR(200),
    email VARCHAR(200),
    lifecycle_state VARCHAR(50),
    status VARCHAR(20),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- CREATE TABLE IF NOT EXISTS Role (
--     role_id INTEGER PRIMARY KEY AUTOINCREMENT,
--     role_name VARCHAR(100) NOT NULL UNIQUE,
--     description VARCHAR(255),
--     created_at TIMESTAMP,
--     updated_at TIMESTAMP
-- );

-- CREATE TABLE IF NOT EXISTS Permission (
--     perm_id INTEGER PRIMARY KEY AUTOINCREMENT,
--     perm_name VARCHAR(100) NOT NULL UNIQUE,
--     description VARCHAR(255),
--     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
--     updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
-- );

-- CREATE TABLE IF NOT EXISTS Role_Permission (
--     role_id INTEGER,
--     perm_id INTEGER,
--     PRIMARY KEY (role_id, perm_id),
--     FOREIGN KEY (role_id) REFERENCES Role(role_id),
--     FOREIGN KEY (perm_id) REFERENCES Permission(perm_id)
-- );

-- CREATE TABLE IF NOT EXISTS Identity_Role (
--     identity_id BIGINT,
--     role_id BIGINT,
--     assigned_at TIMESTAMP,
--     PRIMARY KEY (identity_id, role_id),
--     FOREIGN KEY (identity_id) REFERENCES Identity(identity_id),
--     FOREIGN KEY (role_id) REFERENCES Role(role_id)
-- );

-- CREATE TABLE IF NOT EXISTS Identity_Permission (
--     identity_id BIGINT,
--     perm_id BIGINT,
--     granted_at TIMESTAMP,
--     PRIMARY KEY (identity_id, perm_id),
--     FOREIGN KEY (identity_id) REFERENCES Identity(identity_id),
--     FOREIGN KEY (perm_id) REFERENCES Permission(perm_id)
-- );