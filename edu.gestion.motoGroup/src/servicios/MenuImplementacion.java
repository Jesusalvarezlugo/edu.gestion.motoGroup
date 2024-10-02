package servicios;

import controladores.Inicio;
/**
 * Clase para la operacion del menu
 * 02102024
 * @author jalvugo
 */
public class MenuImplementacion implements MenuInterfaz {

	@Override
	public int mostrarMenuYSeleccion() {
		int opcion;
		
		System.out.println("########################");
		System.out.println("0. Salir de la aplicacion");
		System.out.println("1. Dar alta usuario");
		System.out.println("2.");
		System.out.println("#########################");
		System.out.println("elija una opcion: ");
		opcion=Inicio.sc.nextInt();
		return opcion;
	}

}
