INSERT INTO equipos (nombre, ciudad, año_fundacion, estadio) VALUES
('RCD Coruña', 'A Coruña', 1907, 'Riazor'),
('Barcelona', 'Barcelona', 1899, 'Camp Nou'),
('Real Madrid', 'Madrid', 1902, 'Bernabéu'),
('Sevilla', 'Sevilla', 1905, 'Sánchez Pizjuán');

INSERT INTO jugadores (nombre, numero_camiseta, posicion, altura, peso, equipo_id) VALUES
('Fran González', 10, 'Interior Izquierdo', 1.79, 74, 1),
('Roy Makaay', 7, 'Delantero', 1.88, 83, 1),
('Lionel Scaloni', 12, 'Defensa', 1.82, 77, 1),
('Djalminha', 8, 'Centrocampista', 1.76, 71, 1),
('Donato', 6, 'Centrocampista', 1.78, 75, 1)


INSERT INTO competiciones (nombre, tipo, año) VALUES
('La Liga', 'Liga', 1992),
('Copa del Rey', 'Copa', 1992),
('Champions League', 'Liga Europea', 1992);

INSERT INTO partidos (equipo_local_id, equipo_visitante_id, fecha, goles_local, goles_visitante, estadio, competicion) VALUES
(1, 3, '1992-09-15', 2, 0, 'Riazor', 'La Liga'),
(1, 2, '1992-10-22', 1, 0, 'Riazor', 'La Liga'),
(1, 3, '1993-02-10', 2, 1, 'Riazor', 'Copa del Rey');

INSERT INTO participaciones (jugador_id, partido_id, goles, asistencias, tarjeta_amarilla, tarjeta_roja, minutos_jugados) VALUES
(1, 1, 1, 0, false, false, 90),
(2, 1, 1, 0, false, false, 85),
(3, 1, 0, 1, true, false, 72),
(1, 2, 1, 0, false, false, 90),
(2, 2, 0, 0, false, false, 45),
(3, 2, 0, 0, true, false, 90),
(1, 3, 1, 0, false, false, 90),
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
