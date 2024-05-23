/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Model.Amigo;
import Model.Emprestimo;
import Model.Ferramenta;
import java.util.List;
import java.util.Map;

/**
 *
 * @author samue
 */
public interface FerramentaDAO {
    void cadastrar(Ferramenta ferramenta);
    void atualizar(Ferramenta ferramenta);
    void excluir(Ferramenta ferramenta);
    List<Ferramenta> listar();
    List<Emprestimo> emprestimosAtivos();
    Map<Amigo, Integer> amigoComMaisEmprestimos();
}
