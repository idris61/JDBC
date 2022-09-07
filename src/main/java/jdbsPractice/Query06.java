package jdbsPractice;

import java.sql.SQLException;

import static jdbsPractice.DatabaseUtilty.*;

public class Query06 {

    public static void main(String[] args) throws SQLException {

        createConnection();

        String query = "select * from ogrenciler";
        System.out.println("Sutun isimleri : " + getColumnNames(query));

        System.out.println("Okul No: " + getColumnData(query, "okul_no"));
        System.out.println("Ogrenci ismi: " + getColumnData(query, "ogrenci_ismi"));
        System.out.println("Sinif: " + getColumnData(query, "sinif"));
        System.out.println("Cinsiyet: " + getColumnData(query, "cinsiyet"));
    }
}
