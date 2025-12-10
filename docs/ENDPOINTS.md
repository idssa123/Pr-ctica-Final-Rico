# Documentación de Endpoints

---

## Competición - `/api/competiciones`

- `GET /api/competiciones`

  - Descripción: Obtiene la lista de todas las competiciones.
  - Respuesta: `200 OK` con un arreglo de objetos `Competicion`.
  - Campos principales devueltos (modelo `Competicion`): `id`, `nombre`, `tipo`, `ao`.

- `GET /api/competiciones/{id}`

  - Descripción: Obtiene una competición por su `id`.
  - Parámetros: `id` (Integer) en la ruta.
  - Respuesta: `200 OK` con objeto `Competicion` o `404 Not Found` si no existe.

- `POST /api/competiciones`

  - Descripción: Crea una nueva competición.
  - Body: JSON con datos de `Competicion` (ej. `nombre`, `tipo`, `ao`).
  - Respuesta: `201 Created` con la competición creada.

- `PUT /api/competiciones/{id}`

  - Descripción: Actualiza la competición indicada por `id`.
  - Body: JSON con datos de `Competicion` actualizados.
  - Respuesta: `200 OK` con la competición actualizada o `404` si no existe.

- `DELETE /api/competiciones/{id}`

  - Descripción: Elimina la competición indicada por `id`.
  - Respuesta: `204 No Content` o `404` si no existe.

- `GET /api/competiciones/nombre/{nombre}`

  - Descripción: Busca una competición por su `nombre`.
  - Respuesta: `200 OK` con objeto `Competicion` o `404`.

- `GET /api/competiciones/tipo/{tipo}`

  - Descripción: Lista competiciones filtradas por `tipo`.
  - Respuesta: `200 OK` con arreglo de `Competicion`.

- `GET /api/competiciones/ao/{ao}`
  - Descripción: Lista competiciones del `ao` indicado.
  - Respuesta: `200 OK` con arreglo de `Competicion`.

---

## Equipo - `/api/equipos`

- `GET /api/equipos`

  - Descripción: Obtiene todos los equipos como `EquipoDTO`.
  - Respuesta: `200 OK` con arreglo de `EquipoDTO`.
  - Campos habituales en `EquipoDTO`: `id`, `nombre`, `ciudad`, `aoFundacion`, `estadio`, `totalJugadores`.

- `GET /api/equipos/{id}`

  - Descripción: Obtiene un equipo por `id` como `EquipoDTO`.
  - Respuesta: `200 OK` con `EquipoDTO` o `404`.

- `POST /api/equipos`

  - Descripción: Crea un equipo (envía `Equipo` en el body).
  - Body: JSON con `nombre`, `ciudad`, `aoFundacion`, `estadio`.
  - Respuesta: `201 Created` con `EquipoDTO` creado.

- `PUT /api/equipos/{id}`

  - Descripción: Actualiza un equipo por `id`.
  - Body: JSON con los campos de `Equipo` a actualizar.
  - Respuesta: `200 OK` con `EquipoDTO` actualizado o `404`.

- `DELETE /api/equipos/{id}`

  - Descripción: Elimina un equipo por `id`.
  - Respuesta: `204 No Content` o `404`.

- `GET /api/equipos/ciudad/{ciudad}`
  - Descripción: Lista equipos cuya `ciudad` coincide.
  - Respuesta: `200 OK` con arreglo de `EquipoDTO`.

---

## Jugador - `/api/jugadores`

- `GET /api/jugadores`

  - Descripción: Obtiene todos los jugadores como `JugadorDTO`.
  - Respuesta: `200 OK` con arreglo de `JugadorDTO`.
  - Campos frecuentes en `Jugador`/`JugadorDTO`: `id`, `nombre`, `numeroCamiseta`, `posicion`, `altura`, `peso`, `equipo` (objeto o id), `competiciones`.

- `GET /api/jugadores/{id}`

  - Descripción: Obtiene un jugador por `id` como `JugadorDTO`.
  - Respuesta: `200 OK` con `JugadorDTO` o `404`.

- `POST /api/jugadores`

  - Descripción: Crea un jugador.
  - Body: JSON con `nombre`, `numeroCamiseta`, `posicion`, `altura`, `peso`, `equipo` (id o JSON según implementación).
  - Respuesta: `201 Created` con `JugadorDTO` creado.

- `PUT /api/jugadores/{id}`

  - Descripción: Actualiza un jugador por `id`.
  - Respuesta: `200 OK` con `JugadorDTO` actualizado o `404`.

- `DELETE /api/jugadores/{id}`

  - Descripción: Elimina un jugador por `id`.
  - Respuesta: `204 No Content` o `404`.

- `GET /api/jugadores/equipo/{equipoId}`

  - Descripción: Lista jugadores que pertenecen al equipo indicado por `equipoId`.
  - Respuesta: `200 OK` con arreglo de `JugadorDTO`.

- `GET /api/jugadores/posicion/{posicion}`
  - Descripción: Lista jugadores por `posicion` (ej. "Defensa", "Delantero").
  - Respuesta: `200 OK` con arreglo de `JugadorDTO`.

---

## Participación - `/api/participaciones`

- `GET /api/participaciones`

  - Descripción: Obtiene todas las participaciones como `ParticipacionDTO`.
  - Respuesta: `200 OK` con arreglo de `ParticipacionDTO`.
  - Campos en `Participacion`: `id`, `jugador` (objeto), `partido` (objeto), `goles`, `asistencias`, `tarjetaAmarilla`, `tarjetaRoja`, `minutosJugados`.

- `GET /api/participaciones/{id}`

  - Descripción: Obtiene una participación por `id`.
  - Respuesta: `200 OK` o `404`.

- `POST /api/participaciones`

  - Descripción: Crea una participación.
  - Body: JSON con `jugador` (id), `partido` (id), `goles`, `asistencias`, `tarjetaAmarilla`, `tarjetaRoja`, `minutosJugados`.
  - Respuesta: `201 Created` con `ParticipacionDTO`.

- `PUT /api/participaciones/{id}`

  - Descripción: Actualiza una participación por `id`.
  - Respuesta: `200 OK` con la participación actualizada o `404`.

- `DELETE /api/participaciones/{id}`

  - Descripción: Elimina una participación por `id`.
  - Respuesta: `204 No Content` o `404`.

- `GET /api/participaciones/jugador/{jugadorId}`

  - Descripción: Obtiene las participaciones de un jugador concreto.
  - Respuesta: `200 OK` con arreglo de `ParticipacionDTO`.

- `GET /api/participaciones/partido/{partidoId}`

  - Descripción: Obtiene las participaciones en un partido concreto.
  - Respuesta: `200 OK` con arreglo de `ParticipacionDTO`.

- `GET /api/participaciones/con-goles`
  - Descripción: Obtiene las participaciones donde el jugador marcó goles (filtrado por `goles > 0`).
  - Respuesta: `200 OK` con arreglo de `ParticipacionDTO`.

---

## Partido - `/api/partidos`

- `GET /api/partidos`

  - Descripción: Obtiene todos los partidos como `PartidoDTO`.
  - Respuesta: `200 OK` con arreglo de `PartidoDTO`.
  - Campos en `Partido`: `id`, `equipoLocal` (objeto), `equipoVisitante` (objeto), `fecha`, `golesLocal`, `golesVisitante`, `estadio`, `competicion`.

- `GET /api/partidos/{id}`

  - Descripción: Obtiene un partido por `id`.
  - Respuesta: `200 OK` con `PartidoDTO` o `404`.

- `POST /api/partidos`

  - Descripción: Crea un partido.
  - Body: JSON con `equipoLocal` (id), `equipoVisitante` (id), `fecha` (ISO), `golesLocal`, `golesVisitante`, `estadio`, `competicion`.
  - Respuesta: `201 Created` con `PartidoDTO`.

- `PUT /api/partidos/{id}`

  - Descripción: Actualiza un partido por `id`.
  - Respuesta: `200 OK` con `PartidoDTO` actualizado o `404`.

- `DELETE /api/partidos/{id}`

  - Descripción: Elimina un partido por `id`.
  - Respuesta: `204 No Content` o `404`.

- `GET /api/partidos/equipo/{equipoId}`

  - Descripción: Lista partidos en los que participa el equipo `equipoId` (local o visitante según implementación del servicio).
  - Respuesta: `200 OK` con arreglo de `PartidoDTO`.

- `GET /api/partidos/competicion/{competicion}`
  - Descripción: Lista partidos de la competición indicada (`competicion` por nombre).
  - Respuesta: `200 OK` con arreglo de `PartidoDTO`.
