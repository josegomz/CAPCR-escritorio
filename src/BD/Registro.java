
//me va a dar un dolor de cabeza bien feo

package BD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Clase registro para realizar CRUDS
 */
public class Registro {
    //atribustos de la case
    private String MatriculaAlumno;
    private String codigoPractica;
    private String horaEntrada;
    private String horaSalida;
    private String sustituye;

    /**
     * constructor vacío
     */
    public Registro() {

    }

    /*
     * constuctor con parametros del registro
     */
    public Registro(String MatriculaAlumno, String codigoPractica, String horaEntrada, String horaSalida, String sustituye) {
        this.MatriculaAlumno = MatriculaAlumno;
        String semestre= buscarSemestreAlumno(MatriculaAlumno);
        this.codigoPractica = buscarCodigoPractica(codigoPractica,semestre);
        this.horaEntrada = horaEntrada;
        this.horaSalida= horaSalida;
        this.sustituye = sustituye;
    }

    /*getters y setters*/
    public String getMatriculaAlumno() {
        return MatriculaAlumno;
    }

    public void setMatriculaAlumno(String MatriculaAlumno) {
        this.MatriculaAlumno = MatriculaAlumno;
    }

    public String getCodigoPractica() {
        return codigoPractica;
    }

    public void setCodigoPractica(String codigoPractica) {
        this.codigoPractica = codigoPractica;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getSustituye() {
        return sustituye;
    }

    public void setSustituye(String sustituye) {
        this.sustituye = sustituye;
    }




    /**
     * obtiene los datos de los atributos y los manda al procedimiento almacenado
     */
    public void InsertarRegistro(){       
        try {
            BD bd = new BD();
            PreparedStatement st = bd.conecta().prepareStatement("call spCrearRegistroRegistro('"+MatriculaAlumno + "','" + codigoPractica + "','" +horaEntrada + "','"+horaSalida + "','"+sustituye + "');");
            st.executeUpdate();
            st.close();
            bd.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al insertar el registro: \n"+e.getMessage());
        }
        
    }
    
     /**
      * trae el codigo de la practica con el nombre y el semestre
      * @param nombrePractica
      * @param semestre
      * @return 
      */
    private String buscarCodigoPractica(String codigoPractica, String semestre){
 
        String codigo = null;
        try {
            BD bd = new BD();
            PreparedStatement st = bd.conecta().prepareStatement("call spMostrarCodigoPractica('" + codigoPractica + "','" + semestre + "')");
            ResultSet r = st.executeQuery();
            if (r.next()) {
                codigo = (r.getString(1));
            }
            bd.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return codigo;
    }

    private String buscarSemestreAlumno(String matricula) {
        String codigo = null;
        try {
            BD bd= new BD();
            PreparedStatement st = bd.conecta().prepareStatement("call spMostrarCodigoSemestre(" + matricula + ")");
            ResultSet r = st.executeQuery();
            if (r.next()) {
                codigo = (r.getString(1));
            }
            bd.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return codigo;
    }
    public void CancelarRegistro(String Matricula,String codigo,String horaEntrada,String horaSalida,String comentario) throws SQLException{
        BD bd = new BD();
        try{
            PreparedStatement st = bd.conecta().prepareStatement("call spCancelarRegistro('"+Matricula+"','"+codigo+"','"+horaEntrada+"','"+horaSalida+"','"+comentario+"');");
            //DESPUES DE LLAMAR AL QUEY SE OBTIENE UN MENSAJE
            ResultSet rs= st.executeQuery();
            rs.next();
            String mensaje=rs.getString(1);
            //MOSTRAMOS EL MENSAJE EN UN JOPTIONPANE
            JOptionPane.showMessageDialog(null, mensaje);
            st.close();
            bd.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void RestaurarRegistro(String Matricula,String codigo,String horaEntrada,String horaSalida,String fecha) throws SQLException{
        BD bd = new BD();
        try{
            PreparedStatement st = bd.conecta().prepareStatement("call spRestaurarRegistro('"+Matricula+"','"+codigo+"','"+horaEntrada+"','"+horaSalida+"','"+fecha+"');");
            //DESPUES DE LLAMAR AL QUEY SE OBTIENE UN MENSAJE
            ResultSet rs= st.executeQuery();
            rs.next();
            String mensaje=rs.getString(1);
            //MOSTRAMOS EL MENSAJE EN UN JOPTIONPANE
            JOptionPane.showMessageDialog(null, mensaje);
            st.close();
            bd.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
