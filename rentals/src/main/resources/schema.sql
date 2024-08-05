CREATE TABLE IF NOT EXISTS rentals (
    id VARCHAR(100) PRIMARY KEY,
    user_id VARCHAR(100) NOT NULL,
    book_id VARCHAR(100) NOT NULL,
    loan_date TIMESTAMP NOT NULL,
    return_date TIMESTAMP NOT NULL,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

