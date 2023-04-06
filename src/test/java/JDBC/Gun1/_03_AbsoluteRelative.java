package JDBC.Gun1;

import JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _03_AbsoluteRelative extends JDBCParent {

    @Test
    private void test1() throws SQLException {
        // next(): bir sonraki row
        // previous() : bir önceki row
        // absolute(4) : baştan itibaren 4.ROW a gider, direkt verine ROW a gider
        // relative(4) : bulunduğu noktadan 4 sonraki ROW a gider.

        ResultSet rs = statement.executeQuery("select * from film");

        rs.absolute(10) ; // 10.satıra git
        String title=rs.getString("title");
        System.out.println("title = " + title);

        rs.absolute(15) ; // 15.satıra git
        title=rs.getString("title");
        System.out.println("title = " + title);

        rs.absolute(-15) ; // (-)sondan 15.satıra git   //WONKA
        title=rs.getString("title");
        System.out.println("title = " + title);

        rs.relative(5) ; // en son bulunduğun yerden 5 satır ileri
        title=rs.getString("title");
        System.out.println("title = " + title);

        rs.relative(-5) ; // en son bulunduğun yerden 5 satır geri
        title=rs.getString("title");
        System.out.println("title = " + title);


    }

}
