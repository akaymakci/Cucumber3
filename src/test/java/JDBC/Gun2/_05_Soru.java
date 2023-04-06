package JDBC.Gun2;

import JDBC.JDBCParent;
import jdk.nashorn.internal.scripts.JD;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class _05_Soru extends JDBCParent {
    //Soru : Bir excelde aşağıdaki bilgiler vardır
    //Bu bilgilerin yerleşeceği tabloyu kendi DB nizde MySQL arayüzünden
    //oluşturup. Burada JDBC üserinden aşağıdaki bilgileri okuyarak.
    //tabloya insert ediniz. (JDBC Mysql insert komutunun nasıl çalıştırılacağı
    //internetten araştırılacak.)
    //
    //no  ad   soyad  telefon
    //1  ismet  Temur   05053434734
    //2  mehmet Yılmaz  05053453434
    //3  Ayşe   Yıldız  0502222434
    //4  Ali    Veli    0505345434
    @BeforeTest
    public void DBConnectionOpen() {
        // baglanti islemleri

        String url = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/z_dededede";  //hotstname,port,db adını (user db)
        String username = "root";
        String password = "'\"-LhCB'.%k[4S]z";

        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement(); // sorguları çalıştırmak için page açıldı
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void test3() throws IOException, SQLException {
        String path = "src/test/java/ApachePOI/resource/JDBCOdev.xlsx";
        FileInputStream inputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);

        String sql = " insert into cucumberOdev (id, ad,soyad,telefon) values(?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row=sheet.getRow(i);
            int id=(int )row.getCell(0).getNumericCellValue();
            String ad=row.getCell(1).getStringCellValue();
            String soyad=row.getCell(2).getStringCellValue();
            long telefon= (long) row.getCell(3).getNumericCellValue();

            sql="insert into cucumberOdev values('"+id+"','"+ad+"','"+soyad+"','"+telefon +"')";
            ps.execute(sql);
            ps.execute("commit");

        }


    }


}
