package ApachePOI;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class _07_Soru {
    /*
      Bir önceki soruda kullanıcıdan bu sefer sütun numarası
      isteyiniz ve o sütundaki bütün bilgileri yazdırınız
     */
    public static void main(String[] args) {
        System.out.print("Istenen sütun=");
        Scanner oku= new Scanner(System.in);
        int sutun= oku.nextInt();

        String donenSonuc=bul(sutun);
        if(!donenSonuc.isEmpty()) {
            System.out.println("donenSonuc = ");
            System.out.println(donenSonuc);
        }
    }

    public static String bul(int sutun)
    {
        String donecek="";

        String path="src/test/java/ApachePOI/resource/LoginData.xlsx";

        Workbook workbook=null;
        try {
            FileInputStream inputStream = new FileInputStream(path);
            workbook= WorkbookFactory.create(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Sheet sheet= workbook.getSheetAt(0);

        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++)
            if (sutun < sheet.getRow(i).getPhysicalNumberOfCells())
               donecek+=sheet.getRow(i).getCell(sutun)+"\n";

        return donecek;
    }

}
