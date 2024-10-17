
package controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dtos.ClubDto;
import dtos.UsuarioDto;
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

 
    
    public static List<UsuarioDto> listaUsuarios = new ArrayList<UsuarioDto>();
    public static List<ClubDto> listaClubes = new ArrayList<ClubDto>();
    public static Scanner sc= new Scanner(System.in);
    public static void main(String[] args) {
    	
    	 
    	 
         int opcion;
         boolean cerrarMenu=false;
         MenuInterfaz mi = new MenuImplementacion();
         
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
        			 
        		 case 2:
        			 System.out.println("Se dara de alta un nuevo club.");
        			 oi.darAltaClub();
        			 break;
        			 
        		 case 3:
        			 System.out.println("Se eliminara un usuario.");
        			 oi.bajaUsuario();
        			 break;
        		 }
        		 
        	 }catch(Exception e) {
        		 
        	 }
         }while(!cerrarMenu);
                           
    }

}









