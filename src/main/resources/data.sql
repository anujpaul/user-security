INSERT INTO user_table (user_id, password)
VALUES ('admin', '$2a$12$.dJKgP6rlQr5Kxh.zpli6ORKqemWaSR2G2BVkODAYW8lKCphAHkjW')
ON CONFLICT (user_id) DO NOTHING;

--This will insert an 'admin' user with the password 'a@123'

