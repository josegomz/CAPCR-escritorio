package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BD {
    private final String url = "jdbc:mysql://localhost/clinica?useUnicode=true&useJDBCCompliantTimezoneShift=true&serverTimezone=UTC";
    private final String user = "root";
    private final String password = "josegomz";
    Connection conn = null;
    
    /**
     * conecta a la base de datos y regresa la conexión
     * @return 
     */
    public Connection conecta() {  
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Error de conexión: \n"+e.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: "+ex.getMessage());
        }
        return conn;
    }
    /**
     * cierra la conexion a la base de datos 
     */
    public void close(){
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la base de datos: \n"+ex.getMessage());
            }
        }
    }    
}
