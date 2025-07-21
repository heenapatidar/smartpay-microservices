-- Insert into customer
INSERT INTO smartpay_customer.customer (id, first_name, last_name, email, phone, created_at)
VALUES
  (1, 'Heena', 'Patidar', 'heena@example.com', '1234567890', CURRENT_TIMESTAMP),
  (2, 'Aman', 'Verma', 'aman@example.com', '9876543210', CURRENT_TIMESTAMP);