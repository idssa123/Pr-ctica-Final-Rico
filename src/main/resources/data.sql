INSERT INTO equipos (nombre, ciudad, año_fundacion, estadio) VALUES
('RCD Coruña', 'A Coruña', 1907, 'Riazor'),
('Barcelona', 'Barcelona', 1899, 'Camp Nou'),
('Real Madrid', 'Madrid', 1902, 'Bernabéu'),
('Sevilla', 'Sevilla', 1905, 'Sánchez Pizjuán');

INSERT INTO jugadores (nombre, numero_camiseta, posicion, altura, peso, equipo_id) VALUES
('Fran González', 1, 'Portero', 1.85, 82, 1),
('Roy Makaay', 9, 'Delantero', 1.81, 80, 1),
('Lucas Pérez', 11, 'Delantero', 1.79, 75, 1),
('Kroos', 8, 'Centrocampista', 1.83, 79, 3),
('Vinicius', 7, 'Extremo', 1.76, 73, 3),
('Lewandowski', 9, 'Delantero', 1.85, 81, 2),
('De Jong', 21, 'Centrocampista', 1.81, 80, 2);

INSERT INTO competiciones (nombre, tipo, año) VALUES
('La Liga', 'Liga', 2024),
('Copa del Rey', 'Copa', 2024),
('Champions League', 'Liga Europea', 2024);

INSERT INTO partidos (equipo_local_id, equipo_visitante_id, fecha, goles_local, goles_visitante, estadio, competicion) VALUES
(1, 3, '2024-01-15', 1, 2, 'Riazor', 'La Liga'),
(1, 2, '2024-01-22', 0, 1, 'Riazor', 'La Liga'),
(3, 1, '2024-02-10', 3, 1, 'Bernabéu', 'Copa del Rey');

INSERT INTO participaciones (jugador_id, partido_id, goles, asistencias, tarjeta_amarilla, tarjeta_roja, minutos_jugados) VALUES
(1, 1, 0, 0, false, false, 90),
(2, 1, 1, 0, false, false, 85),
(3, 1, 0, 1, true, false, 72),
(1, 2, 0, 0, false, false, 90),
(2, 2, 0, 0, false, false, 45),
(3, 2, 0, 0, true, false, 90),
(1, 3, 0, 0, false, false, 90),
(2, 3, 1, 0, false, false, 60),
(3, 3, 0, 1, false, false, 58);

INSERT INTO jugador_competicion (jugador_id, competicion_id) VALUES
(1, 1),
(1, 2),
(1, 3),
(2, 1),
(2, 2),
(3, 1),
(3, 2),
(4, 1),
(4, 3),
(5, 1),
(5, 3),
(6, 1),
(6, 3),
(7, 1),
(7, 2);
