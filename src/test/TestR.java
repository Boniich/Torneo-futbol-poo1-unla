package test;
import java.time.LocalDate;

import modelo.*;
public class TestR {
    public static void main(String[] args) {
        Sistema s = new Sistema();
System.out.println("hola mundo");
//Agregar entrenador y mostrarlo
        try {
            s.agregarEntrenador("Mario", "Bros", 11111111, LocalDate.of(1998,1,12), "Romper culos");
           System.out.println(s.traerEntrenador(11111111)); 
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //agregar equipo y mostrarlo
        try {
            s.agregarEquipo("Boca jr", 11111111);
            //traer equipo por id
            System.out.println("Traigo el equipo por id"+s.traerEquipo(1));
            //traer equipo por codigo
            System.out.println("Traigo el equipo por codigo"+s.traerEquipo("BOC"));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // agrego jugadores y lo muestro
        try{
            s.agregarJugador("Rodrigo", "Fernandez", 22222222, LocalDate.of(1998,1,12), 1.80, 100, "Defensor", 5);
             System.out.println("Traigo el jugador"+s.traerJugador(22222222));
        }catch(Exception e){
             e.printStackTrace();
        }
        //pruebo que funcione la excepcion
                try{
            s.agregarJugador("Rodrigo", "Fernandez", 22222222, LocalDate.of(1998,1,12), 1.80, 100, "Defensor", 5);
             System.out.println("Traigo el jugador"+s.traerJugador(22222222));
        }catch(Exception e){
             e.printStackTrace();
        }
        //cargo jugador al equipo
        try{
            s.traerEquipo("Boc").agregarJugador(s.traerJugador(22222222));
             System.out.println("Traigo el equipo por codigo"+s.traerEquipo("BOC"));
        }catch(Exception e){
            System.out.println(e.getMessage()); 
        }
        //elimino el equipo
              try{
                System.out.println("intento eliminar el equipo");
            s.eliminarEquipo("BOC");
             System.out.println("Intento traer el equipo que borre"+s.traerEquipo("BOC"));
             
        }catch(Exception e){
             System.out.println(e.getMessage()); 
        }
        //intento eliminar el mismo equipo
                     try{
                System.out.println("intento eliminar el mismo equipo");
                s.eliminarEquipo("BOC");
                
             
        }catch(Exception e){
            System.out.println(e.getMessage()); 
        }
        System.out.println("Intento traer el equipo que borre: "+s.traerEquipo("BOC"));
    }
}
