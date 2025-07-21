-- Insert into payment (sender/receiver IDs are valid account_id)
INSERT INTO smartpay_payment.payment (sender_account_id, receiver_account_id, amount, payment_status, remarks)
VALUES
  (101, 102, 1500.00, 'SUCCESS', 'First transfer'),
  (102, 101, 500.00, 'SUCCESS', 'Refund');