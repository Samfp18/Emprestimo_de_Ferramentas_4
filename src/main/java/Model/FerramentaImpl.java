/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author samue
 */
public class FerramentaImpl implements Ferramenta {
    private String nome;
    private String marca;
    private double custoAquisicao;

    public FerramentaImpl(String nome, String marca, double custoAquisicao) {
        this.nome = nome;
        this.marca = marca;
        this.custoAquisicao = custoAquisicao;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String getMarca() {
        return marca;
    }

    @Override
    public double getCustoAquisicao() {
        return custoAquisicao;
    }
}

interface Amigo {
    String getNome();
    String getTelefone();
}

