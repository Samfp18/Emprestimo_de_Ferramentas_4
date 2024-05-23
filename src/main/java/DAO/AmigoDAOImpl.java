/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Amigo;
import model.AmigoImpl;
import model.Emprestimo;
import model.Ferramenta;

/**
 *
 * @author samue
 */
public class AmigoDAOImpl implements AmigoDAO {

   private List<Amigo> amigos = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    @Override
    public void cadastrar(Amigo amigo) {
        amigos.add(amigo);
    }

    @Override
    public void atualizar(Amigo amigo) {
        for (int i = 0; i < amigos.size(); i++) {
            Amigo a = amigos.get(i);
            if (a.getNome().equals(amigo.getNome())) {
                amigos.set(i, amigo);
                break;
            }
        }
    }

    @Override
    public void excluir(Amigo amigo) {
        amigos.remove(amigo);
    }

    @Override
    public List<Amigo> listar() {
        return amigos;
    }

    @Override
    public void exibirEmprestimosAtivos() {
        List<Emprestimo> ativos = new ArrayList<>();
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getDataDevolucao() == null) {
                ativos.add(emprestimo);
            }
        }
        if (ativos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há empréstimos ativos.");
        } else {
            StringBuilder lista = new StringBuilder("Empréstimos Ativos:\n");
            for (Emprestimo emprestimo : ativos) {
                lista.append(emprestimo).append("\n");
            }
            JOptionPane.showMessageDialog(null, lista.toString());
        }
    }

    @Override
    public void verificarDevolucaoFerramentas() {
        boolean todasDevolvidas = true;
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getDataDevolucao() == null) {
                todasDevolvidas = false;
                break;
            }
        }
        if (todasDevolvidas) {
            JOptionPane.showMessageDialog(null, "Todos os empréstimos foram devolvidos.");
        } else {
            JOptionPane.showMessageDialog(null, "Existem empréstimos pendentes.");
        }
    }

    @Override
    public void menuAmigos() {
        int opcao;
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("=== Menu de Amigos ===\n"
                    + "1. Cadastrar Amigo\n"
                    + "2. Visualizar Amigos\n"
                    + "3. Atualizar Amigo\n"
                    + "4. Excluir Amigo\n"
                    + "5. Exibir Empréstimos Ativos\n"
                    + "6. Verificar Devolução de Ferramentas\n"
                    + "7. Voltar\n"
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
                    exibirEmprestimosAtivos();
                    break;
                case 6:
                    verificarDevolucaoFerramentas();
                    break;
                case 7:
                    JOptionPane.showMessageDialog(null, "Retornando ao menu principal...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        } while (opcao != 7);
    }

    public void cadastrarAmigo() {
        String nomeAmigo = JOptionPane.showInputDialog("Nome do amigo:");
        String telefoneAmigo = JOptionPane.showInputDialog("Telefone do amigo:");
        Amigo amigo = new AmigoImpl(nomeAmigo, telefoneAmigo);
        cadastrar(amigo);
        JOptionPane.showMessageDialog(null, "Amigo cadastrado com sucesso!");
    }

    public void visualizarAmigos() {
        List<Amigo> amigos = listar();
        StringBuilder lista = new StringBuilder("Lista de Amigos:\n");
        for (Amigo amigo : amigos) {
            lista.append("Nome: ").append(amigo.getNome()).append(", Telefone: ").append(amigo.getTelefone()).append("\n");
        }
        JOptionPane.showMessageDialog(null, lista.toString());
    }

    public void atualizarAmigo() {
        String nomeAmigo = JOptionPane.showInputDialog("Nome do amigo a ser atualizado:");
        Amigo amigoAtualizar = null;
        for (Amigo amigo : listar()) {
            if (amigo.getNome().equals(nomeAmigo)) {
                amigoAtualizar = amigo;
                break;
            }
        }
        if (amigoAtualizar != null) {
            String novoNome = JOptionPane.showInputDialog("Novo nome do amigo:");
            String novoTelefone = JOptionPane.showInputDialog("Novo telefone do amigo:");
            Amigo novoAmigo = new AmigoImpl(novoNome, novoTelefone);
            atualizar(novoAmigo);
            JOptionPane.showMessageDialog(null, "Amigo atualizado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Amigo não encontrado!");
        }
    }

    public void excluirAmigo() {
        String nomeAmigo = JOptionPane.showInputDialog("Nome do amigo a ser excluído:");
        Amigo amigoExcluir = null;
        for (Amigo amigo : listar()) {
            if (amigo.getNome().equals(nomeAmigo)) {
                amigoExcluir = amigo;
                break;
            }
        }
        if (amigoExcluir != null) {
            excluir(amigoExcluir);
            JOptionPane.showMessageDialog(null, "Amigo excluído com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Amigo não encontrado!");
        }
    }
}



