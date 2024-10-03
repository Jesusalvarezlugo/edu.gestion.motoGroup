
package controladores;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dtos.UsuarioDto;
import servicios.ConexionBDImplementacion;
import servicios.ConexionBDInterfaz;
import servicios.MenuImplementacion;
import servicios.MenuInterfaz;
import servicios.OperativaImplementacion;
import servicios.OperativaInterfaz;


/**
 * Clase por la que se inicia la aplicacion
 * 02102024
 * @author jalvugo
 */
public class Inicio {

 
    public static Connection conexion = null;//Preguntar sobre poner estatica la conexion
    public static List<UsuarioDto> listaUsuarios = new ArrayList<UsuarioDto>();
    public static Scanner sc= new Scanner(System.in);
    public static void main(String[] args) {
    	
    	 
    	 
         int opcion;
         boolean cerrarMenu=false;
         MenuInterfaz mi = new MenuImplementacion();
         ConexionBDInterfaz cb = new ConexionBDImplementacion();
         OperativaInterfaz oi = new OperativaImplementacion();
         
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
        			 oi.darAltaUsuario();
        			 break;
        		 }
        		 
        	 }catch(Exception e) {
        		 
        	 }
         }while(!cerrarMenu);
                           
    }

}









