package BD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Usuario {

    //conexión a  la base de datos;
    BD bd = new BD();

    public int id;
    public String Nombre;
    public String Apellido;
    public String Usuario;
    public String Password;
    public int tipo;

    // Constructores con parámetros
    public Usuario(String Nombre, String Apellido, String Usuario, String Password, int tipo) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Usuario = Usuario;
        this.Password = Password;
        this.tipo = tipo;
    }

    public Usuario(int id, String Nombre, String Apellido, String Usuario, String Password) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Usuario = Usuario;
        this.Password = Password;
        this.id = id;
    }

    public Usuario(String Usuario, String Password) {
        this.Usuario = Usuario;
        this.Password = Password;
    }

    //constructor vacío
    public Usuario() {
    }

    /**
     * toma como parametros el Usuario y Password para validar si existe en la
     * base de datos
     *
     * @return a[2] dos datos necesarios tipo de usuario y el id
     * @throws SQLException
     */
    public int[] loginUsuario() throws SQLException {
        int a[] = new int[2]; // los parametros a retornar
        try {

            Statement stmnt;
            stmnt = bd.conecta().createStatement();
            //procediineto almacenado que se encarga de la busqueda de los datos
            String sql = "call spLoginUsuario('" + this.Usuario + "','" + this.Password + "');";
            ResultSet rs = stmnt.executeQuery(sql);
            rs.next();
            //se guardan los datos obtenidos
            a[0] = rs.getInt("tipo");
            a[1] = rs.getInt("idusuario");

        } catch (SQLException e) {
            // Posible error no guarda nada y los valores son 0
        }
        //cerrar la conexion 
        bd.close();
        return a;//retorna el tipo de usuario a=0 si no hay un usuario
    }

    /**
     * los parametros ya los debe tener la clase recoje los atributos de la
     * clase e invoca el procedimiento almacenado de realizar la inserción
     */
    public void InsertarUsuario() {
        // la funcion tiene valores de entrada que son el nombre,apellidos,nombreusuario,contraseña
        try {
            Statement stmnt = null;
            stmnt = bd.conecta().createStatement();
            //quiery del procedimiento almacenado
            try (PreparedStatement st = bd.conecta().prepareStatement("call spCrearRegistroUsuario('" + this.Nombre + "','" + this.Apellido + "','" + this.Usuario + "','" + this.Password + "'," + this.tipo + ");")) {
                //el procedimiento almacenado manda una respuesta si la insersión fue exitosa o erronea
                ResultSet rs = st.executeQuery();
                rs.next();
                //obtenemos el mensaje y se la muestra al cliente
                JOptionPane.showMessageDialog(null, rs.getString(1));
            }
        } catch (SQLException e) {
            //caso de error al invocar el procedimiento almacenado
            System.out.println(e.getMessage());
        }
        bd.close();
    }

    /**
     * Obtiene los atributos de la clase e invoca al procedimiento almacenado
     * encargado de modificar los datos
     */
    public void ModificarUsuario() {
        // la funcion tiene valores de entrada que son el nombre,apellidos,nombreusuario,contraseña
        try {
            Statement stmnt = null;
            stmnt = bd.conecta().createStatement();
            try ( // query del procedimiento almacenado
                    PreparedStatement st = bd.conecta().prepareStatement("call spActualizarRegistroUsuario(" + this.id + ",'" + this.Nombre + "','" + this.Apellido + "','" + this.Usuario + "','" + this.Password + "');")) {
                // ejecuta el query
                ResultSet rs = st.executeQuery();
                rs.next();
                // recibe el mensaje y se los muestra al cliente
                JOptionPane.showMessageDialog(null, rs.getString(1));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        bd.close();
    }

    /**
     * Recibe el username e invoca al procedimiento almacenado encargado de
     * eliminar al usuario -> manda el id para saber que usuario se desea
     * eliminar
     *
     * @param NombreUsuario
     */
    public void EliminarUsuario(String NombreUsuario){
        // la funcion tiene valores de entrada que son el nombre,apellidos,nombreusuario,contraseña
        try {
            Statement stmnt = null;
            stmnt = bd.conecta().createStatement();
            try ( //query para llamar al procedimiento almacenado
                    PreparedStatement st = bd.conecta().prepareStatement("call spEliminarRegistroUsuario('" + NombreUsuario + "');")) {
                // ejecuta el query y este a su vez regresa una cadena con mensaje de exito o fallo
                ResultSet rs = st.executeQuery();
                rs.next();
                //guarda e imprime el mensaje
                JOptionPane.showMessageDialog(null, rs.getString(1));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        bd.close();
    }

    /**
     * Busca en la base de datos información del usuario con el ID proporcionado
     * la información recibida la guarda en los atributos de la clase
     *
     */
    public void MostrarUsuarioId() {
        int a = 0;//en la variable a se va a guardar el tipo de usuario
        try {
            Statement stmnt;
            stmnt = bd.conecta().createStatement();
            // query del procedimiento almacenado
            String sql = "call spMostrarUsuarioId(" + this.id + ");";
            ResultSet rs = stmnt.executeQuery(sql);
            //realiza la lectura
            rs.next();
            this.Nombre = rs.getString("nombre");
            this.Apellido = rs.getString("apellido");
            this.Usuario = rs.getString("nombreUsuario");
            this.Password = rs.getString("contraseña");
            this.tipo = rs.getInt("tipo");
            //MenuPrincipal.id=rs.getInt("idusuario");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        bd.close();
    }

}
