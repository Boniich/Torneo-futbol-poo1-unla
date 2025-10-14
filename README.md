# Trabajo Practico n°1 de Programacion Orientada a Objetos 1

Este proyecto es el trabajo practico de la materia orientacion a objetos 1 de la Licenciatura en Sistema
de la UNLa. Se desarrolla un sistema en Java que permita gestionar torneos de futbol.

## Integrantes

Bonino Ezequiel.  
Rodrigo

## Casos de uso

ultimo actualizacion: 

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



