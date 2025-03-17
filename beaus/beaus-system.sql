-- Description: SQL script to create the database schema for the Beaus System.
-- Permission Table
CREATE TABLE permission (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) UNIQUE NOT NULL,
    created_date TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(255) NOT NULL DEFAULT 'system',
    modified_date TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
    modified_by VARCHAR(255) NOT NULL DEFAULT 'system',
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    version INT NOT NULL DEFAULT 1,
    deleted_date TIMESTAMPTZ,
    deleted_by VARCHAR(255),
    reactivated_date TIMESTAMPTZ,
    reactivated_by VARCHAR(255),
    data_source VARCHAR(255) DEFAULT 'unknown'
);

-- Module Table
CREATE TABLE module (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) UNIQUE NOT NULL,
    created_date TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(255) NOT NULL DEFAULT 'system',
    modified_date TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
    modified_by VARCHAR(255) NOT NULL DEFAULT 'system',
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    version INT NOT NULL DEFAULT 1,
    deleted_date TIMESTAMPTZ,
    deleted_by VARCHAR(255),
    reactivated_date TIMESTAMPTZ,
    reactivated_by VARCHAR(255),
    data_source VARCHAR(255) DEFAULT 'unknown'
);

-- Role Table
CREATE TABLE role (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) UNIQUE NOT NULL,
    created_date TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(255) NOT NULL DEFAULT 'system',
    modified_date TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
    modified_by VARCHAR(255) NOT NULL DEFAULT 'system',
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    version INT NOT NULL DEFAULT 1,
    deleted_date TIMESTAMPTZ,
    deleted_by VARCHAR(255),
    reactivated_date TIMESTAMPTZ,
    reactivated_by VARCHAR(255),
    data_source VARCHAR(255) DEFAULT 'unknown'
);

-- Role-Permissions Table
-- Maps a role, a permission, and a module together.
CREATE TABLE role_permissions (
    role_id INT REFERENCES role(id) ON DELETE CASCADE,
    permission_id INT REFERENCES permission(id) ON DELETE CASCADE,
    module_id INT REFERENCES module(id) ON DELETE CASCADE,
    created_date TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(255) NOT NULL DEFAULT 'system',
    modified_date TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
    modified_by VARCHAR(255) NOT NULL DEFAULT 'system',
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    version INT NOT NULL DEFAULT 1,
    deleted_date TIMESTAMPTZ,
    deleted_by VARCHAR(255),
    reactivated_date TIMESTAMPTZ,
    reactivated_by VARCHAR(255),
    data_source VARCHAR(255) DEFAULT 'unknown',
    PRIMARY KEY (role_id, permission_id, module_id)
);

-- Users Table
-- Contains essential login details.
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255) UNIQUE NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    last_login_date TIMESTAMPTZ,
    created_date TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(255) NOT NULL DEFAULT 'system',
    modified_date TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
    modified_by VARCHAR(255) NOT NULL DEFAULT 'system',
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    version INT NOT NULL DEFAULT 1,
    deleted_date TIMESTAMPTZ,
    deleted_by VARCHAR(255),
    reactivated_date TIMESTAMPTZ,
    reactivated_by VARCHAR(255),
    data_source VARCHAR(255) DEFAULT 'unknown'
);

-- User-Roles Table
-- Maps users to one or more roles.
CREATE TABLE user_roles (
    user_id INT REFERENCES users(id) ON DELETE CASCADE,
    role_id INT REFERENCES role(id) ON DELETE CASCADE,
    created_date TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(255) NOT NULL DEFAULT 'system',
    modified_date TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
    modified_by VARCHAR(255) NOT NULL DEFAULT 'system',
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    version INT NOT NULL DEFAULT 1,
    deleted_date TIMESTAMPTZ,
    deleted_by VARCHAR(255),
    reactivated_date TIMESTAMPTZ,
    reactivated_by VARCHAR(255),
    data_source VARCHAR(255) DEFAULT 'unknown',
    PRIMARY KEY (user_id, role_id)
);

-- -------------------------------
-- 2. Insert Initial Data
-- -------------------------------

-- Insert Base Permissions
INSERT INTO permission (name) VALUES 
    ('READ'), 
    ('MODIFY'), 
    ('CREATE'), 
    ('DELETE');

-- Insert Core Modules
INSERT INTO module (name) VALUES 
    ('Product'), 
    ('Order'), 
    ('Order History'), 
    ('Profile'), 
    ('Report'), 
    ('Payment'), 
    ('User'), 
    ('Transaction'), 
    ('Refund History'), 
    ('Tax Report');

-- Insert Roles
INSERT INTO role (name) VALUES 
    ('Administrator'), 
    ('Supervisor'), 
    ('Financial Manager'), 
    ('Seller'), 
    ('User');

-- Map Roles to Permissions per Module
-- Example mappings:
-- Administrator: full permissions on the 'User' module.
INSERT INTO role_permissions (role_id, permission_id, module_id) VALUES 
    ((SELECT id FROM role WHERE name = 'Administrator'),
     (SELECT id FROM permission WHERE name = 'READ'),
     (SELECT id FROM module WHERE name = 'User')),
    ((SELECT id FROM role WHERE name = 'Administrator'),
     (SELECT id FROM permission WHERE name = 'MODIFY'),
     (SELECT id FROM module WHERE name = 'User')),
    ((SELECT id FROM role WHERE name = 'Administrator'),
     (SELECT id FROM permission WHERE name = 'CREATE'),
     (SELECT id FROM module WHERE name = 'User')),
    ((SELECT id FROM role WHERE name = 'Administrator'),
     (SELECT id FROM permission WHERE name = 'DELETE'),
     (SELECT id FROM module WHERE name = 'User'));

-- Supervisor: READ and MODIFY on the 'Order' module.
INSERT INTO role_permissions (role_id, permission_id, module_id) VALUES 
    ((SELECT id FROM role WHERE name = 'Supervisor'),
     (SELECT id FROM permission WHERE name = 'READ'),
     (SELECT id FROM module WHERE name = 'Order')),
    ((SELECT id FROM role WHERE name = 'Supervisor'),
     (SELECT id FROM permission WHERE name = 'MODIFY'),
     (SELECT id FROM module WHERE name = 'Order'));

-- Financial Manager: READ, MODIFY, and CREATE on the 'Payment' module.
INSERT INTO role_permissions (role_id, permission_id, module_id) VALUES 
    ((SELECT id FROM role WHERE name = 'Financial Manager'),
     (SELECT id FROM permission WHERE name = 'READ'),
     (SELECT id FROM module WHERE name = 'Payment')),
    ((SELECT id FROM role WHERE name = 'Financial Manager'),
     (SELECT id FROM permission WHERE name = 'MODIFY'),
     (SELECT id FROM module WHERE name = 'Payment')),
    ((SELECT id FROM role WHERE name = 'Financial Manager'),
     (SELECT id FROM permission WHERE name = 'CREATE'),
     (SELECT id FROM module WHERE name = 'Payment'));

-- Seller: READ, MODIFY, and CREATE on the 'Product' module.
INSERT INTO role_permissions (role_id, permission_id, module_id) VALUES 
    ((SELECT id FROM role WHERE name = 'Seller'),
     (SELECT id FROM permission WHERE name = 'READ'),
     (SELECT id FROM module WHERE name = 'Product')),
    ((SELECT id FROM role WHERE name = 'Seller'),
     (SELECT id FROM permission WHERE name = 'MODIFY'),
     (SELECT id FROM module WHERE name = 'Product')),
    ((SELECT id FROM role WHERE name = 'Seller'),
     (SELECT id FROM permission WHERE name = 'CREATE'),
     (SELECT id FROM module WHERE name = 'Product'));

-- User: READ on the 'Profile' module.
INSERT INTO role_permissions (role_id, permission_id, module_id) VALUES 
    ((SELECT id FROM role WHERE name = 'User'),
     (SELECT id FROM permission WHERE name = 'READ'),
     (SELECT id FROM module WHERE name = 'Profile'));

