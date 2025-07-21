-- V1__init_schema.sql
CREATE TABLE IF NOT EXISTS payment (
    payment_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    sender_account_id BIGINT NOT NULL,
    receiver_account_id BIGINT NOT NULL,
    amount DECIMAL(15, 2) NOT NULL,
    payment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    payment_status VARCHAR(20),
    remarks VARCHAR(255),

    CONSTRAINT fk_sender FOREIGN KEY (sender_account_id)
        REFERENCES smartpay_account.account(account_id)
        ON DELETE CASCADE,

    CONSTRAINT fk_receiver FOREIGN KEY (receiver_account_id)
        REFERENCES smartpay_account.account(account_id)
        ON DELETE CASCADE
);
