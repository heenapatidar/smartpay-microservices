-- V2__add_index.sql
CREATE INDEX idx_sender_account_id ON payment(sender_account_id);
CREATE INDEX idx_receiver_account_id ON payment(receiver_account_id);
CREATE INDEX idx_payment_date ON payment(payment_date);
