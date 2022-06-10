import javax.swing.JOptionPane;

public class Principal {
    public static void main(String[] args) {
        //1. Cadastrar nova pessoa
        //2. Atualizar dados de uma pessoa
        //3. Remover uma pessoa
        //4. Listar todas as pessoas
        String menu = "1 - Cadastrar\n2 - Atualizar\n3 - Remover\n4 - Listar\n0 - Sair";
        int op = -1;
        do {
            try{
                op = Integer.parseInt(JOptionPane.showInputDialog(menu));
                switch(op){
                    case 1:{
                        String nome = JOptionPane.showInputDialog("Nome?");
                        String telefone = JOptionPane.showInputDialog("Telefone?");
                        String email = JOptionPane.showInputDialog("E-mail?");
                        Pessoa p = new Pessoa(nome, telefone, email);
                        p.inserir();
                        JOptionPane.showMessageDialog(null, "Cadastro Ok!");
                        break;
                    }
                    case 2:{
                        String nome = JOptionPane.showInputDialog("Nome?");
                        String telefone = JOptionPane.showInputDialog("Telefone");
                        String email = JOptionPane.showInputDialog("E-mail?");
                        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Código?"));
                        Pessoa p = new Pessoa(codigo, nome, telefone, email);
                        p.atualizar();
                        JOptionPane.showMessageDialog(null, "Atualização Ok!");
                        break;
                    }
                    case 3:{
                        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Código?"));
                        Pessoa p = new Pessoa(codigo, "", "", "");
                        p.remover();
                        JOptionPane.showMessageDialog(null, "Remoção Ok!");
                        break;
                    }
                    case 4:{

                        break;
                    }
                    case 0:{

                        break;
                    }
                    default:{

                        break;
                    }
                }
            } catch(Exception e){
                JOptionPane.showMessageDialog(null, "Falha técnica. Tente novamente mais tarde.");
                e.printStackTrace();
            }
        } while(op != 0);
    }
}
