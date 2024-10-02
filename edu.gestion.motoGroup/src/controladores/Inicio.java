
package controladores;

import java.sql.Connection;
import java.util.Scanner;

import servicios.ConexionBDImplementacion;
import servicios.ConexionBDInterfaz;
import servicios.MenuImplementacion;
import servicios.MenuInterfaz;


/**
 * Clase por la que se inicia la aplicacion
 * 02102024
 * @author jalvugo
 */
public class Inicio {

 
    public static Connection conexion = null;//Preguntar sobre poner estatica la conexion
    
    public static Scanner sc= new Scanner(System.in);
    public static void main(String[] args) {
    	
    	 ConexionBDInterfaz cb = new ConexionBDImplementacion();
    	 cb.abrirConexion();
    	 cb.cerrarConexion();
         int opcion;
         boolean cerrarMenu=false;
         MenuInterfaz mi = new MenuImplementacion();
         
         
         do {
        	 try {
        		 opcion=mi.mostrarMenuYSeleccion();
        		 
        		 switch(opcion) {
        		 	
        		 case 0:
        			 System.out.println("Se cerrara la aplicación.");
        			 cerrarMenu=true;
        			 break;
        			 
        		 case 1:
        			 System.out.println("Se dara de alta un nuevo usuario.");
        			 break;
        		 }
        		 
        	 }catch(Exception e) {
        		 
        	 }
         }while(!cerrarMenu);
                           
    }

}









