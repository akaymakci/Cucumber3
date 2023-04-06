package JDBC;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCParent {
    public static Connection connection;
    public static Statement statement;

    @BeforeTest
    public void DBConnectionOpen() throws FileNotFoundException {
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
}
