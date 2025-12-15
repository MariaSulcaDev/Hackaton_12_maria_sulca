CREATE TABLE IF NOT EXISTS students (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    dni VARCHAR(8),
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    promotion VARCHAR(50),
    date TIMESTAMP
);
