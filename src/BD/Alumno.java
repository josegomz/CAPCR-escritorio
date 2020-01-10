package BD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Clase alumno métodos basicos CRUD para la base de datos
 */
public class Alumno {

    /*conectarse a la base de datos*/
    BD bd = new BD();
    //atributos de la clase
    String Matricula;
    String Nombre;
    String Grupo;
    String Semestre;
    String Carrera;

    /*constructor con parametros*/
    public Alumno(String Matricula, String Nombre, String Grupo, String Semestre, String Carrera) {
        this.Matricula = Matricula;
        this.Nombre = Nombre;
        this.Grupo = Grupo;
        this.Semestre = Semestre;
        this.Carrera = Carrera;
    }

    public Alumno(String Matricula) {
        this.Matricula = Matricula;
    }
    /*setters y getters*/

    public Alumno() {
    }

    public BD getBd() {
        return bd;
    }

    public void setBd(BD bd) {
        this.bd = bd;
    }

    public String getMatricula() {
        return Matricula;
    }

    public void setMatricula(String Matricula) {
        this.Matricula = Matricula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getGrupo() {
        return Grupo;
    }

    public void setGrupo(String Grupo) {
        this.Grupo = Grupo;
    }

    public String getSemestre() {
        return Semestre;
    }

    public void setSemestre(String Semestre) {
        this.Semestre = Semestre;
    }

    public String getCarrera() {
        return Carrera;
    }

    public void setCarrera(String Carrera) {
        this.Carrera = Carrera;
    }
    

    public void AgregarAlumno() {
        try {
            try (PreparedStatement st = bd.conecta().prepareStatement("call spCrearRegistroAlumno('" + Matricula + "','" + Nombre + "','" + Grupo + "','" + Semestre + "','" + Carrera + "');")) {
                //Despues de llamar al query se obtiene el mensaje
                ResultSet rs = st.executeQuery();
                rs.next();
                String mensaje = rs.getString(1);
                //Muestra el mensaje
                JOptionPane.showMessageDialog(null, mensaje);
            }
            bd.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Similar al metodo de agregar lista alumno no regresa el mensaje para asi
     * poder cargar alumnos en masa
     */
    public void AgregarListaAlumno() {
        try {
            try (PreparedStatement st = bd.conecta().prepareStatement("call spCrearRegistroAlumno('" + Matricula + "','" + Nombre + "','" + Grupo + "','" + Semestre + "','" + Carrera + "');")) {
                ResultSet rs = st.executeQuery();
                rs.next();
                JOptionPane.showMessageDialog(null, rs.getString(1));
            }
            bd.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * obtiene los datos del alumno e invoca al procedimiento almacenado
     */
    public void ActualizarAlumno() {
        try {
            try (PreparedStatement st = bd.conecta().prepareStatement("call spActualizarRegistroAlumno('" + Matricula + "','" + Nombre + "','" + Grupo + "','" + Semestre + "','" + Carrera + "');")) {
                // ejecuta el comando SQL y recibe un mensaje
                ResultSet rs = st.executeQuery();
                rs.next();
                // muestra el mensaje en pantalla
                JOptionPane.showMessageDialog(null, rs.getString(1));
            }
            bd.close(); //cierra la conexión a la base de datos
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Elimina lógicamente el alumno con la matricula recibida se pueden
     * recuperar los datos
     */
    public void EliminarAlumno() {
        try {
            try (PreparedStatement st = bd.conecta().prepareStatement("call spEliminarRegistroAlumno('" + Matricula + "');")) {
                ResultSet rs = st.executeQuery();
                rs.next();
                String mensaje = rs.getString(1);
                JOptionPane.showMessageDialog(null, mensaje);
            }
            bd.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * borra definitivamene el alumno del sistema no se pueden recuperar los
     * datos
     */
    public void EliminarAlumnoPermanente() {
        try {
            try (PreparedStatement st = bd.conecta().prepareStatement("call spEliminarRegistroAlumnoDefinitivo('" + Matricula + "');")) {
                ResultSet rs = st.executeQuery();
                rs.next();
                //recibe un mensaje de exito o fallo y lo muestra en pantalla
                JOptionPane.showMessageDialog(null, rs.getString(1));
            }
            bd.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Verifica si el alumno ya exite retorna la matricula de nuevo, si no
     * existe es 0
     * @return -> matricula en valor de entero
     */
    public int BuscarAlumno() {
        int a = 0;
        try {
            try (PreparedStatement st = bd.conecta().prepareStatement("call spMostrarAlumnoMatricula('" + Matricula + "');")) {
                ResultSet rs = st.executeQuery();
                rs.next();
                //obtiene la matricula
                a = Integer.parseInt(rs.getString("matricula"));
            }
            bd.close();
        } catch (SQLException e) {

        }
        /*retornar  matricula*/
        return a;
    }
}
