package JDBC.Gun2;

import JDBC.JDBCParent;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class _03_Soru extends JDBCParent {
//    SSoru : getTable için yaptığını örneğin aynısını,
//bir XML filedan sorguyu parametre olarak göndererek bir Test için yapınız.

    @Test
    @Parameters("query")
    public void test1(String query) throws SQLException {
        ResultSet rs=statement.executeQuery(query);
        ResultSetMetaData rsmd=rs.getMetaData();

        for(int i=1; i<= rsmd.getColumnCount(); i++)
            System.out.printf("%-20s",rsmd.getColumnName(i));

        System.out.println();

        while (rs.next())           {
            for(int i=1; i<= rsmd.getColumnCount(); i++)
                System.out.printf("%-20s",rs.getString(i));

            System.out.println();
        }

        System.out.println("----------------------------------------------------------");
    }

}
