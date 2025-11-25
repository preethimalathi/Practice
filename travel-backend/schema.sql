
-- MySQL schema (basic). You can also let JPA create tables (spring.jpa.hibernate.ddl-auto=update).
CREATE DATABASE IF NOT EXISTS travel_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE travel_db;

CREATE TABLE IF NOT EXISTS users (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(255) UNIQUE NOT NULL,
  password VARCHAR(255) NOT NULL,
  role VARCHAR(50) NOT NULL
);

-- bookings table will be created by JPA, but sample:
CREATE TABLE IF NOT EXISTS bookings (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  booking_ref VARCHAR(255),
  destination_name VARCHAR(255),
  customer_name VARCHAR(255),
  customer_email VARCHAR(255),
  start_date DATE,
  end_date DATE,
  travelers INT,
  price INT,
  created_at DATETIME
);
