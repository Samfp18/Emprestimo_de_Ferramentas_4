/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import java.util.Map;
import model.Amigo;
import model.Emprestimo;
import model.Ferramenta;

/**
 *
 * @author samue
 */
public interface FerramentaDAO {
void cadastrar(Ferramenta ferramenta);
    void atualizar(Ferramenta ferramenta);
    void excluir(Ferramenta ferramenta);
    List<Ferramenta> listar();
    void exibirEmprestimosAtivos();
    void verificarDevolucaoFerramentas();
    void menuFerramentas();
}
