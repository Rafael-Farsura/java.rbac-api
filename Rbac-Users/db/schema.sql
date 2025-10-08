-- opcional: script de inicialização (executado automaticamente se colocado em docker/initdb)
CREATE TABLE IF NOT EXISTS permissions (
  id serial PRIMARY KEY,
  name varchar(100) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS roles (
  id serial PRIMARY KEY,
  name varchar(100) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS role_permissions (
  role_id integer NOT NULL,
  permission_id integer NOT NULL,
  CONSTRAINT fk_role FOREIGN KEY(role_id) REFERENCES roles(id) ON DELETE CASCADE,
  CONSTRAINT fk_permission FOREIGN KEY(permission_id) REFERENCES permissions(id) ON DELETE CASCADE,
  CONSTRAINT pk_rp PRIMARY KEY(role_id, permission_id)
);

CREATE TABLE IF NOT EXISTS users (
  id serial PRIMARY KEY,
  username varchar(100) NOT NULL UNIQUE,
  password varchar(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS user_roles (
  user_id integer NOT NULL,
  role_id integer NOT NULL,
  CONSTRAINT fk_user FOREIGN KEY(user_id) REFERENCES users(id) ON DELETE CASCADE,
  CONSTRAINT fk_role2 FOREIGN KEY(role_id) REFERENCES roles(id) ON DELETE CASCADE,
  CONSTRAINT pk_ur PRIMARY KEY(user_id, role_id)
);
