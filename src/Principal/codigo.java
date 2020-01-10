package Principal;


public class codigo {
    
    /**
     * obtiene el nombre de la carrera y regresa el codigo de ella
     * @param Carrera
     * @return 
     */
    public String ObtenerCodigoCarrera(String Carrera){
        String Codigo;
        switch(Carrera.toUpperCase()){//si la cadena entra en minusculas los pasa a mayusculas
            case "ENFERMERIA":
                Codigo = "03";
                break;
            case "ENFERMERÍA":
                Codigo = "03";
            break;
            case "ODONTOLOGIA":
                Codigo = "13";
                break;
            case "ODONTOLOGÍA":
                Codigo = "13";
            break;
            case "MEDICINA":
                Codigo = "14";
                break;
            
            default:
                Codigo = "00";
                break;                
        }
        return Codigo;
    }
    
    /**
     * Recibe el parametro semestre en String
     * regresa el codigo del semestre
     * @param Semestre
     * @return 
     */
    public String ObtenerCodigoSemestre(String Semestre){
        String Codigo;
        switch(Semestre.toUpperCase()){
            case "PRIMERO":
                Codigo = "01";
                break;
            case "SEGUNDO":
                Codigo = "02";
                break;
            case "TERCERO":
                Codigo = "03";
                break;
            case "CUARTO":
                Codigo = "04";
                break;
            case "QUINTO":
                Codigo = "05";
                break;
            case "SEXTO":
                Codigo = "06";
                break;
            case "SEPTIMO":
                Codigo = "07";
                break;
            case "SÉPTIMO":
                Codigo = "07";
                break;
            case "OCTAVO":
                Codigo = "08";
                break;
            case "NOVENO":
                Codigo = "09";
                break;
            case "DECIMO":
                Codigo ="10";
                break;
            case "DÉCIMO":
                Codigo ="10";
            break;
            default:
                Codigo = "00";
                break;
        }
        return Codigo;
    }
}
