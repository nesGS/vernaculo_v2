---------------------------------------------------------------------------
--Insertando Clubes
INSERT INTO club (id, name, location, website) VALUES
(1, 'Tegueste', 'Tegueste', 'www.teguestelucha.com'),
(2, 'Chimbesque', 'San Miguel de Abona', 'www.chimbesquelucha.com'),
(3, 'Llano Del Moro', 'Santa Cruz', 'www.llanodelmorolucha.com');
---------------------------------------------------------------------------
-- Insertando teams
INSERT INTO team (id, name, category, coach, club_id) VALUES
(1, 'Tegueste', 'Primera', 'Marcos',1),
(2, 'Chimbesque', 'Primera', 'Chevo',2),
(3, 'Llano Del Moro', 'Tercera', 'Kylian',3);
---------------------------------------------------------------------------
-- Insertando jugadores para Team 1, 2 y 3
INSERT INTO player (id, name, ranking, birth, team_id) VALUES
(1, 'Diego Perez', 'Puntal B', '1990-05-15', 1),
(2, 'Argeo', 'Puntal C', '1992-07-20', 1),

(3, 'Eusebio Ledesma', 'Puntal A', '1995-10-30', 2),
(4, 'Paquito García', 'Destacado A', '1998-02-18', 2),

(5, 'Manolito', 'Destacado C', '1993-12-05', 3),
(6, 'Paco Acosta', 'Junior', '1991-03-22', 3);
---------------------------------------------------------------------------
-- Insertando stats
INSERT INTO player_stats (id, win_rounds, lose_rounds, advices, player_id) VALUES
(1, 6, 0, 1, 1),
(2, 5, 1, 0, 2),
(3, 4, 1, 1, 3),
(4, 3, 1, 2, 4),
(5, 2, 1, 3, 5),
(6, 1, 0, 4, 6);
---------------------------------------------------------------------------


