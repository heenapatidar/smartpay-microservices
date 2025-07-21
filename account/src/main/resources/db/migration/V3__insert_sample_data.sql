-- Insert into account (customer_id references above)
INSERT INTO smartpay_account.account (account_id, customer_id, account_number, account_type, balance, created_at)
VALUES
  (101, 1, 'AC101', 'SAVINGS', 10000.00, CURRENT_TIMESTAMP),
  (102, 2, 'AC102', 'SAVINGS', 12000.00, CURRENT_TIMESTAMP);