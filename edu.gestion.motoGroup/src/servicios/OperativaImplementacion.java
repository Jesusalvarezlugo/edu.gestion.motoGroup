package servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	ConsultasBDInterfaz consulta= new ConsultasBDImplementacion();
	@Override
	public void darAltaUsuario() {
		
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
		String apellido1;
		String apellido2;
		System.out.println("Introduzca su nombre: ");
		usuario.setNombreUsuario(Inicio.sc.next());
		System.out.println("Introduzca su primer apellido");
		apellido1=Inicio.sc.next();
		System.out.println("Introduzca su segundo apellido");
		apellido2=Inicio.sc.next();
		usuario.setApellidosUsuario(apellido1.concat(" ").concat(apellido2));
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
		
		consulta.cargaBDClub();
		ClubDto clubNuevo = nuevoClub();
		
		
		
		try {
			ci.abrirConexion();
			
			
			
			String insertarDatosClub = "INSERT INTO sus.club (id_club,nombre_club,miembros,sede) VALUES (?,?,?,?)";
			PreparedStatement sentencia = ci.abrirConexion().prepareStatement(insertarDatosClub);
			
			sentencia.setLong(1, clubNuevo.getIdClub());
			sentencia.setString(2, clubNuevo.getNombreClub());
			sentencia.setInt(3, clubNuevo.getMiembrosClub());
			sentencia.setString(4, clubNuevo.getSede());
			
			sentencia.executeUpdate();
			
		}catch(SQLException exception) {
			System.out.println("Error al insertar datos"+exception.getMessage());
		}finally {
			ci.cerrarConexion();
		}
		
		Inicio.listaClubes.add(clubNuevo);
		
		
		
	}
	
	/**
	 * Método para crear un club nuevo
	 * 17102024
	 * @return un nuevo club
	 * @author jalvugo
	 */
	
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
	
	/**
	 * Método para generar el id del club
	 * 17102024
	 * @return el nuevo id del club
	 * @author jalvugo
	 */
	
	
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
		consulta.cargaBDUsuario();
		
		UsuarioDto usuarioAEliminar = new UsuarioDto();
		String dniAPedir;
		
		for(UsuarioDto usuario:Inicio.listaUsuarios) {
			System.out.println(usuario.toString());
		}
		System.out.println("Introduzca el dni del usuario que desee eliminar: ");
		dniAPedir=Inicio.sc.next();
		
		for(UsuarioDto usuario:Inicio.listaUsuarios) {
			
			if(usuario.getDniUsuario().equals(dniAPedir)) {
				
				usuarioAEliminar=usuario;
				break;
			}
		}
		
		try {
			
			String eliminarUsuario="DELETE FROM sus.usuario WHERE dni_usuario = ?";
			PreparedStatement sentencia = ci.abrirConexion().prepareStatement(eliminarUsuario);
			sentencia.setString(1, usuarioAEliminar.getDniUsuario());
			
			sentencia.executeUpdate();
		}catch(SQLException e) {
			
			System.out.println("Error al eliminar un usuario.");
			
		}finally {
			
			ci.cerrarConexion();
		}
		
		Inicio.listaUsuarios.remove(usuarioAEliminar);
		
		
		
	}

	@Override
	public void bajaClub() {
		consulta.cargaBDClub();
		ClubDto clubAEliminar = new ClubDto();
		
		String nombreAPedir;
		System.out.println("Introduzca el nombre del club a borrar: ");
		nombreAPedir=Inicio.sc.next();
		
		for(ClubDto club : Inicio.listaClubes) {
			
			if(club.getNombreClub().equals(nombreAPedir)) {
				
				clubAEliminar = club;
				break;
			}
		}
		
		try {
			String eliminarClub = "DELETE FROM sus.club WHERE nombre_club = ?";
			
			PreparedStatement sentencia = ci.abrirConexion().prepareStatement(eliminarClub);
			
			sentencia.setString(1, clubAEliminar.getNombreClub());
			
			sentencia.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("Error al eliminar un club.");
		}finally {
			ci.cerrarConexion();
		}
		
		Inicio.listaClubes.remove(clubAEliminar);
		
	}

	@Override
	public void modificarUsuario() {
		
		MenuInterfaz mi = new MenuImplementacion();
		byte opcionCampo;
		String dniAPedir;
		consulta.cargaBDUsuario();
		
		UsuarioDto usuarioAModificar = new UsuarioDto();
		
		System.out.println("Introduce el dni del usuario que desea modificar: ");
		dniAPedir=Inicio.sc.next();
		
		
		
		for(UsuarioDto usuario : Inicio.listaUsuarios) {
			
			if(usuario.getDniUsuario().equals(dniAPedir)) {
				
				opcionCampo=mi.mostrarMenuYSeleccionCampos();
				
				try {
					Connection conexion = ci.abrirConexion();
					Statement sentencia = conexion.createStatement();
					ResultSet resultado = ci.abrirConexion().createStatement().executeQuery("SELECT * FROM sus.usuario WHERE dni_usuario = ?");
					PreparedStatement parmSel;
				    
					
					switch(opcionCampo) {
						
					case 1:
						System.out.println("Se modificara el nombre del usuario.");
						String nombreMod;
						System.out.println("Introduzca el nombre: ");
						nombreMod = Inicio.sc.next();
						String queryModN ="UPDATE sus.usuario SET nombre_usu = ? WHERE dni_usuario = ?";
						PreparedStatement sentenciaN = ci.abrirConexion().prepareStatement(queryModN);
						sentenciaN.setString(1, nombreMod);
						sentenciaN.setString(2, usuario.getDniUsuario());
						
						sentenciaN.executeUpdate();
						usuario.setNombreUsuario(nombreMod);
						usuarioAModificar = usuario;
						break;
						
					case 2:
						System.out.println("Se modificaran los apellidos del usuario.");
						String apellido1;
						String apellido2;
						String apellidosMod;
						System.out.println("Introduce el primer apellido a modificar: ");
						apellido1 = Inicio.sc.next();
						System.out.println("Introduce el segundo apellido a modificar: ");
						apellido2 = Inicio.sc.next();
						apellidosMod=apellido1.concat(" ").concat(apellido2);
						String queryModA = "UPDATE sus.usuario SET apellidos_usu = ? WHERE dni_usuario = ?";
						PreparedStatement sentenciaA = ci.abrirConexion().prepareStatement(queryModA);
						sentenciaA.setString(1, apellidosMod);
						sentenciaA.setString(2,usuario.getDniUsuario());
						
						sentenciaA.executeUpdate();
						usuario.setApellidosUsuario(apellidosMod);
						usuarioAModificar = usuario;
						break;
						
					case 3:
						System.out.println("Se modificara el email del usuario.");
						String emailMod;
						System.out.println("Introduce el email a modificar: ");
						emailMod = Inicio.sc.next();
						
						String queryModE = "UPDATE sus.usuario SET email_usu = ? WHERE dni_usuario = ?";
						PreparedStatement sentenciaE = ci.abrirConexion().prepareStatement(queryModE);
						
						sentenciaE.setString(1,emailMod);
						sentenciaE.setString(2,usuario.getDniUsuario());
						
						sentenciaE.executeUpdate();
						usuario.setEmailUsuario(emailMod);
						
						usuarioAModificar = usuario;
						break;
						
					default:
						System.out.println("Opcion introducida no valida.");
						break;
						
								
					}
				}catch(SQLException e) {
					System.out.println("Error al modificar un campo de usuarios");
				}finally {
					ci.cerrarConexion();
				}
			}
		}
		
		
		
	}
	
	
	
	

}
