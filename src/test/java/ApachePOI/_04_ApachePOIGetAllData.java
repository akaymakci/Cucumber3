package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

public class _04_ApachePOIGetAllData {
    public static void main(String[] args) throws IOException {

        String path="src/test/java/ApachePOI/resource/ApacheExcel2.xlsx";

        FileInputStream inputStream=new FileInputStream(path);
        Workbook workbook= WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheet("Sheet1");

        // calisma sayfasındaki toplam satır sayısını veriyor.
        int satirSayisi=sheet.getPhysicalNumberOfRows();

        for (int i = 0; i < satirSayisi; i++) {

            Row satir= sheet.getRow(i); // i.Satır alındı
            // bu satırdaki toplam hücre sayısı alındı.
            int hucreSayisi = satir.getPhysicalNumberOfCells();

            for (int j = 0; j < hucreSayisi; j++) { // i.satırdaki hucre sayısı kadar dönecek
                Cell hucre = satir.getCell(j);    // bu satırdaki sıradaki hücreyi aldım.
                System.out.print(hucre+" ");
            }

            System.out.println();
        }

    }
}
