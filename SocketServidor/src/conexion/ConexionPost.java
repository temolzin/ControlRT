package conexion;
/**
 * Clase para hacer la conexi�n a la base de datos,
 * y de igual manera est�n los metodos para insertar, eliminar y consultar.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import main.Main;

public class ConexionPost {
    private static ConexionPost instance = null;
    private static String bd = "reportetecnico", user = "postgres", pass = "root";
    private Connection conexion;
    
    private ConexionPost() throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/" + bd;
        try {
            conexion = DriverManager.getConnection(url, user, pass);
            Main.vistaServer.setTextArea("Conexi�n ex�tosa a la base de datos. \n");
        } catch (SQLException ex) {
            ex.printStackTrace();
            Main.vistaServer.setTextArea("Error en la conexi�n a la base de datos \n");
        }
        
    }
    
    /**
     * Uso del patr�n de dise�o Singleton.
     * @return
     * @throws ClassNotFoundException
     */
    public static ConexionPost getInstance() throws ClassNotFoundException {
        if (instance == null)
            instance = new ConexionPost();
        return instance;
    }

    /**
     * M�todo Get que me retorna la conexi�n a la base de datos.
     * @return
     */
    public Connection getConexion() {
        return conexion;
    }    
    
    public boolean ejecutar(String cadena) {
        try {
            Statement sentencia = getConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            sentencia.executeUpdate(cadena);
            sentencia.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }        
        return true;
    }
    
    public ResultSet consultar(String consulta) {
        ResultSet resultado;
        try {
            Statement sentencia = getConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            resultado = sentencia.executeQuery(consulta);
        } catch (SQLException e) {
        	Main.vistaServer.setTextArea("Error al consultar en el m�todo Consultar \n" + e.getMessage());
            e.printStackTrace();
            return null;
        }        
        return resultado;
    }

    @Override
    public void finalize() throws Throwable {
        conexion.close();
        super.finalize();
    }

}
