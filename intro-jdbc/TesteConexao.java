// Os seus imports tem que estar vinculados ao pacote java.sql, e não para java.mysql, pois estaria dependente de uma implementação específica.
import java.sql.Connection;
import java.sql.DriverManager;
public class TesteConexao {
    public static void main(String[] args) {
        // try/catch
        // bloco principal/bloco alternativo
        try {
            // Variável de referência para a conexão com o banco de dados
            Connection minhaConexao = DriverManager.getConnection(
                //String de conexão
                "jdbc:mysql://localhost:3306/202201_usjt_psc_sexta_pessoas",
                "root",
                "usjt@2019"
            );
            System.out.println("Conexão Ok!");
            minhaConexao.close();
            System.out.println("Conexão fechada!");
        } catch(Exception e){
            e.printStackTrace();
            System.out.println("Conexão não Ok...");
        }
        
        
    }
}