package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class _06_Soru {
    /**
     Bir önceki yapılan soruda, Kullanıcıya 1.sütundaki tüm değer bir liste halinde kullanıcıya
     yanlarında bi numara olarak sunalım. Kullanıcı hangi numararyı girerese o satırın
     yanındaki tüm bilgiler gösterilsin.
     Username için 1
     Password için 2
     ....
     ...
     giririniz = 2
     */

    public static void main(String[] args) {

        System.out.print("Girilen Satir Numarasi=");
        Scanner oku= new Scanner(System.in);
        int arananSatir= oku.nextInt();

        String donenSonuc=bul(arananSatir);
        if (!donenSonuc.isEmpty())
            System.out.println("donenSonuc = " + donenSonuc);
    }

    public static String bul(int arananSatir)
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

        Sheet sheet= workbook.getSheetAt(0); // .getSheet("Sheet2");

        int rowFilled = sheet.getPhysicalNumberOfRows();
        Row row=sheet.getRow(arananSatir);

        if (rowFilled>arananSatir) {
                    for (int j = 0; j < row.getPhysicalNumberOfCells(); j++)
                        donecek += row.getCell(j) + " ";
                }
        else
            System.out.println("böyle bir satir bulunmamaktadir");

        return donecek;
    }
}
