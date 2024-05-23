/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

/**
 *
 * @author samue
 */
public interface Ferramenta {
    String getNome();
    String getMarca();
    double getCustoAquisicao();

    public void setNome(String novoNome);

    public void setCustoAquisicao(double novoCusto);
}


