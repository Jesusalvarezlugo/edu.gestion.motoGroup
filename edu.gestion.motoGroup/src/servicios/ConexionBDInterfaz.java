package servicios;

import java.sql.Connection;

public interface ConexionBDInterfaz {
	
	public Connection abrirConexion();
	
	public void cerrarConexion();

}
