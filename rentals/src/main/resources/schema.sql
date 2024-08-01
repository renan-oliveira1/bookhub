CREATE TABLE IF NOT EXISTS rentals (
    id VARCHAR(100) PRIMARY KEY,
    id_user VARCHAR(100) NOT NULL,
    id_book VARCHAR(100) NOT NULL,
    loan_date TIMESTAMP NOT NULL,
    return_date TIMESTAMP NOT NULL,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

