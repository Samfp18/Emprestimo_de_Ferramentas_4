/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import model.Amigo;

/**
 *
 * @author samue
 */
public interface AmigoDAO {
    void cadastrar(Amigo amigo);
    void atualizar(Amigo amigo);
    void excluir(Amigo amigo);
    List<Amigo> listar();
    void exibirEmprestimosAtivos();
    void verificarDevolucaoFerramentas();
    void menuAmigos();
}

