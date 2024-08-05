CREATE TABLE IF NOT EXISTS reviews (
    id VARCHAR(100) PRIMARY KEY,
    user_id VARCHAR(100) NOT NULL,
    comment TEXT NOT NULL,
    stars INT NOT NULL,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

