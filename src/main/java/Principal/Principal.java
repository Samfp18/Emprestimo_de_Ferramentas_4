/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import DAO.AmigoDAO;
import DAO.AmigoDAOImpl;
import DAO.FerramentaDAO;
import DAO.FerramentaDAOImpl;
import Model.Amigo;
import Model.AmigoImpl;
import Model.Emprestimo;
import Model.Ferramenta;
import Model.FerramentaImpl;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author samue
 */
public class Principal {
      private static FerramentaDAO ferramentaDAO = (FerramentaDAO) new FerramentaDAOImpl();
    private static AmigoDAO amigoDAO = new AmigoDAOImpl();


    public static void main(String[] args) {
        int opcao;
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("=== Menu Principal ===\n"
                    + "1. Gerenciar Ferramentas\n"
                    + "2. Gerenciar Amigos\n"
                    + "3. Sair\n"
                    + "Escolha uma opção:"));

            switch (opcao) {
                case 1:
                    menuFerramentas();
                    break;
                case 2:
                    menuAmigos();
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Encerrando o programa...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        } while (opcao != 3);
    }

    public static void menuFerramentas() {
        int opcao;
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("=== Menu de Ferramentas ===\n"
                    + "1. Cadastrar Ferramenta\n"
                    + "2. Visualizar Ferramentas\n"
                    + "3. Atualizar Ferramenta\n"
                    + "4. Excluir Ferramenta\n"
                    + "5. Verificar Devolução de Ferramentas\n"
                    + "6. Verificar Empréstimos Ativos\n"
                    + "7. Verificar Amigo com Mais Empréstimos\n"
                    + "8. Voltar\n"
                    + "Escolha uma opção:"));

            switch (opcao) {
                case 1:
                    cadastrarFerramenta();
                    break;
                case 2:
                    visualizarFerramentas();
                    break;
                case 3:
                    atualizarFerramenta();
                    break;
                case 4:
                    excluirFerramenta();
                    break;
                case 5:
                    verificarDevolucaoFerramentas();
                    break;
                case 6:
                    verificarEmprestimosAtivos();
                    break;
                case 7:
                    verificarAmigoMaisEmprestimos();
                    break;
                case 8:
                    JOptionPane.showMessageDialog(null, "Retornando ao menu principal...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        } while (opcao != 8);
    }

    public static void menuAmigos() {
        int opcao;
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("=== Menu de Amigos ===\n"
                    + "1. Cadastrar Amigo\n"
                    + "2. Visualizar Amigos\n"
                    + "3. Atualizar Amigo\n"
                    + "4. Excluir Amigo\n"
                    + "5. Verificar Devolução de Ferramentas\n"
                    + "6. Verificar Empréstimos Ativos\n"
                    + "7. Verificar Amigo com Mais Empréstimos\n"
                    + "8. Voltar\n"
                    + "Escolha uma opção:"));

            switch (opcao) {
                case 1:
                    cadastrarAmigo();
                    break;
                case 2:
                    visualizarAmigos();
                    break;
                case 3:
                    atualizarAmigo();
                    break;
                case 4:
                    excluirAmigo();
                    break;
                case 5:
                    verificarDevolucaoFerramentas();
                    break;
                case 6:
                    verificarEmprestimosAtivos();
                    break;
                case 7:
                    verificarAmigoMaisEmprestimos();
                    break;
                case 8:
                    JOptionPane.showMessageDialog(null, "Retornando ao menu principal...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        } while (opcao != 8);
    }

    public static void cadastrarFerramenta() {
        String nomeFerramenta = JOptionPane.showInputDialog("Nome da ferramenta:");
        String marcaFerramenta = JOptionPane.showInputDialog("Marca da ferramenta:");
        double custoFerramenta = Double.parseDouble(JOptionPane.showInputDialog("Custo de aquisição da ferramenta:"));
        Ferramenta ferramenta = new FerramentaImpl(nomeFerramenta, marcaFerramenta, custoFerramenta);
        ferramentaDAO.cadastrar(ferramenta);
        JOptionPane.showMessageDialog(null, "Ferramenta cadastrada com sucesso!");
    }

    public static void visualizarFerramentas() {
        List<Ferramenta> ferramentas = ferramentaDAO.listar();
        StringBuilder lista = new StringBuilder("Lista de Ferramentas:\n");
        for (Ferramenta ferramenta : ferramentas) {
            lista.append("Nome: ").append(ferramenta.getNome()).append(", Marca: ").append(ferramenta.getMarca()).append(", Custo: ").append(ferramenta.getCustoAquisicao()).append("\n");
        }
        JOptionPane.showMessageDialog(null, lista.toString());
    }

    public static void atualizarFerramenta() {
        String nomeFerramenta = JOptionPane.showInputDialog("Nome da ferramenta a ser atualizada:");
        Ferramenta ferramentaAtualizar = null;
        for (Ferramenta ferramenta : ferramentaDAO.listar()) {
            if (ferramenta.getNome().equals(nomeFerramenta)) {
                ferramentaAtualizar = ferramenta;
                break;
            }
        }
        if (ferramentaAtualizar != null) {
            String novoNome = JOptionPane.showInputDialog("Novo nome da ferramenta:");
            String novaMarca = JOptionPane.showInputDialog("Nova marca da ferramenta:");
            double novoCusto = Double.parseDouble(JOptionPane.showInputDialog("Novo custo da ferramenta:"));
            Ferramenta novaFerramenta = new FerramentaImpl(novoNome, novaMarca, novoCusto);
            ferramentaDAO.atualizar(novaFerramenta);
            JOptionPane.showMessageDialog(null, "Ferramenta atualizada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Ferramenta não encontrada!");
        }
    }

    public static void excluirFerramenta() {
        String nomeFerramenta = JOptionPane.showInputDialog("Nome da ferramenta a ser excluída:");
        Ferramenta ferramentaExcluir = null;
        for (Ferramenta ferramenta : ferramentaDAO.listar()) {
            if (ferramenta.getNome().equals(nomeFerramenta)) {
                ferramentaExcluir = ferramenta;
                break;
            }
        }
        if (ferramentaExcluir != null) {
            ferramentaDAO.excluir(ferramentaExcluir);
            JOptionPane.showMessageDialog(null, "Ferramenta excluída com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Ferramenta não encontrada!");
        }
    }

    public static void verificarDevolucaoFerramentas() {
        if (amigoDAO.verificarDevolucaoFerramentas()) {
            JOptionPane.showMessageDialog(null, "Todos os empréstimos foram devolvidos.");
        } else {
            JOptionPane.showMessageDialog(null, "Há empréstimos pendentes de devolução.");
        }
    }

    public static void verificarEmprestimosAtivos() {
        List<Emprestimo> emprestimosAtivos = amigoDAO.emprestimosAtivos();
        if (emprestimosAtivos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há empréstimos ativos no momento.");
        } else {
            StringBuilder lista = new StringBuilder("Empréstimos ativos:\n");
            for (Emprestimo emprestimo : emprestimosAtivos) {
                lista.append(emprestimo).append("\n");
            }
            JOptionPane.showMessageDialog(null, lista.toString());
        }
    }

    public static void verificarAmigoMaisEmprestimos() {
        Map<Amigo, Integer> amigoMaisEmprestimos = ferramentaDAO.amigoComMaisEmprestimos();
        if (amigoMaisEmprestimos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há empréstimos registrados ainda.");
        } else {
            Amigo amigo = amigoMaisEmprestimos.keySet().iterator().next();
            int numEmprestimos = amigoMaisEmprestimos.get(amigo);
            JOptionPane.showMessageDialog(null, "O amigo que mais realizou empréstimos é: " + amigo.getNome() + " com " + numEmprestimos + " empréstimos.");
        }
    }

    public static void cadastrarAmigo() {
        String nomeAmigo = JOptionPane.showInputDialog("Nome do amigo:");
        String telefoneAmigo = JOptionPane.showInputDialog("Telefone do amigo:");
        Amigo amigo = new AmigoImpl(nomeAmigo, telefoneAmigo);
        amigoDAO.cadastrar(amigo);
        JOptionPane.showMessageDialog(null, "Amigo cadastrado com sucesso!");
    }

    public static void visualizarAmigos() {
        List<Amigo> amigos = amigoDAO.listar();
        StringBuilder lista = new StringBuilder("Lista de Amigos:\n");
        for (Amigo amigo : amigos) {
            lista.append("Nome: ").append(amigo.getNome()).append(", Telefone: ").append(amigo.getTelefone()).append("\n");
        }
        JOptionPane.showMessageDialog(null, lista.toString());
    }

    public static void atualizarAmigo() {
        String nomeAmigo = JOptionPane.showInputDialog("Nome do amigo a ser atualizado:");
        Amigo amigoAtualizar = null;
        for (Amigo amigo : amigoDAO.listar()) {
            if (amigo.getNome().equals(nomeAmigo)) {
                amigoAtualizar = amigo;
                break;
            }
        }
        if (amigoAtualizar != null) {
            String novoNome = JOptionPane.showInputDialog("Novo nome do amigo:");
            String novoTelefone = JOptionPane.showInputDialog("Novo telefone do amigo:");
            Amigo novoAmigo = new AmigoImpl(novoNome, novoTelefone);
            amigoDAO.atualizar(novoAmigo);
            JOptionPane.showMessageDialog(null, "Amigo atualizado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Amigo não encontrado!");
        }
    }

    public static void excluirAmigo() {
        String nomeAmigo = JOptionPane.showInputDialog("Nome do amigo a ser excluído:");
        Amigo amigoExcluir = null;
        for (Amigo amigo : amigoDAO.listar()) {
            if (amigo.getNome().equals(nomeAmigo)) {
                amigoExcluir = amigo;
                break;
            }
        }
        if (amigoExcluir != null) {
            amigoDAO.excluir(amigoExcluir);
            JOptionPane.showMessageDialog(null, "Amigo excluído com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Amigo não encontrado!");
        }
    }
}


