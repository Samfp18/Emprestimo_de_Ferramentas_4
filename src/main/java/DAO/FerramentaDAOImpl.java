/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Emprestimo;
import model.Ferramenta;
import model.FerramentaImpl;

/**
 *
 * @author samue
 */
public class FerramentaDAOImpl  implements FerramentaDAO {
     
private List<Ferramenta> ferramentas = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    @Override
    public void cadastrar(Ferramenta ferramenta) {
        ferramentas.add(ferramenta);
    }

    @Override
    public void atualizar(Ferramenta ferramenta) {
        for (int i = 0; i < ferramentas.size(); i++) {
            Ferramenta f = ferramentas.get(i);
            if (f.getNome().equals(ferramenta.getNome())) {
                ferramentas.set(i, ferramenta);
                break;
            }
        }
    }

    @Override
    public void excluir(Ferramenta ferramenta) {
        ferramentas.remove(ferramenta);
    }

    @Override
    public List<Ferramenta> listar() {
        return ferramentas;
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
    public void menuFerramentas() {
        int opcao;
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("=== Menu de Ferramentas ===\n"
                    + "1. Cadastrar Ferramenta\n"
                    + "2. Visualizar Ferramentas\n"
                    + "3. Atualizar Ferramenta\n"
                    + "4. Excluir Ferramenta\n"
                    + "5. Exibir Empréstimos Ativos\n"
                    + "6. Verificar Devolução de Ferramentas\n"
                    + "7. Emprestar Ferramenta\n"
                    + "8. Devolver Ferramenta\n"
                    + "9. Resumo Geral de Empréstimos\n"
                    + "10. Voltar\n"
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
                    exibirEmprestimosAtivos();
                    break;
                case 6:
                    verificarDevolucaoFerramentas();
                    break;
                case 7:
                    emprestarFerramenta();
                    break;
                case 8:
                    devolverFerramenta();
                    break;
                case 9:
                    resumoGeralEmprestimos();
                    break;
                case 10:
                    JOptionPane.showMessageDialog(null, "Retornando ao menu principal...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        } while (opcao != 10);
    }

    public void cadastrarFerramenta() {
        String nomeFerramenta = JOptionPane.showInputDialog("Nome da ferramenta:");
        String marcaFerramenta = JOptionPane.showInputDialog("Marca da ferramenta:");
        double custoFerramenta = Double.parseDouble(JOptionPane.showInputDialog("Custo de aquisição da ferramenta:"));
        Ferramenta ferramenta = new FerramentaImpl(nomeFerramenta, marcaFerramenta, custoFerramenta);
        cadastrar(ferramenta);
        JOptionPane.showMessageDialog(null, "Ferramenta cadastrada com sucesso!");
    }

    public void visualizarFerramentas() {
        List<Ferramenta> ferramentas = listar();
        StringBuilder lista = new StringBuilder("Lista de Ferramentas:\n");
        for (Ferramenta ferramenta : ferramentas) {
            lista.append("Nome: ").append(ferramenta.getNome()).append(", Marca: ").append(ferramenta.getMarca()).append(", Custo: ").append(ferramenta.getCustoAquisicao()).append("\n");
        }
        JOptionPane.showMessageDialog(null, lista.toString());
    }

    public void atualizarFerramenta() {
        String nomeFerramenta = JOptionPane.showInputDialog("Nome da ferramenta a ser atualizada:");
        Ferramenta ferramentaAtualizar = null;
        for (Ferramenta ferramenta : listar()) {
            if (ferramenta.getNome().equals(nomeFerramenta)) {
                ferramentaAtualizar = ferramenta;
                break;
            }
        }
        if (ferramentaAtualizar != null) {
            String novoNome = JOptionPane.showInputDialog("Novo nome da ferramenta:");
            double novoCusto = Double.parseDouble(JOptionPane.showInputDialog("Novo custo da ferramenta:"));
            Ferramenta novaFerramenta = new FerramentaImpl(novoNome, ferramentaAtualizar.getMarca(), novoCusto);
            atualizar(novaFerramenta);
            JOptionPane.showMessageDialog(null, "Ferramenta atualizada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Ferramenta não encontrada!");
        }
    }

    public void excluirFerramenta() {
        String nomeFerramenta = JOptionPane.showInputDialog("Nome da ferramenta a ser excluída:");
        Ferramenta ferramentaExcluir = null;
        for (Ferramenta ferramenta : listar()) {
            if (ferramenta.getNome().equals(nomeFerramenta)) {
                ferramentaExcluir = ferramenta;
                break;
            }
        }
        if (ferramentaExcluir != null) {
            excluir(ferramentaExcluir);
            JOptionPane.showMessageDialog(null, "Ferramenta excluída com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Ferramenta não encontrada!");
        }
    }

    public void emprestarFerramenta() {
        String nomeFerramenta = JOptionPane.showInputDialog("Nome da ferramenta a ser emprestada:");
        Ferramenta ferramentaEmprestar = null;
        for (Ferramenta ferramenta : listar()) {
            if (ferramenta.getNome().equals(nomeFerramenta)) {
                ferramentaEmprestar = ferramenta;
                break;
            }
        }
        if (ferramentaEmprestar != null) {
            String nomeAmigo = JOptionPane.showInputDialog("Nome do amigo que está pegando emprestado:");
            long dataEmprestimo = Long.parseLong(JOptionPane.showInputDialog("Data de Empréstimo (timestamp):"));
            Emprestimo emprestimo = new Emprestimo(ferramentaEmprestar, nomeAmigo, dataEmprestimo);
            emprestimos.add(emprestimo);
            JOptionPane.showMessageDialog(null, "Ferramenta emprestada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Ferramenta não encontrada!");
        }
    }

    public void devolverFerramenta() {
        String nomeFerramenta = JOptionPane.showInputDialog("Nome da ferramenta a ser devolvida:");
        Emprestimo emprestimoDevolver = null;
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getFerramenta().getNome().equals(nomeFerramenta) && emprestimo.getDataDevolucao() == null) {
                emprestimoDevolver = emprestimo;
                break;
            }
        }
        if (emprestimoDevolver != null) {
            long dataDevolucao = Long.parseLong(JOptionPane.showInputDialog("Data de Devolução (timestamp):"));
            emprestimoDevolver.setDataDevolucao(dataDevolucao);
            JOptionPane.showMessageDialog(null, "Ferramenta devolvida com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Empréstimo não encontrado ou ferramenta já devolvida!");
        }
    }

    public void resumoGeralEmprestimos() {
        StringBuilder resumo = new StringBuilder("Resumo Geral de Empréstimos:\n");
        for (Emprestimo emprestimo : emprestimos) {
            resumo.append("Ferramenta: ").append(emprestimo.getFerramenta().getNome())
                  .append(", Amigo: ").append(emprestimo.getNomeAmigo())
                  .append(", Data de Empréstimo: ").append(emprestimo.getDataEmprestimo())
                  .append(", Data de Devolução: ").append(emprestimo.getDataDevolucao() == null ? "Não devolvida" : emprestimo.getDataDevolucao())
                  .append("\n");
        }
        JOptionPane.showMessageDialog(null, resumo.toString());
    }
}

