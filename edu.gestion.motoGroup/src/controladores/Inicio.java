 package controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Inicio {

    

    // URL de conexión a la base de datos

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres"; 

    private static final String USER = "postgres";

    private static final String PASSWORD = "altair006";



    public static void main(String[] args) {

        Connection conexion = null;

        

        try {

            // Cargar el controlador JDBC de PostgreSQL

            Class.forName("org.postgresql.Driver");

            

            // Conectar a la base de datos

            conexion = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Conexión exitosa a la base de datos.");

            

            // Crear la consulta SQL

            String consultaSQL = "SELECT * FROM tablaprueba";

            PreparedStatement preparedStatement = conexion.prepareStatement(consultaSQL);

            

            // Ejecutar la consulta

            ResultSet resultado = preparedStatement.executeQuery();

            

            // Recorrer los resultados

            while (resultado.next()) {

                // Obtener datos de las columnas (ejemplo con columnas "id" y "nombre")

                int id = resultado.getInt("id");

                String nombre = resultado.getString("nombre");

                System.out.println("ID: " + id + ", Nombre: " + nombre);

            }

            

            // Cerrar recursos

            resultado.close();

            preparedStatement.close();

        } catch (ClassNotFoundException e) {

            System.out.println("Error al cargar el controlador de PostgreSQL.");

            e.printStackTrace();

        } catch (SQLException e) {

            System.out.println("Error al conectar o ejecutar la consulta.");

            e.printStackTrace();

        } finally {

            // Cerrar la conexión

            if (conexion != null) {

                try {

                    conexion.close();

                    System.out.println("Conexión cerrada.");

                } catch (SQLException e) {

                    e.printStackTrace();

                }

            }

        }

    }

}







//CON JAVAX.SQL

/*package controladores;
import javax.sql.DataSource;
import org.postgresql.ds.PGSimpleDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Inicio {

    public static void main(String[] args) {
        DataSource dataSource = setupDataSource();

        try (Connection connection = dataSource.getConnection()) {
            // Realiza tus operaciones con la base de datos aquí
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static DataSource setupDataSource() {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setServerName("localhost"); // Cambia esto si tu DB no está en localhost
        dataSource.setPortNumber(5432); // Puerto por defecto de PostgreSQL
        dataSource.setDatabaseName("postgres");
        dataSource.setUser("postgres");
        dataSource.setPassword("altair006");

        return dataSource;
    }
}*/

