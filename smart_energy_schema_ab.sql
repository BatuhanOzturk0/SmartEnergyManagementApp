CREATE DATABASE IF NOT EXISTS smart_energy_schema_ab;
USE smart_energy_schema_ab;

CREATE TABLE users (
      
      user_id INT AUTO_INCREMENT PRIMARY KEY,
      name VARCHAR(100) NOT NULL,
      email VARCHAR(100) NOT NULL UNIQUE,
      password VARCHAR(255) NOT NULL
);
SELECT * FROM users;

CREATE TABLE devices (
      
      device_id INT AUTO_INCREMENT PRIMARY KEY,
      device_name VARCHAR(100) NOT NULL,
      device_type VARCHAR(100) NOT NULL,
      user_id INT,
      FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);
SELECT * FROM devices;

CREATE TABLE energy_usage(

      usage_id INT AUTO_INCREMENT PRIMARY KEY,
      device_id INT,
      timestamp DATETIME NOT NULL,
      consumption_kwh DECIMAL(10,2) NOT NULL,
      FOREIGN KEY (device_id) REFERENCES devices(device_id) ON DELETE CASCADE

);

SELECT * FROM energy_usage;

CREATE TABLE billing (
      bill_id INT AUTO_INCREMENT PRIMARY KEY,
      user_id INT,
      total_amount DECIMAL(10,2) NOT NULL,
      bill_date DATE NOT NULL,
      FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);

SELECT * FROM billing;

INSERT INTO users (name, email, password) VALUES
('Batuhan Ozturk','batuhan@example.com','14124124'),
('Munevver Ozturk','munevver@example.com','64646341'),
('Harun Ozturk','harun@example.com','12312477'),
('Vehbi Okumus','vehbi@exmaple.com','53678042'),
('Ismet Eren','ismet@example.com','19283640'),
('Semih Tarcan','semih@example.com','82659172'),
('Mehmet Ali','mehmet@example.com','46837482'),
('Samet Akbas','samet@example.com','15235376'),
('Ekin Kaya','ekin@example.com','37590127'),
('Omer Akin','omer@example.com','48362412');

UPDATE users SET email = 'batuhan@example.com' WHERE user_id = 1;
DELETE FROM users WHERE user_id =10;


INSERT INTO devices (device_name, device_type, user_id) VALUES 
('Smart Meter 1','Electricity',1),
('Smart Thermostat','Heating',1),
('Solar Panel 1','Renewable',2),
('Battery Storage','Storage',3),
('EV Charger','Charging',4),
('Smart Fridge','Appliance',5),
('Wind Turbine 1','Renewable',6),
('Smart Bulb 1','Lighting',7),
('Water Heater','Heating',8),
('Security Camera','Surveillance',9);

UPDATE devices SET device_name ='Smart Meter 2' WHERE device_id = 1;
DELETE FROM devices WHERE device_id = 5;



INSERT INTO energy_usage (device_id, timestamp, consumption_kwh) VALUES
(1,'2025-02-17 09:36:00',3.5),
(1,'2025-02-17 12:12:36',2.1),
(2,'2025-02-18 10:35:30',1.8),
(3,'2025-02-18 14:45:00',4.2),
(4,'2025-02-18 15:10:30',5.3),
(5,'2025-02-19 16:30:15',2.9),
(6,'2025-02-19 04:40:00',3.7),
(7,'2025-02-20 22:20:56',1.3),
(8,'2025-02-20 08:00:50',2.8),
(9,'2025-02-20 20:30:00',4.9);

UPDATE energy_usage SET consumption_kwh = 4.0 WHERE usage_id = 2;
DELETE FROM energy_usage WHERE usage_id = 3;

INSERT INTO billing (user_id, total_amount, bill_date) VALUES
(1,50.75,'2025-03-01'),
(2,60.20,'2025-03-02'),
(3,45.10,'2025-03-03'),
(4,55.90,'2025-03-04'),
(5,70.30,'2025-03-05'),
(6,48.60,'2025-03-06'),
(7,65.80,'2025-03-07'),
(8,52.40,'2025-03-08'),
(9,58.90,'2025-03-09'),
(10,62.10,'2025-03-10');

UPDATE billing SET total_amount = 75.50 WHERE bill_id = 3;
DELETE FROM billing WHERE bill_id = 2;


