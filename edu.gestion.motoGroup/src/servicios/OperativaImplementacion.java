package servicios;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import controladores.Inicio;
import dtos.ClubDto;
import dtos.UsuarioDto;

/**
 * Clase que contiene la operativa de la aplicación
 * 09102024
 * @author jalvugo
 */
public class OperativaImplementacion implements OperativaInterfaz {

	ConexionBDInterfaz ci = new ConexionBDImplementacion();
	@Override
	public void darAltaUsuario() {
		ConsultasBDInterfaz consulta = new ConsultasBDImplementacion();
		consulta.cargaBDUsuario();
		UsuarioDto usuarioNuevo= nuevoUsuario();
		
		
		try {
			
			ci.abrirConexion();
			
			
			
			String insertarDatosUsu="INSERT INTO sus.usuario (id_usuario, Usu_nombre,Usu_apellidos,Dni_usuario,Email_usuario) VALUES (?,?,?,?,?)";	
			PreparedStatement sentencia = ci.abrirConexion().prepareStatement(insertarDatosUsu);
			
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
	
	/**
	 * Método para generar un id automaticamente
	 * 09102024
	 * @author jalvugo
	 * @return el id según cuantos usuarios haya.
	 */
	
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

	@Override
	public void darAltaClub() {
		ConsultasBDInterfaz consultaInter= new ConsultasBDImplementacion();
		consultaInter.cargaBDClub();
		ClubDto clubNuevo = nuevoClub();
		
		
		
		try {
			ci.abrirConexion();
			
			
			
			String insertarDatosClub = "INSERT INTO sus.club (id_club,nombre_club,miembros,sede) VALUES (?,?,?,?)";
			PreparedStatement sentencia = ci.abrirConexion().prepareStatement(insertarDatosClub);
			
			sentencia.setLong(1, clubNuevo.getIdClub());
			sentencia.setString(2, clubNuevo.getNombreClub());
			sentencia.setInt(3, clubNuevo.getMiembrosClub());
			sentencia.setString(4, clubNuevo.getSede());
			
		}catch(SQLException exception) {
			System.out.println("Error al insertar datos"+exception.getMessage());
		}finally {
			ci.cerrarConexion();
		}
		
		Inicio.listaClubes.add(clubNuevo);
		
		
		
	}
	
	private ClubDto nuevoClub() {
		
		ClubDto clubNuevo = new ClubDto();
		
		System.out.println("Introduce el nombre del club:");
		clubNuevo.setNombreClub(Inicio.sc.next());
		System.out.println("Introduce el numero de miembros que tiene: ");
		clubNuevo.setMiembrosClub(Inicio.sc.nextInt());
		System.out.println("Introduce la direccion de la sede del club: ");
		clubNuevo.setSede(Inicio.sc.next());
		clubNuevo.setIdClub(autoIdClub());
		
		return clubNuevo;
	}
	
	
	private long autoIdClub() {
		long nuevoId;
		int tamanioLista = Inicio.listaClubes.size();
		
		if(tamanioLista>0) {
			
			nuevoId = Inicio.listaClubes.get(tamanioLista - 1).getIdClub() + 1;
		}else {
			
			nuevoId=1;
		}
		
		return nuevoId;
	}

	@Override
	public void bajaUsuario() {
		
		UsuarioDto usuarioAEliminar = new UsuarioDto();
		String dniAPedir;
		for(UsuarioDto usuario:Inicio.listaUsuarios) {
			System.out.println(usuario.toString());
		}
		System.out.println("Introduzca el dni del usuario que desee eliminar: ");
		dniAPedir=Inicio.sc.next();
		
		for(UsuarioDto usuario:Inicio.listaUsuarios) {
			
			
		}
		
		
		
	}
	
	

}
