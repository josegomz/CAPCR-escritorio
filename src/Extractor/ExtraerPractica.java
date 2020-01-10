package Extractor;

import BD.Practica;
import Principal.codigo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExtraerPractica {

    //variables de datos fijos 
    String Semestre, Carrera;
    int Hojas;
    //regresa el codigo del semestre y la carrera
    codigo valida = new codigo();

    /**
     *
     * @param ruta
     */
    public void extraer(String ruta) {

        ruta = ruta.replace("\\", "/"); //Convierto todos los \ en / para congruir en direcciones.

        File Fil = new File(ruta);
        FileInputStream file;
        try {
            file = new FileInputStream(Fil); //Se crea archivo FileInput para la lectura
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            Hojas = workbook.getNumberOfSheets(); //Obtenemos el número de hojas que contiene el documento
            /*recorre hoja por hoja*/
            for (int i = 0; i < Hojas; i++) {
                XSSFSheet sheet = workbook.getSheetAt(i); //Seleccionamos la hoja que vamos a recorrer.
                //datos generales por hojas
                Semestre = valida.ObtenerCodigoSemestre(sheet.getRow(8).getCell(3).getStringCellValue().toUpperCase().trim());
                Carrera = valida.ObtenerCodigoCarrera(sheet.getRow(10).getCell(3).getStringCellValue().toUpperCase().trim());
                for (int j = 14; j <= sheet.getLastRowNum(); j++) {//Recorre todas las filas.
                    Practica practica = new Practica("", "", Carrera, Semestre);
                    try {
                        practica.setCodigo(Integer.toString((int) sheet.getRow(j).getCell(2).getNumericCellValue()));
                    } catch (Exception e) {
                        practica.setCodigo(sheet.getRow(j).getCell(2).getStringCellValue().trim());
                    }
                    practica.setNombre(sheet.getRow(j).getCell(3).getStringCellValue().trim().toUpperCase());
                    if (practica.getCodigo().trim().length() == 4) {
                        practica.AgregarListaPractica();
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Error: File not found \n" + ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
