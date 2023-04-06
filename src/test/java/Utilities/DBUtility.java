package Utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtility {

    private static Connection connection;
    protected static Statement statement;
    private static void DBConnectionOpen()
    {
        String url="jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/sakila";
        String username="root";
        String password="'\"-LhCB'.%k[4S]z";

        try {
            connection = DriverManager.getConnection(url, username, password);
            statement= connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void DBConnectionClose()
    {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {  // test main
        List<List<String>> tablo=getListData("select * from actor");

        for(List<String> satir : tablo) // tes için kontrol , veriler geldi mi, liste atıldı mı
            System.out.println("satir = " + satir);
    }


    public static List<List<String>> getListData(String sorgu){
        List<List<String>> tablo=new ArrayList<>();
        //db den bütün satırları ve sütunları okuyup bu liste atıcam

        // db bağlantıyı aç
        DBConnectionOpen();

        try {
            //1- sorguyu çalıştır
            ResultSet rs = statement.executeQuery(sorgu);
            //2- bütün satırları ve o satırlardaki sütunları oku Tabloya ekle
            int columnSayisi =rs.getMetaData().getColumnCount();

            while (rs.next())
            {
                List<String> satir=new ArrayList<>();
                for(int i=1; i<= columnSayisi ;i++)
                {
                    satir.add(rs.getString(i));
                }

                tablo.add(satir);
            }

        }
        catch (Exception ex){
            System.out.println("ex.getMessage() = " + ex.getMessage());
        }

        DBConnectionClose();
        //db bağlantısı kapat
        return tablo;
    }

}
