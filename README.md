# Trabajo Practico n°1 de Programacion Orientada a Objetos 1

Este proyecto es el trabajo practico de la materia orientacion a objetos 1 de la Licenciatura en Sistema
de la UNLa. Se desarrolla un sistema en Java que permita gestionar torneos de futbol.

## Integrantes

Bonino Ezequiel.  
Fernandez Rodrigo.  

## Casos de uso

ultimo actualizacion: 16-10-2025

Se dejan a continuacion los casos de usos implementados en el proyecto:

### 1- Generar todos los métodos para que se puedan agregar elementos a todas las listas

#### Sistema
1- agregarJugador  
2- agregarEntrenador  
3- agregarTorneo  
4- agregarEquipo  

#### Torneo
1- agregarEquipo    
2- agregarPartido  

#### Equipo
1- agregarJugador (falta modificacion)  

#### Partido
1- agregarEstadistica


### 2- Generar los métodos eliminar solo si necesarios (física o lógica) elementos a todas las listas por regla de negocio.

Hay algunos pero es necesarios mirarlos y quizas arreglarlos
#### Sistema

#### Torne

#### Equipo

#### Partido

### 3- Generar todos los métodos traer por atributo único (o id)

#### Sistema
1- traerPersona(dni)  
2- traerTorneo(id)  
3- traerEquipo(id)  
4- traerEquipo(codigo)  

#### Torneo
1- traerEquipo(codigo)    
2- traerPartido(fecha,hora,estadio)  
3- traerPartido(id)  

#### Equipo
1- traerJugador(dni)

#### Partido
1- traerEstadistica(id)  
2- traerEstadistica(persona)


### 4- TODO


### 5- Búsqueda de entrenadores: Crear un método que, dada una táctica preferida, devuelva una lista de todos los entrenadores que la utilicen.

- Implementado en la clase Sistema.  


### 6- Búsqueda de jugadores por fecha de nacimiento: Implementar una método que retorne una lista de jugadores nacidos entre dos fechas dadas.

- Implementado en la clase Sistema.

### 7. Búsqueda de equipos por fecha de fundación: Desarrollar un método que devuelva una lista de equipos fundados antes de una fecha específica.

- Implementado en la clase Sistema.

### 8. Cálculo de altura promedio de equipo: Escribir un método que calcule y retorne la altura promedio de un equipo.

- Implementado en la clase Equipo.

### 9. Identificación de equipo con mayor altura promedio: Crear un método que devuelva el objeto Equipo con la mayor altura promedio en el torneo.

- Implementado en la clase Torneo.

### 10. Cálculo de puntos de equipo: Implementar un método que calcule y retorne el total de puntos acumulados por un equipo, considerando 3 puntos por victoria y 1 por empate..

- Implementado en la clase Torneo.

### 11. Generación de tabla de posiciones: Desarrollar un método que retorne una lista de (Posicion, no se persiste es solo para generar reporte) que contenga equipo y puntaje, ordenada de mayor a menor puntaje (utilizando ordenamiento de listas nativo o desarrollando el algoritmo de algún método de ordenamiento)..

- Implementado en la clase Torneo.

### 12. . Cálculo de goles por jugador: Escribir un método que, dado un objeto Jugador, devuelva el total de goles que ha logrado en el torneo..

- Implementado en la clase Torneo.

### 13. Cálculo de asistencias por jugador: Escribir un método que, dado un objeto Jugador, devuelva el total de asistencias que ha logrado en el torneo.

- Implementado en la clase Torneo.

### 14. Generación de tabla de goleadores: Crear un método que retorne una lista de (Goleador, no se persiste es solo para generar reporte) con el jugador y los goles, ordenada de mayor a menor (utilizando ordenamiento de listas nativo o desarrollando el algoritmo de algún método de ordenamiento)..

- Implementado en la clase Torneo.

### 15. Generación de tabla de asistidores: Implementar un método que retorne una lista de (Asistencia, no se persiste es solo para generar reporte) con el jugador y sus asistencias, ordenada de mayor a menor (utilizando ordenamiento de listas nativo o desarrollando el algoritmo de algún método de ordenamiento).

- Implementado en la clase Torneo.


