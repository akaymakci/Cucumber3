package ApachePOI;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _10_Tasks_2 {
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

        int cnt=0;
        int crp=1;
        int y=0;

        Row row = sheet.createRow(0);
//        Cell cell = row.createCell(0);
//
//        for (int i = 0; i < 11; i++) {
//            row=sheet.createRow(i);
//        }

        for (int i = 0; i <=10; i++) {
            if (crp>10)
                break;
            for (int j = 0; j < 11; j++) {
                row = sheet.getRow(j);
                if (null==row)
                    row=sheet.createRow(j); // cnt sabit kalacak
                if (j<10){
                    row.createCell(y).setCellValue(crp); // 0 1 2 3 4 degerleri 5er artacak.
                    row.createCell(y+1).setCellValue("x");
                    row.createCell(y+2).setCellValue(j+1);
                    row.createCell(y+3).setCellValue("=");
                    row.createCell(y+4).setCellValue(crp*(j+1));
                }

            }
            crp+=1;
//            cnt+=11;
            y+=6;
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
