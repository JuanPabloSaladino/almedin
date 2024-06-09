-- Insertar en la tabla Plan
INSERT INTO almedin.plan (precio, id, nombre) VALUES (5000, 1, '110');

-- Insertar en la tabla Profesional
INSERT INTO almedin.profesional (id, apellido, documento, email, especialidad, matricula, nombre)
VALUES (1, 'Pérez', '35545789', 'jorgeperez@email.com', 'Traumatólogo', '12345', 'Jorge');

INSERT INTO almedin.profesional (id, apellido, documento, email, especialidad, matricula, nombre)
VALUES (2, 'Sanchez', '45698712', 'RickSanchez@email.com', 'Traumatólogo', '54321', 'Rick');

INSERT INTO almedin.profesional (id, apellido, documento, email, especialidad, matricula, nombre)
VALUES (3, 'Potter', '19852647', 'HarryPotter3@email.com', 'Traumatólogo', '98745', 'Harry');

-- Insertar en la tabla Socio
INSERT INTO almedin.socio (autorizado, edad, id, plan_id, apellido, documento, email, nombre)
VALUES (1, 30, 1, 1, 'Benitez', '34512300', 'benitez@email.com', 'Victor');

INSERT INTO almedin.socio (autorizado, edad, id, plan_id, apellido, documento, email, nombre)
VALUES (1, 22, 2, 1, 'Juarez', '87654321', 'juarez@email.com', 'manuel');

INSERT INTO almedin.socio (autorizado, edad, id, plan_id, apellido, documento, email, nombre)
VALUES (1, 46, 3, 1, 'Picapiedra', '12345678', 'picapiedra@email.com', 'Pedro');

-- Insertar en la tabla Turno
INSERT INTO almedin.turno (cancelado, ocupado, fechaInicio, fechaCreacion, id, profesional_id, socio_id, hash, motivoDeConsulta)
VALUES (0, 1, '2024-06-08 12:00:00.000000', '2024-06-08 11:46:49.054402', 1, 1, 1, '5e2b6b4a-a913-4d85-ac35', 'Motivo de la consulta del turno 1');

INSERT INTO almedin.turno (cancelado, ocupado, fechaInicio, fechaCreacion, id, profesional_id, socio_id, hash, motivoDeConsulta)
VALUES (0, 1, '2024-06-08 12:15:00.000000', '2024-06-08 11:50:00.000000', 2, 1, 2, '6e3c7c5b-b024-5e96-bd46', 'Motivo de la consulta del turno 2');

INSERT INTO almedin.turno (cancelado, ocupado, fechaInicio, fechaCreacion, id, profesional_id, socio_id, hash, motivoDeConsulta)
VALUES (0, 1, '2024-06-08 12:30:00.000000', '2024-06-08 11:55:00.000000', 3, 2, 3, '7f4d8d6c-c135-6f07-cd57', 'Motivo de la consulta del turno 3');

INSERT INTO almedin.turno (cancelado, ocupado, fechaInicio, fechaCreacion, id, profesional_id, socio_id, hash, motivoDeConsulta)
VALUES (0, 1, '2024-06-08 12:45:00.000000', '2024-06-08 12:00:00.000000', 4, 3, 1, '8g5e9e7d-d246-7g18-de68', 'Motivo de la consulta del turno 4');

-- Insertar en la tabla Receta
INSERT INTO almedin.receta (contenido, fechaCreacion, id, hash, turno_id, profesional_id, socio_id)
VALUES ('Contenido de la receta 1', '2024-06-08 12:00:00.000000', 1, 'a1b2c3d4-e5f6-7890-ghij', 1, 1, 1);

INSERT INTO almedin.receta (contenido, fechaCreacion, id, hash, turno_id, profesional_id, socio_id)
VALUES ('Contenido de la receta 2', '2024-06-08 12:15:00.000000', 2, 'b2c3d4e5-f678-90gh-ijkl', 2, 1, 2);

INSERT INTO almedin.receta (contenido, fechaCreacion, id, hash, turno_id, profesional_id, socio_id)
VALUES ('Contenido de la receta 3', '2024-06-08 12:30:00.000000', 3, 'c3d4e5f6-7890-ghij-klmn', 3, 2, 3);

INSERT INTO almedin.receta (contenido, fechaCreacion, id, hash, turno_id, profesional_id, socio_id)
VALUES ('Contenido de la receta 4', '2024-06-08 12:45:00.000000', 4, 'd4e5f678-90gh-ijkl-mnop', 4, 3, 1);
