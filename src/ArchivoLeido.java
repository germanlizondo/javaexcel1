import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.*;
import jxl.write.Number;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ArchivoLeido {

    private File archivo =  new File("Notes_2DAM2DAW_M05UF3_2018_19.xls");
    private File archivoEscrito = new File("M06UF3_NotesExamenFinal.xls");
    private ArrayList<Alumne> alumnes = new ArrayList<Alumne>();


    public void leerArchivo() {

        int primeraFila = 12;
        int ultimaFila = 49;

        try {
            Workbook wrk1 =  Workbook.getWorkbook(this.archivo);
            Sheet sheet1 = wrk1.getSheet(0);

            Cell nom = null;
            Cell nota = null;
            Alumne alumne = null;

            for(int x = primeraFila; x < ultimaFila;x++){

                nom =  sheet1.getCell(0, x);
                nota =  sheet1.getCell(3, x);

                String notaNum = nota.getContents().replace(',','.');

                if(nota.getContents().equals("")){

                }else if (nom.getContents().equals("")){

                }else if (nom.getContents().equals("DAW2")){

                }  else{

                    alumne = new Alumne(Float.parseFloat(notaNum),nom.getContents());
                    alumnes.add(alumne);


                }


            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("No se ha encontrado el fichero");
        }

    }

    public void escribirArchivo(){

        try{
            WritableWorkbook writableWorkbook = Workbook.createWorkbook(this.archivoEscrito);
            WritableSheet writableSheet = writableWorkbook.createSheet("Sheet1", 0);

            WritableFont boldFont = new WritableFont(WritableFont.ARIAL, 12, WritableFont.BOLD, false);
            WritableCellFormat formatoBold = new WritableCellFormat(boldFont);
            formatoBold.setAlignment(Alignment.CENTRE);
            writableSheet.setColumnView(0,30);
            writableSheet.setColumnView(2,10);

            int x = 0;


            for (Alumne a: this.alumnes) {

                Label label = new Label(0, x, a.getNom());
                Number num = new Number(1, x,a.getNota(),formatoBold);
                Label estado = new Label(2, x, a.getEstado());
                writableSheet.addCell(label);
                writableSheet.addCell(num);
                writableSheet.addCell(estado);

                x++;
            }


            writableWorkbook.write();
            writableWorkbook.close();
        }catch (Exception e){
            System.out.println("No se puede escribir el archivo");
        }


    }


}
