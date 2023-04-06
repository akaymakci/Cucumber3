package JDBC.Gun1;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.*;

public class _02_BeforeAfter {

    private static Connection connection;
    private static Statement statement;

    @BeforeTest
    public void DBConnectionOpen(){
        // baglanti islemleri

        String url="jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila";  //hotstname,port,db adını (user db)
        String username="root";
        String password="'\"-LhCB'.%k[4S]z";

        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement(); // sorguları çalıştırmak için page açıldı
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @AfterTest
    public void DBConnectionClose(){
        // close islemleri
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void test() throws SQLException {

        ResultSet rs = statement.executeQuery("select * from language"); // sorgu sonucu olustu ama henuz DB bekliyor


        for (int i = 0; i < 5; i++) {

            rs.next();

            String dilAdi = rs.getString(2);
            System.out.println((i + 1) + ":" + dilAdi);

        }
            // sorgu calisacak

    }
}
