-- Database initialization script for DigiBank
-- Run this script as a PostgreSQL superuser to create the database and user

-- Create the database
CREATE DATABASE digibank_db;

-- Create the application user
CREATE USER digibank_user WITH PASSWORD 'digibank_pwd';

-- Grant all privileges on the database to the user
GRANT ALL PRIVILEGES ON DATABASE digibank_db TO digibank_user;

-- Connect to the database to grant schema privileges
\c digibank_db;

-- Grant privileges on the public schema
GRANT ALL ON SCHEMA public TO digibank_user;

-- Note: When running with JNDI DataSource on WildFly, 
-- configure the datasource in standalone.xml with:
--   jndi-name: java:/jdbc/DigiBankDS
--   connection-url: jdbc:postgresql://localhost:5432/digibank_db
--   user-name: digibank_user
--   password: digibank_pwd
