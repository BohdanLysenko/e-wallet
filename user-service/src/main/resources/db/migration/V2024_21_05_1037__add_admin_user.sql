INSERT INTO users (id, email, encrypted_password, first_name, last_name, role)
VALUES ((select nextval('user_id_seq')), 'Admin', '$2a$10$yG74T1EYSzmw893tXserUOH9eXJ5K7gDuhpfBrvafM3ACqkEL08wi', 'Admin', 'Admin', 'ROLE_ADMIN');