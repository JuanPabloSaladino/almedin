INSERT INTO almedin.plan (precio, id, nombre)
VALUES (5000, 1, '110');

INSERT INTO almedin.profesional (id, apellido, documento, email, especialidad, matricula, nombre)
VALUES (1, 'Pérez', '35545789', 'jorgeperez@email.com', 'Traumatólogo', '12345', 'Jorge');

INSERT INTO almedin.socio (autorizado, edad, id, plan_id, apellido, documento, email, nombre)
VALUES (1, 30, 1, 1, 'Benitez', '34512300', 'benitez@email.com', 'Victor');
