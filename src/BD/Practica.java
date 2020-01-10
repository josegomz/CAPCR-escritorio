
package BD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Practica {
    /*conexión a la base de datos*/
    BD bd= new BD();
    
    //atributos de la clase
    private String codigo;
    private String nombre;
    private String carrera;
    private String semestre;
    
    /*constructores*/
    public Practica(String codigo,String nombre,String carrera,String semestre){
        this.codigo=codigo;
        this.nombre=nombre;
        this.carrera=carrera;
        this.semestre=semestre;
    }
    
    /*getters y setters*/
    public Practica(String codigo){
        this.codigo=codigo;
    }

    public Practica() {
        
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }
    
    
    /**
     * obtiene los datos de los atributos y los manda al procedimiento SQL 
     */
    public void AgregarPractica(){
        // la funcion tiene valores de entrada que son el nombre,apellidos,nombreusuario,contraseña
        try{
            try (PreparedStatement st = bd.conecta().prepareStatement("call spCrearRegistroPractica('"+codigo+"','"+nombre+"','"+semestre+"','"+carrera+"');")) {
                ResultSet rs= st.executeQuery();
                rs.next();
                String mensaje=rs.getString(1);
                JOptionPane.showMessageDialog(null,mensaje);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"tuvimos un pequeño error al insertar \n la practica "+nombre);
        }
        bd.close();
    }
    
    /**
     * similar a la funcion de practica 
     * al agregar lsitas de practicas no envia el mensaje que dice "datos insertados"
     */
    public void AgregarListaPractica(){
        // la funcion tiene valores de entrada que son el nombre,apellidos,nombreusuario,contraseña
        try{
            Statement stmnt = bd.conecta().createStatement();
            try (PreparedStatement st = bd.conecta().prepareStatement("call spCrearRegistroPractica('"+codigo+"','"+nombre+"','"+semestre+"','"+carrera+"');")) {
                st.executeUpdate();
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"tuvimos un pequeño error al insertar \n la practica "+nombre);
        }
        bd.close();
    }
    
    /*modifica los datos de la practica*/
    public void ActualizarPractica(){
        // la funcion tiene valores de entrada que son el nombre,apellidos,nombreusuario,contraseña
        try{
            Statement stmnt = bd.conecta().createStatement();
            try (PreparedStatement st = bd.conecta().prepareStatement("call spActualizarRegistroPractica('"+codigo+"','"+nombre+"','"+semestre+"','"+carrera+"');")) {
                st.executeUpdate();
            }   
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"tuvimos un pequeño error al modificar \n la practica "+nombre);
        }
        bd.close();
    }
    
    /**
     * hacer un borrado logico de la tabla y agregar datos a la fecha de eliminación
     */
    public void EliminarPractica(){
        try{
            Statement stmnt= bd.conecta().createStatement();
            try (PreparedStatement st = bd.conecta().prepareStatement("call spEliminarRegistroPractica('"+codigo+"');")) {
                ResultSet rs= st.executeQuery();
                rs.next();
                JOptionPane.showMessageDialog(null, rs.getString(1));
            }
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * hacer un borrado definitivo en la tabla con el comando delete
     */
    public void EliminarPracticaPrermanente(){
        try{
            Statement stmnt= bd.conecta().createStatement();
            try (PreparedStatement st = bd.conecta().prepareStatement("call spEliminarRegistroPracticaDefinitivo('"+codigo+"');")) {
                ResultSet rs= st.executeQuery();
                rs.next();
                /*si la operación fue exitosa o no regresa un mensaje*/
                JOptionPane.showMessageDialog(null, rs.getString(1));
            }
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * busca en la base de datos si exixte una tabla con un numero especifico de codigo
     * @return 
     */
    public int BuscarPractica(){
        int a=0;
        try{
            Statement stmnt=null;
            stmnt = bd.conecta().createStatement();
            try (PreparedStatement st = bd.conecta().prepareStatement("select * from practica where codigo='"+codigo+"';")) {
                ResultSet rs= st.executeQuery();
                rs.next();
                a=Integer.parseInt(rs.getString("codigo"));
            }
        }
        catch(SQLException e){
            
        }
        return a;
    }
}
