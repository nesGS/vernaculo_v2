--Insertando Clubes
INSERT INTO club (id, name, location, website) VALUES
(1, 'Tegueste', 'Tegueste', 'www.teguestelucha.com'),
(2, 'Chimbesque', 'San Miguel de Abona', 'www.chimbesquelucha.com'),
(3, 'Llano Del Moro', 'Santa Cruz', 'www.llanodelmorolucha.com');

-- Insertando equipos
INSERT INTO equipo (id, nombre, category, coach, club_id) VALUES
(1, 'Tegueste', 'Primera', 'Marcos',1),
(2, 'Chimbesque', 'Primera', 'Chevo',2),
(3, 'Llano Del Moro', 'Tercera', 'Kylian',3);

-- Insertando jugadores para Team 1
INSERT INTO luchador (id, nombre, jerarquía, edad, equipo_id) VALUES
(1, 'Diego Perez', 'Puntal B', '1990-05-15', 1),
(2, 'Argeo', 'Puntal C', '1992-07-20', 1);

-- Insertando jugadores para Team 2
INSERT INTO luchador (id, nombre, jerarquía, edad, equipo_id) VALUES
(3, 'Eusebio Ledesma', 'Puntal A', '1995-10-30', 2),
(4, 'Paquito García', 'Destacado A', '1998-02-18', 2);

-- Insertando jugadores para Team 3
INSERT INTO luchador (id, nombre, jerarquía, edad, equipo_id) VALUES
(5, 'Manolito', 'Destacado C', '1993-12-05', 3),
(6, 'Paco Acosta', 'Junior', '1991-03-22', 3);


