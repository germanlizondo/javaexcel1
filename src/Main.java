import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import java.io.File;

public class Main {

    public static void main(String[] args) {

        ArchivoLeido archivoLeido = new ArchivoLeido();
        archivoLeido.leerArchivo();
        archivoLeido.escribirArchivo();
    }
}
