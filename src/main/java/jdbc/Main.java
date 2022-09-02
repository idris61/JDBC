package jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        //DBWork objesini oluştur.
        DBWork db = new DBWork();

        // Connection methodunu çağır.
        Connection con = db.connect_to_db("techproed","postgres","Salih61");

        // Yeni table oluştu0rma methodunu çağır
        db.createTable(con,"employees");
    }
}
