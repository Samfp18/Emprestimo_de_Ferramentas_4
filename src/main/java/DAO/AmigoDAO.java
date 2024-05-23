/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Model.Amigo;
import Model.Emprestimo;
import java.util.List;

/**
 *
 * @author samue
 */
public interface AmigoDAO {
     void cadastrar(Amigo amigo);
    void atualizar(Amigo amigo);
    void excluir(Amigo amigo);
    List<Amigo> listar();
    List<Emprestimo> emprestimosAtivos();
    boolean verificarDevolucaoFerramentas();
}
