INSERT INTO almedin.plan (precio, id, nombre)
VALUES (5000, 1, '110');

INSERT INTO almedin.profesional (id, apellido, documento, email, especialidad, matricula, nombre)
VALUES (1, 'Pérez', '35545789', 'jorgeperez@email.com', 'Traumatólogo', '12345', 'Jorge');

INSERT INTO almedin.profesional (id, apellido, documento, email, especialidad, matricula, nombre)
VALUES (2, 'Pérez2', '35545782', 'jorgeperez2@email.com', 'Traumatólogo', '12345', 'Jorge2');

INSERT INTO almedin.profesional (id, apellido, documento, email, especialidad, matricula, nombre)
VALUES (3, 'Pérez3', '35545783', 'jorgeperez3@email.com', 'Traumatólogo', '12345', 'Jorge3');

INSERT INTO almedin.turno (cancelado, ocupado, fecha, fechaCreacion, id, profesional_id, socio_id, hash, motivoDeConsulta)
VALUES (0, 0, '2024-06-08 12:00:00.000000', '2024-06-08 11:46:49.054402', 1, 1, 1, '5e2b6b4a-a913-4d85-ac35-6524e7c0fa35', 'Motivo de la consulta del turno 1');

INSERT INTO almedin.turno (cancelado, ocupado, fecha, fechaCreacion, id, profesional_id, socio_id, hash, motivoDeConsulta)
VALUES (0, 0, '2024-06-08 12:15:00.000000', '2024-06-08 11:50:00.000000', 2, 1, null, '6e3c7c5b-b024-5e96-bd46-7635f8e1fb46', 'Motivo de la consulta del turno 2');

INSERT INTO almedin.turno (cancelado, ocupado, fecha, fechaCreacion, id, profesional_id, socio_id, hash, motivoDeConsulta)
VALUES (0, 0, '2024-06-08 12:30:00.000000', '2024-06-08 11:55:00.000000', 3, 2, 1, '7f4d8d6c-c135-6f07-cd57-8746g9f2gc57', 'Motivo de la consulta del turno 3');

INSERT INTO almedin.turno (cancelado, ocupado, fecha, fechaCreacion, id, profesional_id, socio_id, hash, motivoDeConsulta)
VALUES (0, 0, '2024-06-08 12:45:00.000000', '2024-06-08 12:00:00.000000', 1, 2, null, '8g5e9e7d-d246-7g18-de68-9857h0g3hd68', 'Motivo de la consulta del turno 4');



INSERT INTO almedin.socio (autorizado, edad, id, plan_id, apellido, documento, email, nombre)
VALUES (1, 30, 1, 1, 'Benitez', '34512300', 'benitez@email.com', 'Victor');
