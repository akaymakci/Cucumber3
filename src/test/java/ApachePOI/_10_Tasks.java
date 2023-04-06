package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class _10_Tasks {
    /**  Soru 1:
     *  Çarpım tablosunu excele yazdırınız.
     *  1 x 1 = 1 şeklinde işaretleri de yazdırınız.
     *  sıfırdan excel oluşturarak.
     *  her bir onluktan sonra 1 satır boşluk bırakarak alt alata
     */

    /**  Soru 2:
     *  Çarpım tablosunu excele yazdırınız.
     *  1 x 1 = 1 şeklinde işaretleri de yazdırınız.
     *  sıfırdan excel oluşturarak.
     *  her bir onluktan sonra 1 kolon boşluk bırakarak yan yana
     */

    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sheet1");

//        Row row = sheet.createRow(0);
//        Cell cell = row.createCell(0);
//        cell.setCellValue("Carpim Tablosu");
        int cnt=0;
        int crp=1;

        for (int i = 0; i <=10; i++) {
            if (crp>10)
                break;
            for (int j = 0; j < 11; j++) {
                Row row=sheet.createRow(cnt+j);
                if (j<10){

                    row.createCell(0).setCellValue(crp);
                    row.createCell(1).setCellValue("x");
                    row.createCell(2).setCellValue(j+1);
                    row.createCell(3).setCellValue("=");
                    row.createCell(4).setCellValue(crp*(j+1));
                }

            }
            crp+=1;
            cnt+=11;

        }

        String path = "src/test/java/ApachePOI/resource/Deneme2.xlsx";
        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
        System.out.println("islem tamamlandi");

        FileInputStream inputStream = new FileInputStream(path);
        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
            String donecek = "";
            Row r=sheet.getRow(i);
            Cell c=r.getCell(0);
            for (int j = 0; j < r.getPhysicalNumberOfCells(); j++)
                if(r.getCell(j) != null)
                    donecek +=  r.getCell(j)+" ";
            System.out.println(donecek.replace(".0",""));
//                System.out.println(donecek);
        }
        inputStream.close();
    }
}
