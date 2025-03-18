ALTER TABLE exam ADD COLUMN login_time BIGINT AFTER student_id;
ALTER TABLE exam ADD COLUMN ip_address VARCHAR(45) AFTER login_time;
ALTER TABLE exam ADD COLUMN device_info VARCHAR(255) AFTER ip_address; 