package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // 1. Adım : Driver'a kaydol.
        Class.forName("org.postgresql.Driver");
                        // postgresql driver'i aktif hale getirdik.
                        // jar file sayesinde, javanın kendi classı olan Class ından forName methodu ile
                        // jar file sayesinde""org.postgresql.Driver"" clas adı ile kayıt oluyoruz.

        // 2. Adım : Database'e bağlan.
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/techproed","postgres","Salih61");
                        // 1. adımda kayıt olduktak sonra DriverManager a artık ulaşabiliyoruz
                        // DriverManager bize connetcion saypayacak. nereye bağlandığımızı belirtmemiz lazım.
                        // getConnection methodu ==> Connection data tipi veriyor.

        // 3. Adım : Statement oluştur.    // Statement ==> connetcion'ı çalıştırıken kullandığımız konteyner
        Statement st = con.createStatement();

        // 4. Adım : Query çalıştır.

        // 1.Example: "workers" adında bir table oluşturup "worker_id,worker_name, worker_salary" sütunlarını ekleyin.

        String sql1 = "CREATE TABLE workers(worker_id VARCHAR(50), worker_name VARCHAR(50), worker_salary INT)";
        // method içerisinde bu kadar uzun cod kullanmamak için string value ya atama yaptık.

        boolean result = st.execute(sql1);
        System.out.println(result);  // false return yapar, çünkü data çağırmadı.

        // 2.Örnek: Table'a worker_address sütunu ekleyerel alter yapın.

                // 1. örnekte tablo oluşturduğumuz için yeni yapacağımız işlemde hata alırız.
                // yeni işlem öncessi drop table ile tabloyu sql den silmeliyiz.

        String sql2 = "ALTER TABLE workers ADD worker_address VARCHAR(80)";
        st.execute(sql2);

        // 3.Örnek: Drop workers table
        String sql3 = "DROP TABLE workers";  // drop table'ı sql yerine bu şekilde de yapabiliriz.
        st.execute(sql3);

        // 5. Adım : Bağlantı ve Statement'i kapat
        con.close();
        st.cancel();

    }
}

    /*
    Statement : Statik bir SQL ifadesi yürütmek ve ürettiği sonuçları döndürmek için kullanılan nesne.
    Varsayılan olarak, aynı anda Statement nesnesi başına yalnızca bir ResultSet nesnesi açılabilir.
    Bu nedenle, bir ResultSet nesnesinin okuması diğerinin okumasıyla aralanmışsa, her biri farklı
    Statement nesneleri tarafından oluşturulmuş olmalıdır. Açık bir varsa, Statement arabirimindeki
    tüm yürütme yöntemleri, ifadenin geçerli bir ResultSet nesnesini örtük olarak kapatır.
     */