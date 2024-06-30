-- Insertar en la tabla Plan
INSERT INTO almedin.plan (precio, id, nombre) VALUES (5000, 1, '110');

-- Insertar en la tabla Profesional
INSERT INTO almedin.profesional (id, apellido, documento, email, especialidad, matricula, nombre, ubicacion)
VALUES (1, 'Pérez', '35545789', 'jorgeperez@email.com', 'Traumatólogo', '12345', 'Jorge', 'Ubicación 1');

INSERT INTO almedin.profesional (id, apellido, documento, email, especialidad, matricula, nombre, ubicacion)
VALUES (2, 'Sanchez', '45698712', 'RickSanchez@email.com', 'Traumatólogo', '54321', 'Rick', 'Ubicación 2');

INSERT INTO almedin.profesional (id, apellido, documento, email, especialidad, matricula, nombre, ubicacion)
VALUES (3, 'Potter', '19852647', 'HarryPotter3@email.com', 'Traumatólogo', '98745', 'Harry', 'Ubicación 3');

-- Insertar en la tabla Socio
INSERT INTO almedin.socio (autorizado, edad, id, plan_id, apellido, documento, email, nombre,contrasenia,rol)
VALUES (1, 30, 1, 1, 'Benitez', '34512300', 'benitez@email.com', 'Victor',1234,'USUARIO');

INSERT INTO almedin.socio (autorizado, edad, id, plan_id, apellido, documento, email, nombre,contrasenia,rol)
VALUES (1, 22, 2, 1, 'Juarez', '87654321', 'juarez@email.com', 'manuel',12345,'USUARIO');

INSERT INTO almedin.socio (autorizado, edad, id, plan_id, apellido, documento, email, nombre,contrasenia,rol)
VALUES (1, 46, 3, 1, 'Picapiedra', '12345678', 'picapiedra@email.com', 'Pedro',12345,'USUARIO');

--

INSERT INTO almedin.socio (autorizado, edad, id, plan_id, apellido, documento, email, nombre,contrasenia,rol)
VALUES (1, 88, 4, 1, 'AdminApellido', '11111111', 'ADMINISTRADOR@email.com', 'AdminNOMBRE',123456,'ADMINISTRADOR');








-- Insertar en la tabla Turno
INSERT INTO almedin.turno (cancelado, ocupado, fechaInicio, fechaCreacion, id, profesional_id, socio_id, hash, motivoDeConsulta)
VALUES (0, 1, '2024-06-08 12:00:00.000000', '2024-06-08 11:46:49.054402', 100, 1, 1, '5e2b6b4a-a913-4d85-ac35-6524e7c0fa35', 'Motivo de la consulta del turno 100');

INSERT INTO almedin.turno (cancelado, ocupado, fechaInicio, fechaCreacion, id, profesional_id, socio_id, hash, motivoDeConsulta)
VALUES (0, 1, '2024-06-08 12:00:00.000000', '2024-06-08 11:46:49.054402', 101, 1, 2, '5e2b6b4a-a913-4d85-ac35-6524e7c0fa35', 'Motivo de la consulta del turno 101');

INSERT INTO almedin.turno (cancelado, ocupado, fechaInicio, fechaCreacion, id, profesional_id, socio_id, hash, motivoDeConsulta)
VALUES (0, 1, '2024-06-08 12:00:00.000000', '2024-06-08 11:46:49.054402', 102, 2, 1, '5e2b6b4a-a913-4d85-ac35-6524e7c0fa35', 'Motivo de la consulta del turno 102');

INSERT INTO almedin.turno (cancelado, ocupado, fechaInicio, fechaCreacion, id, profesional_id, socio_id, hash, motivoDeConsulta)
VALUES (0, 0, '2024-06-08 12:00:00.000000', '2024-06-08 11:46:49.054402', 103, 1, null, '5e2b6b4a-a913-4d85-ac35-6524e7c0fa35', 'Motivo de la consulta del turno 103');

INSERT INTO almedin.turno (cancelado, ocupado, fechaInicio, fechaCreacion, id, profesional_id, socio_id, hash, motivoDeConsulta)
VALUES (0, 0, '2024-06-08 12:00:00.000000', '2024-06-08 11:46:49.054402', 104, 2, null, '5e2b6b4a-a913-4d85-ac35-6524e7c0fa35', '');

INSERT INTO almedin.turno (cancelado, ocupado, fechaInicio, fechaCreacion, id, profesional_id, socio_id, hash, motivoDeConsulta)
VALUES (0, 0, '2024-06-08 12:00:00.000000', '2024-06-08 11:46:49.054402', 105, 3, null, '5e2b6b4a-a913-4d85-ac35-6524e7c0fa35', '');

-- Insertar en la tabla Receta
INSERT INTO almedin.receta (contenido, fechaCreacion, id, hash, turno_id, profesional_id, socio_id)
VALUES ('Contenido de la receta 1', '2024-06-08 12:00:00', 1, 'a1b2c3d4-e5f6-7890-ghij', 100, 1, 1);

INSERT INTO almedin.receta (contenido, fechaCreacion, id, hash, turno_id, profesional_id, socio_id)
VALUES ('Contenido de la receta 2', '2024-06-08 12:15:00.000000', 2, 'b2c3d4e5-f678-90gh-ijkl', 101, 1, 2);

INSERT INTO almedin.receta (contenido, fechaCreacion, id, hash, turno_id, profesional_id, socio_id)
VALUES ('Contenido de la receta 3', '2024-06-08 12:30:00.000000', 3, 'c3d4e5f6-7890-ghij-klmn', 102, 2, 1);
