-- Insert Drones
INSERT INTO DRONE (id, serial_number,model,weight_limit,battery_capacity,state) VALUES (1, 'SE1234','Lightweight',500,50,'IDLE');
INSERT INTO DRONE (id, serial_number,model,weight_limit,battery_capacity,state) VALUES (2, 'SE3244','Lightweight',300,20,'LOADING');

-- Insert Medications
INSERT INTO MEDICATION (id, name,code,weight,image,drone_id) VALUES (1, 'Med One','MED1',100,'https://thumbs.dreamstime.com/b/antibiotics-diagnosis-written-white-piece-paper-syringe-vaccine-drugs-62238514.jpg',1);
INSERT INTO MEDICATION (id, name,code,weight,image,drone_id) VALUES (2, 'Med Two','MED2',100,'https://thumbs.dreamstime.com/b/antibiotics-diagnosis-written-white-piece-paper-syringe-vaccine-drugs-62238514.jpg',1);