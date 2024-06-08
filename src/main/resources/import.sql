INSERT INTO almedin.plan (precio, id, nombre)
VALUES (5000, 1, '110');

INSERT INTO almedin.profesional (id, apellido, documento, email, especialidad, matricula, nombre)
VALUES (1, 'Pérez', '35545789', 'jorgeperez@email.com', 'Traumatólogo', '12345', 'Jorge');

INSERT INTO almedin.socio (autorizado, edad, id, plan_id, apellido, documento, email, nombre)
VALUES (1, 30, 1, 1, 'Benitez', '34512300', 'benitez@email.com', 'Victor');

INSERT INTO almedin.turno (cancelado, ocupado, fecha, fechaCreacion, id, profesional_id, socio_id, hash, motivoDeConsulta)
VALUES (0, 0, '2024-06-08 12:00:00.000000', '2024-06-08 11:46:49.054402', 1, 1, 1, '5e2b6b4a-a913-4d85-ac35-6524e7c0fa35', 'Motivo de la consulta del turno 1');
