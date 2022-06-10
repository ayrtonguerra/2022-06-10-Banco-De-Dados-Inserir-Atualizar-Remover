import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    public static Connection getConnection () throws Exception {
        return DriverManager.getConnection(
            //Quando a porta é 3306, eu posso omitir, pois ela já está no código compilado
            "jdbc:mysql://localhost:3306/202201_usjt_psc_sexta_pessoas",
            "root",
            "usjt@2019"
        );
    }
}
