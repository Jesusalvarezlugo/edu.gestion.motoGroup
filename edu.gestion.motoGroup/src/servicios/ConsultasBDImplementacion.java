package servicios;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controladores.Inicio;
import dtos.ClubDto;
import dtos.UsuarioDto;

public class ConsultasBDImplementacion implements ConsultasBDInterfaz {

	ConexionBDInterfaz ci = new ConexionBDImplementacion();
	@Override
	public void cargaBDUsuario() {
		
		
		Connection conexion = null;
		Statement sentencia=null;
		try {
			
			
			conexion = ci.abrirConexion();
			
			sentencia = conexion.createStatement();
			ResultSet resultado = sentencia.executeQuery("SELECT * FROM usuario");
			
			while(resultado.next()) {
				UsuarioDto usuario = new UsuarioDto();
				
				usuario.setIdUsuario(resultado.getLong(0));
				usuario.setNombreUsuario(resultado.getString(1));
				usuario.setApellidosUsuario(resultado.getString(2));
				usuario.setDniUsuario(resultado.getString(3));
				usuario.setEmailUsuario(resultado.getString(4));
				
				Inicio.listaUsuarios.add(usuario);
			}
			
			
			
		}catch(SQLException eU) {
			System.out.println("Error al hacer la carga inicial de usuarios"+eU.getMessage());
		}finally {
			
			ci.cerrarConexion();
		}
		
		
	}

	@Override
	public void cargaBDClub() {
		Connection conexion = null;
		Statement sentencia = null;
		
		try {
			
			conexion=ci.abrirConexion();
			sentencia=conexion.createStatement();
			
			ResultSet resultado = sentencia.executeQuery("SELECT * FROM club");
			
			while(resultado.next()) {
				
				ClubDto club = new ClubDto();
				
				club.setIdClub(resultado.getLong(0));
				club.setNombreClub(resultado.getString(1));
				club.setMiembrosClub(resultado.getInt(2));
				club.setSede(resultado.getString(3));
				
				Inicio.listaClubes.add(club);
				
			}
			
		}catch(SQLException eC) {
			System.out.println("Error al hacer la carga inicial de clubes"+eC.getMessage());
		}finally {
			ci.cerrarConexion();
		}
		
		
	}

}
