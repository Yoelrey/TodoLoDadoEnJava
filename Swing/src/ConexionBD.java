// Importar las clases necesarias para la conexión a la base de datos y mostrar mensajes de diálogo
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

// Definir la clase ConexionBD
public class ConexionBD {
    
    // Atributo para almacenar la conexión a la base de datos
    private Connection con;
    
    // Constructor de la clase que recibe los parámetros necesarios para la conexión
    public ConexionBD(String host, String puerto, String user, String pswd) {
        // Llamar al método conectar para establecer la conexión y asignarla al atributo 'con'
        this.con = conectar(host, puerto, user, pswd);
    }
    
    
    
    // Método privado para establecer la conexión a la base de datos
    private Connection conectar(String host, String puerto, String user, String pswd) {
        try {
            // Cargar el controlador JDBC para MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Construir la URL de conexión utilizando los parámetros proporcionados
            String URL = "jdbc:mysql://" + host + ":" + puerto;
            
            // Establecer la conexión utilizando DriverManager y la URL, usuario y contraseña
            Connection con = DriverManager.getConnection(URL, user, pswd);
            
            // Mostrar un mensaje de éxito si la conexión se estableció correctamente
            JOptionPane.showMessageDialog(null, "Conexión establecida");
            
            // Devolver la conexión establecida
            return con;
        } catch (ClassNotFoundException | SQLException e) {
            // Manejar excepciones en caso de que no se pueda establecer la conexión
            JOptionPane.showMessageDialog(null, "Conexión fallida");
            e.printStackTrace();
            System.out.println(e.getMessage());
            
            // Devolver null para indicar que la conexión falló
            return null;
        }
    }
    
    // Método público para obtener la conexión establecida
    public Connection getCon() {
        return this.con;
    }
}
