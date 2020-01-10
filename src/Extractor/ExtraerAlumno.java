package Extractor;

import BD.Alumno;
import Principal.codigo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExtraerAlumno{
    String ruta;
    
    /*variables que se obtienen del archivo excel*/
    String Grupo;
    String Semestre;
    String Carrera;
    
    /*contador de hojas del archivo*/
    int Hojas;
    
    codigo valida=new codigo();
    //MÉTODO QUE EXTRAE
    
    public void extraer(String ruta){
        
        ruta = ruta.replace("\\", "/");
        File Fil = new File(ruta);       
        try {
            FileInputStream file = new FileInputStream(Fil);
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            Hojas = workbook.getNumberOfSheets();
            
            /*recorrer hoja por hoja*/
            for (int i =0; i <Hojas; i++) {
                XSSFSheet sheet = workbook.getSheetAt(i); //Selecciona la hoja actual
                
                /*valores fijos por cada hoja*/
                Grupo = sheet.getRow(6).getCell(3).getStringCellValue(); 
                Semestre = valida.ObtenerCodigoSemestre(sheet.getRow(8).getCell(3).getStringCellValue().toUpperCase().trim());
                Carrera = valida.ObtenerCodigoCarrera(sheet.getRow(10).getCell(3).getStringCellValue().toUpperCase().trim());  
                
                //recorre las filas existentes de la tabla
                for (int j = 14; j <=sheet.getLastRowNum(); j++) {
                    Alumno alumno= new Alumno("","",Grupo,Semestre,Carrera);//por cada alumno se le agregan valores fijos
                    try{
                        alumno.setMatricula(Integer.toString((int) sheet.getRow(j).getCell(2).getNumericCellValue()));
                    }
                    catch(Exception e){
                        alumno.setMatricula( sheet.getRow(j).getCell(2).getStringCellValue().trim());
                    }
                    alumno.setNombre( sheet.getRow(j).getCell(3).getStringCellValue().trim());
                    if(alumno.getMatricula().length()==10){
                        alumno.AgregarListaAlumno();
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    } 
}

