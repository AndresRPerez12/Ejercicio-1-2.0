package unal.poo.practica;

import becker.robots.*;

/** 
 * Practica de los conceptos de Programacion Estructurada
 * @author Fabian Andres Giraldo */
public class RobotBase
{    
       //Declaracion de Variables -- Forma temporal - No es buena practica tener
       //variables estaticas
        public static City objetos;
        public static Robot estudiante;
        
        public static boolean rightclear (){
                turn(3);
                boolean ret = estudiante.frontIsClear();
                turn(1);
                return ret;
            }
            
        public static void turn ( int x ){
            for( int i = 0 ; i < x ; i ++ )
                estudiante.turnLeft();
        }
        
	public static void main (String[] args){
            //Declarar la creacion de la ciudad
            objetos = new City("Field.txt");
	    objetos.showThingCounts(true);
            
            
            //Direction.NORTH, EAST, SOUTH, WEST
            //Definicion de la ubicacion del robot, Ciudad, posicion, Direccion, Numero things en el bolso.
            estudiante = new Robot(objetos,10, 1, Direction.EAST,1000);
               
            while( rightclear() ) turn(1);
            
            while( !estudiante.canPickThing() ){
                if( rightclear() ){
                    turn(3);
                    estudiante.move();
                }else if( estudiante.frontIsClear() ) estudiante.move();
                else turn(1);
            }
            estudiante.pickThing();
        }
            
}
