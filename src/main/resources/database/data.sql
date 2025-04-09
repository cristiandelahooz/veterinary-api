INSERT INTO users (name, email, username, password, phone, role)
VALUES ('Cristian', 'admin@example.com', 'admin', 'admin', '123456789', 'CLIENT');

INSERT INTO client_details (user_id)
VALUES ((SELECT id FROM users WHERE username = 'admin'));
