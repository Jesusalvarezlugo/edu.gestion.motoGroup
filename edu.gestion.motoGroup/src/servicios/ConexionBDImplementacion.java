package servicios;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controladores.Inicio;




public class ConexionBDImplementacion implements ConexionBDInterfaz {

	// URL de conexión a la base de datos
	private static final String URL = "jdbc:postgresql://localhost:5432/gestionmotos"; 

	private static final String USER = "postgres";

	private static final String PASSWORD = "altair006";
	@Override
	public void abrirConexion() {
		
		try {
			// Cargar el controlador JDBC de PostgreSQL
			//Connection conexion = null;
			
            Class.forName("org.postgresql.Driver");

            

            // Conectar a la base de datos

            Inicio.conexion = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Conexión exitosa a la base de datos.");

            

            /*// Crear la consulta SQL

            String consultaSQL = "SELECT * FROM tablaprueba";

            PreparedStatement preparedStatement = Inicio.conexion.prepareStatement(consultaSQL);

            

            // Ejecutar la consulta

            ResultSet resultado = preparedStatement.executeQuery();

            

            // Recorrer los resultados

            while (resultado.next()) {

                // Obtener datos de las columnas (ejemplo con columnas "id" y "nombre")

                int id = resultado.getInt("id");

                String nombre = resultado.getString("nombre");

                System.out.println("ID: " + id + ", Nombre: " + nombre);

            }*/

            

            // Cerrar recursos

            //resultado.close();

           // preparedStatement.close(); 
		}catch(SQLException sqle) {
			System.out.println("Error al conectar con la base de datos");
		}catch (ClassNotFoundException e) {

            System.out.println("Error al cargar el controlador de PostgreSQL.");

            e.printStackTrace();
		}
		
	}

	@Override
	public void cerrarConexion() {
		
		 if (Inicio.conexion != null) {

             try {

                 Inicio.conexion.close();

                 System.out.println("Conexión cerrada.");

             } catch (SQLException e) {

                 e.printStackTrace();

             }

         }
		
	}

}
