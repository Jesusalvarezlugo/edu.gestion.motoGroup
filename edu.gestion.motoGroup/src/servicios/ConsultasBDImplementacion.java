package servicios;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controladores.Inicio;
import dtos.UsuarioDto;

public class ConsultasBDImplementacion implements ConsultasBDInterfaz {

	@Override
	public void cargaBD() {
		
		
		
		try {
			UsuarioDto usuario = new UsuarioDto();
			
			
			
			Statement sentencia = Inicio.conexion.createStatement();
			ResultSet resultado = sentencia.executeQuery("SELECT * FROM usuario");
			
			resultado.first();
			
			usuario.setIdUsuario(resultado.getLong(0));
			usuario.setNombreUsuario(resultado.getString(1));
			usuario.setApellidosUsuario(resultado.getString(2));
			usuario.setDniUsuario(resultado.getString(3));
			usuario.setEmailUsuario(resultado.getString(4));
			
		}catch(SQLException e) {
			System.out.println("Error al hacer la carga inicial"+e.getMessage());
		}
		
		
	}

}
