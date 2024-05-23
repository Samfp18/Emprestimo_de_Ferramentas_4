/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Amigo;
import Model.Emprestimo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author samue
 */
public class AmigoDAOImpl implements AmigoDAO  { 
    private List<Amigo> amigos = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    @Override
    public void cadastrar(Amigo amigo) {
        amigos.add(amigo);
    }

    @Override
    public void atualizar(Amigo amigo) {
        // Implementação da atualização (pode ser necessário em um banco de dados real)
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
    public List<Emprestimo> emprestimosAtivos() {
        List<Emprestimo> ativos = new ArrayList<>();
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getDataDevolucao() == null) {
                ativos.add(emprestimo);
            }
        }
        return ativos;
    }

    @Override
    public boolean verificarDevolucaoFerramentas() {
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getDataDevolucao() == null) {
                return false;
            }
        }
        return true;
    }
}

