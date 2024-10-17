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
		System.out.println("2. Dar de alta un club");
		System.out.println("3. Se eliminara un usuario");
		System.out.println("#########################");
		System.out.println("elija una opcion: ");
		opcion=Inicio.sc.nextInt();
		return opcion;
	}

	@Override
	public byte mostrarMenuYSeleccionCampos() {
		
		byte opcion;
		
		System.out.println("########################");
		System.out.println("elija el campo que necesite modificar: ");
		System.out.println("1. Nombre");
		System.out.println("1. Apellidos");
		System.out.println("2. Email");
		System.out.println("#########################");
		opcion=Inicio.sc.nextByte();
		
		return opcion;
	}

}
