package JDBC.Gun2;

import JDBC.JDBCParent;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class _04_Soru extends JDBCParent {
    //Soru :  Actor tablsosundaki tüm verileri yeni excel e yazdırınız.

    @Test
    public void test2() throws SQLException, IOException {
        ResultSet rs = statement.executeQuery("select * from actor");
        ResultSetMetaData rsmd = rs.getMetaData();

        int columnCount = rsmd.getColumnCount();
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Actor");
        Row newRow = sheet.createRow(0);
        for (int i = 0; i < columnCount; i++) {
            Cell newCell = newRow.createCell(i);
            newCell.setCellValue(rsmd.getColumnName(i + 1));
        }
        int sayac = 1;

        while (rs.next()) {
            newRow = sheet.createRow(sayac);
            for (int i = 0; i < rsmd.getColumnCount(); i++) {
                Cell newCell = newRow.createCell(i);
                newCell.setCellValue(rs.getString(i + 1));
            }
            sayac++;
        }

        String yeniExcelPath = "src/test/java/ApachePOI/resource/actorDatabase.xlsx";
        FileOutputStream outputStream = new FileOutputStream(yeniExcelPath);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
        System.out.println("İşlem tamamlandı");
    }


}
