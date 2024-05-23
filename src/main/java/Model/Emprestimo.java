/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author samue
 */
public class Emprestimo{
    private Ferramenta ferramenta;
    private String nomeAmigo;
    private long dataEmprestimo;
    private Long dataDevolucao; // Usamos Long para poder representar a ausência de data com null

    public Emprestimo(Ferramenta ferramenta, String nomeAmigo, long dataEmprestimo) {
        this.ferramenta = ferramenta;
        this.nomeAmigo = nomeAmigo;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = null;
    }

    public Ferramenta getFerramenta() {
        return ferramenta;
    }

    public String getNomeAmigo() {
        return nomeAmigo;
    }

    public long getDataEmprestimo() {
        return dataEmprestimo;
    }

    public Long getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(long dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    @Override
    public String toString() {
        return "Ferramenta: " + ferramenta.getNome() + ", Amigo: " + nomeAmigo + 
               ", Data de Empréstimo: " + dataEmprestimo + 
               ", Data de Devolução: " + (dataDevolucao == null ? "Não devolvida" : dataDevolucao);
    }
}


