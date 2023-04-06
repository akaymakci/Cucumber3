package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _08_WriteInTheExcel {
    public static void main(String[] args) throws IOException {
        // Var olan bir EXCEL yazma işlemi
        String path="src/test/java/ApachePOI/resource/WriteInTheExcelFile.xlsx";
        FileInputStream inputStream=new FileInputStream(path); // okuma modunda açıldı
        Workbook workbook= WorkbookFactory.create(inputStream);
        Sheet sheet=workbook.getSheet("Sheet1");

        // HAFIZADA oluşturma ve yazma işlemelri yapılıyor
        Row yeniSatir= sheet.createRow(0); // satır oluşturuldu 0.yerde
        Cell yeniHucre= yeniSatir.createCell(0); // yeni satırda ilk hucre oluşturuldu
        yeniHucre.setCellValue("Merhaba Dünya"); // bilgi yazıldı.
        int b=0;
        for (int a = 0; a<=2; a++ ) {
            for (int i = 1; i < 10; i++) {
                yeniSatir.createCell(i+b).setCellValue(i);
            }
            b+=12;
        }

        // sıra kaydetmeye geldi, bütün bilgiler hafızada buraya kadar, her şey WORKBOOK da
        inputStream.close(); // okuma modunu kapattım, çünkü yazma modunda açmam gerekiyor


        // Yazma işlemini YAZMA modunda açıp öyle yapacağız.
        FileOutputStream outputStream=new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();  // hafıza boşaltıldı
        outputStream.close();
        System.out.println("işlem tamamlandı");

        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
            String donecek = "";
            Row row=sheet.getRow(i);
            Cell cell=row.getCell(0);
            for (int j = 0; j < row.getPhysicalNumberOfCells(); j++)
                donecek +=  row.getCell(j)+" ";
            System.out.println(donecek.replaceAll(".0",""));
        }
        inputStream.close();
    }
}
