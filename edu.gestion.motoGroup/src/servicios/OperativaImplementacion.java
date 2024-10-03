package servicios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controladores.Inicio;
import dtos.UsuarioDto;

public class OperativaImplementacion implements OperativaInterfaz {

	@Override
	public void darAltaUsuario() {
		
		UsuarioDto usuarioNuevo=nuevoUsuario();
		ConexionBDInterfaz ci = new ConexionBDImplementacion();
		ConsultasBDInterfaz consulta = new ConsultasBDImplementacion();
		try {
			
			ci.abrirConexion();
			
			consulta.cargaBD();
			
			String insertarDatos="INSERT INTO sus.usuario (id_usuario, Usu_nombre,Usu_apellidos,Dni_usuario,Email_usuario) VALUES (?,?,?,?,?)";	
			PreparedStatement sentencia = Inicio.conexion.prepareStatement(insertarDatos);
			
			sentencia.setLong(1, usuarioNuevo.getIdUsuario());
			sentencia.setString(2,usuarioNuevo.getNombreUsuario());
			sentencia.setString(3, usuarioNuevo.getApellidosUsuario());
			sentencia.setString(4,usuarioNuevo.getDniUsuario());
			sentencia.setString(5, usuarioNuevo.getEmailUsuario());
			
			sentencia.executeUpdate();
			
			
			
			
		}catch(SQLException ex) {
			System.out.println("Error al insertar datos"+ex.getMessage());
		}finally {
			ci.cerrarConexion();
		}
		
		Inicio.listaUsuarios.add(usuarioNuevo);
		
		
	}
	
	/**
	 * Metodo para crear un nuevo usuario
	 * @return el nuevo usuario
	 * 02102024
	 * @author jalvugo
	 */
	private UsuarioDto nuevoUsuario() {
		
		UsuarioDto usuario = new UsuarioDto();
		
		System.out.println("Introduzca su nombre: ");
		usuario.setNombreUsuario(Inicio.sc.next());
		System.out.println("Introduzca sus apellidos");
		usuario.setApellidosUsuario(Inicio.sc.next());
		System.out.println("Introduzca su dni: ");
		usuario.setDniUsuario(Inicio.sc.next());
		System.out.println("Introduzca su email: ");
		usuario.setEmailUsuario(Inicio.sc.next());
		usuario.setIdUsuario(autoId());
		
		return usuario;
	}
	
	private long autoId() {
		long idNuevo;
		int tamanioLista=Inicio.listaUsuarios.size();
		
		if(tamanioLista>0) {
			idNuevo=Inicio.listaUsuarios.get(tamanioLista -1 ).getIdUsuario() +1;
		}else {
			idNuevo=1;
		}
		
		return idNuevo;
	}
	
	

}
