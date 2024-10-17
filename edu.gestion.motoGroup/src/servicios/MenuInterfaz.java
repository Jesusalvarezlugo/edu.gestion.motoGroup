package servicios;

/**
 * Interfaz para la operativa del menu
 * 02102024
 * @author jalvugo
 */
public interface MenuInterfaz {
	
	/**
	 * Método para mostrar el menu y la seleccion del usuario
	 * 02102024
	 * @author jalvugo
	 */
	
	public int mostrarMenuYSeleccion();
	
	/**
	 * Método para mostrar los campos de los usuarios para modificar
	 * @return opcion seleccionada
	 * 17102024
	 */
	public byte mostrarMenuYSeleccionCampos();

}
