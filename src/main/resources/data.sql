-- Insertando equipos
INSERT INTO equipo (id, nombre, category, coach) VALUES (1, 'Tegueste', 'Primera', 'Marcos');
INSERT INTO equipo (id, nombre, category, coach) VALUES (2, 'Chimbesque', 'Primera', 'Chevo');
INSERT INTO equipo (id, nombre, category, coach) VALUES (3, 'Llano Del Moro', 'Tercera', 'Kylian');

-- Insertando jugadores para Team A
INSERT INTO luchador (id, nombre, jerarquía, edad, equipo_id) VALUES (1, 'Diego Perez', 'Puntal B', '1990-05-15', 1);
INSERT INTO luchador (id, nombre, jerarquía, edad, equipo_id) VALUES (2, 'Argeo', 'Puntal C', '1992-07-20', 1);

-- Insertando jugadores para Team B
INSERT INTO luchador (id, nombre, jerarquía, edad, equipo_id) VALUES (3, 'Eusebio Ledesma', 'Puntal A', '1995-10-30', 2);
INSERT INTO luchador (id, nombre, jerarquía, edad, equipo_id) VALUES (4, 'Paquito García', 'Destacado A', '1998-02-18', 2);

-- Insertando jugadores para Team C
INSERT INTO luchador (id, nombre, jerarquía, edad, equipo_id) VALUES (5, 'Manolito', 'Destacado C', '1993-12-05', 3);
INSERT INTO luchador (id, nombre, jerarquía, edad, equipo_id) VALUES (6, 'Paco Acosta', 'Junior', '1991-03-22', 3);
