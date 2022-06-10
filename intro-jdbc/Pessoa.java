import java.sql.Connection;
import java.sql.PreparedStatement;

public class Pessoa {
    private int codigo;
    private String nome;
    private String telefone;
    private String email;

    public Pessoa(String nome, String telefone, String email){
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public Pessoa(int codigo, String nome, String telefone, String email){
        this(nome, telefone, email);
        this.codigo = codigo;
    }

    //Por questões de simplicidade, vamos violar o princípio de alta coesão, trazendo mais responsabilidades para a classe Pessoa, para facilitar um pouco o desenvolvimento do código para essa aula.
    public void inserir() throws Exception {
        //1. Especificar o comando SQL
        //Os ? são os placeholders, semelhantes ao printf
        //Os placeholders são sequenciais, começando em 1
        String sql = "INSERT INTO tb_pessoa (nome, fone, email) VALUES (?, ?, ?)";

        //2. Abrir uma conexão com o SGBD
        Connection conexao = ConnectionFactory.getConnection();

        //3. Por meio da conexão, "preparar o comando"
        //Cria uma estrutura de dados eficiente para executar o comando sql, mas não executa ainda
        PreparedStatement ps = conexao.prepareStatement(sql);

        //4. Substituir eventuais placeholders
        ps.setString(1, nome);
        ps.setString(2, telefone);
        ps.setString(3, email);

        //5. Executar o comando
        ps.execute();

        //6. Fechar os recursos
        ps.close();
        conexao.close();
    }

    //Por questões de simplicidade, vamos violar o princípio de alta coesão, trazendo mais responsabilidades para a classe Pessoa, para facilitar um pouco o desenvolvimento do código para essa aula.
    public void atualizar() throws Exception {
        //try-with-resources (a partir do Java 7)
        //eu posso utilizar essa estrutura para ela fechar automaticamente uma conexao ou um object Closeable (fechável)
        // Você pode usar o try-with-resources para fazer connection pool (guardar uma coleção de conexões para que o programa posso pegar dessa coleção e devolver, pois o processo de abrir a conexão é mais cara e demora na ordem de milissegundos - o que é muito tempo para um sistema computacional)
        //1. Especificar o comando SQL
        String sql = "UPDATE tb_pessoa SET nome = ?, fone = ?, email = ? WHERE cod_pessoa = ?";
        try(
            Connection conexao = ConnectionFactory.getConnection();
            PreparedStatement ps = conexao.prepareStatement(sql);
        ){
            //4. Substituir eventuais placeholders
            ps.setString(1, nome);
            ps.setString(2, telefone);
            ps.setString(3, email);
            ps.setInt(4, codigo);

            //5. Executar o comando
            ps.execute();
        }
    }

    public void remover() throws Exception {
        //1. Especificar o comando SQL
        String sql = "DELETE FROM tb_pessoa WHERE cod_pessoa = ?";

        //2. Abrir uma conexão com o SGBD
        Connection conexao = ConnectionFactory.getConnection();

        //3. Por meio da conexão, "preparar o comando"
        PreparedStatement ps = conexao.prepareStatement(sql);

        //4. Substituir eventuais placeholders
        ps.setInt(1, codigo);

        //5. Executar o comando
        ps.execute();

        //6. Fechar os recursos
        ps.close();
        conexao.close();
    }

    public void remover() throws Exception {
        //utilizando o try-with-resources
        //1. Especificar o comando SQL
        String sql = "DELETE FROM tb_pessoa WHERE cod_pessoa = ?";
        try(
            //2. Abrir uma conexão com o SGBD
            Connection conexao = ConnectionFactory.getConnection();
            //3. Por meio da conexão, "preparar o comando"
            PreparedStatement ps = conexao.prepareStatement(sql);
        ) {
            //4. Substituir eventuais placeholders
            ps.setInt(1, codigo);

            //5. Executar o comando
            ps.execute();
        }
    }
}
