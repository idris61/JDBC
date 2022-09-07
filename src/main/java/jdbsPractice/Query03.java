package jdbsPractice;

import java.sql.*;

public class Query03 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed",
                "postgres",
                "Salih61");

        Statement st = con.createStatement();

        PreparedStatement ps = con.prepareStatement("SELECT * FROM OGRENCILER");

        ResultSet rs = ps.executeQuery();

        ResultSetMetaData rsmd = rs.getMetaData();

        System.out.println("Sutun Sayisi :" +rsmd.getColumnCount());

        System.out.println("1. Sutun Ismi : " + rsmd.getColumnName(1));
        System.out.println("2. Sutun Ismi : " + rsmd.getColumnName(2));
        System.out.println("3. Sutun Ismi : " + rsmd.getColumnName(3));
        System.out.println("4. Sutun Ismi : " + rsmd.getColumnName(4));

        System.out.println("1. Sutun Data Tipi : " + rsmd.getColumnTypeName(1));
        System.out.println("1. Sutun Data Tipi : " + rsmd.getColumnTypeName(2));
        System.out.println("1. Sutun Data Tipi : " + rsmd.getColumnTypeName(3));
        System.out.println("1. Sutun Data Tipi : " + rsmd.getColumnTypeName(4));

        System.out.println("Tablo ismi : " + rsmd.getTableName(2));
    }
}
